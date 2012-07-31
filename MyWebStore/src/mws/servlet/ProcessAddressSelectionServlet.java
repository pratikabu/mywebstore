package mws.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.model.Address;
import mws.model.OrderDetail;
import mws.utils.SearchHelper;

/**
 * Servlet implementation class ProcessAddressSelectionServlet
 */
public class ProcessAddressSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAddressSelectionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionType = request.getParameter("actionType");
		
		int addressId = Integer.parseInt(request.getParameter("address"));
		Address address = SearchHelper.getFacade().readModelWithId(Address.class, addressId);
		
		if(null == actionType) {
			//save the selection in the cart order and proceed to shipping mode selection
			OrderDetail cartOrder = SearchHelper.getFacade().getCartOrder(request.getSession());
			if(null != cartOrder) {
				cartOrder.setAddress(address);
				
				response.sendRedirect("shippingModeSelect.jsp");
			} else {
				response.sendRedirect("addressSelect.jsp?noselect=true");
			}
		} else {// remove the record
			if(SearchHelper.getFacade().deleteModel(address)) {
				response.sendRedirect("myAccount.jsp");
			} else {
				response.sendRedirect("myAccount.jsp?errorRemAdd=true");
			}
		}
	}

}
