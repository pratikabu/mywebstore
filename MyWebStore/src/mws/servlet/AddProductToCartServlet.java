package mws.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mws.model.LineItem;
import mws.model.OrderDetail;
import mws.model.Product;
import mws.utils.SearchHelper;
import mws.utils.Utility;

/**
 * Servlet implementation class AddProductToCartServlet
 */
public class AddProductToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductToCartServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDetail cartOrder = SearchHelper.getFacade().getCartOrder(request.getSession());
		List<LineItem> lineItems;
		if(null == cartOrder) {
			cartOrder = new OrderDetail();
			request.getSession().setAttribute(Utility.CART_SESSION_KEY, cartOrder);
			
			lineItems = new ArrayList<LineItem>();
		} else {
			lineItems = cartOrder.getLineItems();
		}
		
		String quantity = request.getParameter("quantity");
		String pid = request.getParameter("pid");
		
		LineItem li = new LineItem();
		li.setOrder(cartOrder);
		li.setProduct(SearchHelper.getFacade().readModelWithId(Product.class, Integer.parseInt(pid)));
		li.setQuantity(Integer.parseInt(quantity));
		
		lineItems.add(li);
		
		cartOrder.setLineItems(lineItems);
		response.sendRedirect("cart.jsp");
	}

}
