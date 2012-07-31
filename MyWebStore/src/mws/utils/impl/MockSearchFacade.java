/**
 * 
 */
package mws.utils.impl;

import java.io.Serializable;
import java.util.ArrayList;
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
import mws.utils.SearchFacade;

/**
 * @author pratsoni
 *
 */
public class MockSearchFacade implements SearchFacade {
	
	@Override
	public List<Product> getProducts() {
		List<Product> prods = new ArrayList<Product>();
		
		for(int i = 0; i < 6; i++) {
			Product p = new Product();
			p.setProductId(i);
			p.setProductName("My Mobile " + (i + 1));
			p.setProductDetail("did you like this mobile<br/>this is an awesome<br/> " + p.getProductName());
			
			prods.add(p);
		}
		
		return prods;
	}
	
	/**
	 * This method will pull the order from the cart which is stored in the session.
	 * @param session
	 * @return
	 */
	@Override
	public OrderDetail getCartOrder(HttpSession session) {
		OrderDetail o = new OrderDetail();
		int qty = 1;
		List<LineItem> lis = new ArrayList<LineItem>();
		for(Product p : getProducts()) {
			LineItem li = new LineItem();
			li.setProduct(p);
			li.setQuantity(qty++);
			li.setOrder(o);
			lis.add(li);
		}
		o.setLineItems(lis);
		return o;
	}

	@Override
	public boolean isValidCustomer(String username, String password) {
		return "admin".equals(username) && "admin".equals(password);
	}

	@Override
	public List<Address> getAddressForCurrentUser(HttpSession session) {
		List<Address> addresses = new ArrayList<Address>();
		
		for(int i = 0; i < 6; i++) {
			Address a = new Address();
			a.setAddressId(i);
			a.setFirstLine("First" + i);
			a.setSecondLine("Second" + i);
			a.setThirdLine("Third" + i);
			a.setCity("City" + i);
			a.setState("State" + i);
			a.setCountry("Country" + i);
			
			addresses.add(a);
		}
		
		return addresses;
	}

	@Override
	public List<PaymentDetail> getPaymentDetailForCurrentUser(HttpSession session) {
		List<PaymentDetail> paymentDetails = new ArrayList<PaymentDetail>();
		
		PaymentDetail pd;
		
		pd = new PaymentDetail();
		pd.setPaymentDetailId(1);
		pd.setCcNumber("3241 2345 1234 2342");
		pd.setCardType("Visa");
		pd.setCcPin("2312");
		paymentDetails.add(pd);
		
		pd = new PaymentDetail();
		pd.setPaymentDetailId(2);
		pd.setCcNumber("3241 2345 1232 2341");
		pd.setCardType("Master Card");
		pd.setCcPin("2313");
		paymentDetails.add(pd);
		
		return paymentDetails;
	}

	@Override
	public List<ShippingMode> getShippingMode() {
		List<ShippingMode> shippingModes = new ArrayList<ShippingMode>();
		
		for(int i = 0; i < 5; i++) {
			ShippingMode sm = new ShippingMode();
			sm.setShippingModeId(i);
			sm.setShippingModeType("One way travel " + i);
			shippingModes.add(sm);
		}
		
		return shippingModes;
	}

	@Override
	public <T> T readModelWithId(Class<T> c, Serializable primaryKey) {
		return null;
	}

	@Override
	public WSUser getCurrentUser(HttpSession session) {
		WSUser user = null;
		Object userId = session.getAttribute("userId");
		if(null != userId) {
			userId = readModelWithId(WSUser.class, (Integer)userId);
		}
		return user;
	}
	
	/**
	 * This method will save the model in the database.
	 * @param t
	 * @return
	 */
	@Override
	public <T> boolean saveModel(T t) {
		return true;
	}

	@Override
	public List<LineItem> getLineItemsForOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPricing getProductPrice(int productId, String siteInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> boolean deleteModel(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderDetail> getOrdersForCurrentUser(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
}
