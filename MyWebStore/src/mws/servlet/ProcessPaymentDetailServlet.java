package mws.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.model.Customer;
import mws.model.PaymentDetail;
import mws.utils.SearchHelper;

/**
 * Servlet implementation class ProcessPaymentDetailServlet
 */
public class ProcessPaymentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessPaymentDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer)SearchHelper.getFacade().getCurrentUser(request.getSession());
		PaymentDetail pd = new PaymentDetail();
		pd.setCardType(request.getParameter("cardType"));
		pd.setCcNumber(request.getParameter("cardNumber"));
		pd.setCcPin(request.getParameter("pin"));
		pd.setCustomer(customer);
		
		if(SearchHelper.getFacade().saveModel(pd)) {
			response.sendRedirect("paymentSelect.jsp");
		} else {
			response.sendRedirect("paymentDetail.jsp?error=true");
		}
	}

}
