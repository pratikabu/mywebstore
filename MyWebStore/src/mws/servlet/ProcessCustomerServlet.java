package mws.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.model.Customer;
import mws.utils.SearchHelper;

/**
 * Servlet implementation class ProcessCustomerServlet
 */
public class ProcessCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessCustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setPhone(request.getParameter("phone"));
		customer.setMobile(request.getParameter("mobile"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		if(SearchHelper.getFacade().saveModel(customer)) {
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("customer.jsp?error=true");
		}
	}

}
