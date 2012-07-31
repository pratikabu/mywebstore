package mws.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.model.Address;
import mws.model.Customer;
import mws.utils.SearchHelper;

/**
 * Servlet implementation class ProcessAddressDetailsServlet
 */
public class ProcessAddressDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAddressDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address address = new Address();
		address.setFirstLine(request.getParameter("addLine1"));
		address.setSecondLine(request.getParameter("addLine2"));
		address.setThirdLine(request.getParameter("addLine3"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setCountry(request.getParameter("country"));
		
		address.setCustomer((Customer)SearchHelper.getFacade().getCurrentUser(request.getSession()));
		
		if(SearchHelper.getFacade().saveModel(address)) {
			response.sendRedirect("addressSelect.jsp");
		} else {
			response.sendRedirect("address.jsp?error=true");
		}
	}

}
