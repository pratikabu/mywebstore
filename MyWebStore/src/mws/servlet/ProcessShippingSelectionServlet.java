package mws.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.model.OrderDetail;
import mws.model.ShippingMode;
import mws.utils.SearchHelper;

/**
 * Servlet implementation class ProcessShippingSelectionServlet
 */
public class ProcessShippingSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessShippingSelectionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//save the selection in the cart order and proceed to order summary
		OrderDetail cartOrder = SearchHelper.getFacade().getCartOrder(request.getSession());
		if(null != cartOrder) {
			int shippingModeId = Integer.parseInt(request.getParameter("shippingMode"));
			ShippingMode shippingMode = SearchHelper.getFacade().readModelWithId(ShippingMode.class, shippingModeId);
			cartOrder.setShippingMode(shippingMode);
			
			response.sendRedirect("orderDetail.jsp");
		} else {
			response.sendRedirect("shippingModeSelect.jsp?noselect=true");
		}
	}

}
