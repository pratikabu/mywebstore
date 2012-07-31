package mws.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.utils.SearchHelper;
import mws.utils.Utility;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check the credentials. if every thing is fine redirect to the address selection page.
    	String email = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	if(SearchHelper.getFacade().isValidCustomer(email, password)) {
    		request.getSession().setAttribute(Utility.USERID_SESSION_KEY, email);
    		response.sendRedirect("addressSelect.jsp");
    	} else {
    		response.sendRedirect("login.jsp?error=true");
    	}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(null != req.getParameter("logout")) {
			req.getSession().removeAttribute(Utility.USERID_SESSION_KEY);
		}
		
		resp.sendRedirect("index.jsp");
	}

}
