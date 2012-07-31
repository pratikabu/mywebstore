package mws.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.model.Customer;
import mws.model.OrderDetail;
import mws.model.PaymentDetail;
import mws.utils.SearchHelper;
import mws.utils.Services;
import mws.utils.Utility;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ProcessOrderPaymentServlet
 */
public class ProcessOrderPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProcessOrderPaymentServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessOrderPaymentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paymentOptionId = Integer.parseInt(request.getParameter("paymentOption"));
		PaymentDetail paymentDetail = SearchHelper.getFacade().readModelWithId(PaymentDetail.class, paymentOptionId);
		
		String actionType = request.getParameter("actionType");
		if("remove".equals(actionType)) {// remove the record
			// this code is added just to delete the content.
			if(SearchHelper.getFacade().deleteModel(paymentDetail)) {
				response.sendRedirect("myAccount.jsp");
			} else {
				response.sendRedirect("myAccount.jsp?errorRemAdd=true");
			}
		} else { // process the order
			OrderDetail cartOrder = SearchHelper.getFacade().getCartOrder(request.getSession());
			
			boolean success = true;
			if(null != cartOrder) {
				cartOrder.setPaymentDetail(paymentDetail);
				
				cartOrder.setCustomer((Customer)SearchHelper.getFacade().getCurrentUser(request.getSession()));
				
				double orderTotal = SearchHelper.calculateCartTotal(request.getSession());// calculate cart total.
				// process the payment for this order total
				success = Services.processPayment(paymentDetail, orderTotal);
				if(success) {
					// set the timestamp
					cartOrder.setOrderDate(new Date());
					
					// generate unique orderId
					String orderId = "MWS" + "EN" + System.currentTimeMillis();
					cartOrder.setOrderId(orderId);
					// place the order for this customer
					// save this order in the DB
					success = SearchHelper.getFacade().saveModel(cartOrder);
					if(success) {
						//remove cartOrder from the session
						request.getSession().removeAttribute(Utility.CART_SESSION_KEY);
						
						// show the success page with order number
						response.sendRedirect("orderSuccess.jsp?orderId=" + orderId);
					} else {
						// refund the payment charged and show error page
						logger.error("The order placment failed due to error in saving. OrderId: " + orderId);
					}
				}
			} else {
				logger.error("There is no order in the cart.");
			}
			
			if(!success) {
				response.sendRedirect("orderError.jsp");
			}
		}
	}

}
