/**
 * 
 */
package mws.utils;

import javax.servlet.http.HttpSession;

import mws.model.LineItem;
import mws.model.OrderDetail;
import mws.model.ProductPricing;
import mws.utils.impl.SearchFacadeImpl;

/**
 * @author pratsoni
 *
 */
public class SearchHelper {
	private static SearchFacade facade;
	
	static {
		facade = new SearchFacadeImpl();
	}
	
	public static SearchFacade getFacade() {
		return facade;
	}

	public static double calculateCartTotal(HttpSession session) {
		return calculateCartTotal(session, facade.getCartOrder(session));
	}
	
	public static double calculateCartTotal(HttpSession session, OrderDetail order) {
		double cartTotal = 0;
		
		for(LineItem li : order.getLineItems()) {
			cartTotal += findProductPrice(li.getProduct().getProductId(), session) * li.getQuantity();
		}
		
		return cartTotal;
	}
	
	public static double findProductPrice(int productId, HttpSession session) {
		String siteInfo = (String)session.getAttribute(Utility.SITE_INFO_KEY);
		if(null == siteInfo) {
			siteInfo = "en";
		}
		
		ProductPricing pp = facade.getProductPrice(productId, siteInfo);
		return pp == null ? 0 : pp.getAmount();
	}
}
