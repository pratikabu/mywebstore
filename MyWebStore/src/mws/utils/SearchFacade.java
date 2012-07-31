/**
 * 
 */
package mws.utils;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import mws.model.Address;
import mws.model.LineItem;
import mws.model.OrderDetail;
import mws.model.PaymentDetail;
import mws.model.Product;
import mws.model.ProductPricing;
import mws.model.ShippingMode;
import mws.model.WSUser;

/**
 * @author pratsoni
 *
 */
public interface SearchFacade {

	public List<Product> getProducts();
	
	/**
	 * This method will pull the order from the cart which is stored in the session.
	 * @param session
	 * @return
	 */
	public OrderDetail getCartOrder(HttpSession session);

	public boolean isValidCustomer(String username, String password);
	
	public List<Address> getAddressForCurrentUser(HttpSession session);
	
	public List<PaymentDetail> getPaymentDetailForCurrentUser(HttpSession session);
	
	public List<OrderDetail> getOrdersForCurrentUser(HttpSession session);
	
	public List<ShippingMode> getShippingMode();

	public <T> T readModelWithId(Class<T> c, Serializable primaryKey);
	
	public WSUser getCurrentUser(HttpSession session);
	
	/**
	 * This method will save the model in the database.
	 * @param t
	 * @return
	 */
	public <T> boolean saveModel(T t);
	
	/**
	 * This method will remove the 
	 * @param t
	 * @return
	 */
	public <T> boolean deleteModel(T t);
	
	public List<LineItem> getLineItemsForOrder(String orderId);

	public ProductPricing getProductPrice(int productId, String siteInfo);
}
