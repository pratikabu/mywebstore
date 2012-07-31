/**
 * 
 */
package mws.utils.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mws.model.Address;
import mws.model.Customer;
import mws.model.LineItem;
import mws.model.OrderDetail;
import mws.model.PaymentDetail;
import mws.model.Product;
import mws.model.ProductPricing;
import mws.model.ShippingMode;
import mws.model.WSUser;
import mws.utils.HibernateConfiguration;
import mws.utils.SearchFacade;
import mws.utils.Utility;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author pratsoni
 *
 */
@SuppressWarnings("unchecked")
public class SearchFacadeImpl implements SearchFacade {
	private Logger logger = Logger.getLogger(SearchFacadeImpl.class);
	
	@Override
	public List<Product> getProducts() {
		Session s = HibernateConfiguration.getFactory().getCurrentSession();
		s.beginTransaction();
		List<Product> prods = s.createQuery("from Product").list();
		s.getTransaction().commit();
		
		return prods;
	}

	@Override
	public OrderDetail getCartOrder(HttpSession session) {
		return (OrderDetail)session.getAttribute(Utility.CART_SESSION_KEY);
	}

	@Override
	public boolean isValidCustomer(String username, String password) {
		WSUser user = readModelWithId(WSUser.class, username);
		if(null == user) {
			return false;
		}
		
		return password.equals(user.getPassword());
	}

	@Override
	public List<Address> getAddressForCurrentUser(HttpSession session) {
		Customer customer = (Customer)getCurrentUser(session);
		
//		List<Address> addresses = customer.getAddresses();
		Session s = HibernateConfiguration.getFactory().getCurrentSession();
		s.beginTransaction();
		Query query = s.createQuery("from Address where customerId=:uid");
		query.setString("uid", customer.getEmail());
		List<Address> addresses = query.list();
		s.getTransaction().commit();
		
		return addresses == null ? new ArrayList<Address>(): addresses;
	}

	@Override
	public List<PaymentDetail> getPaymentDetailForCurrentUser(HttpSession session) {
		Customer customer = (Customer)getCurrentUser(session);
//		List<PaymentDetail> paymentDetails = customer.getPaymentDetails();
		Session s = HibernateConfiguration.getFactory().getCurrentSession();
		s.beginTransaction();
		Query query = s.createQuery("from PaymentDetail where customerId=:uid");
		query.setString("uid", customer.getEmail());
		List<PaymentDetail> paymentDetails = query.list();
		s.getTransaction().commit();
		
		return paymentDetails == null ? new ArrayList<PaymentDetail>(): paymentDetails;
	}

	@Override
	public List<ShippingMode> getShippingMode() {
		Session s = HibernateConfiguration.getFactory().getCurrentSession();
		s.beginTransaction();
		List<ShippingMode> shippingModes = s.createQuery("from ShippingMode").list();
		s.getTransaction().commit();
		
		return shippingModes;
	}

	@Override
	public <T> T readModelWithId(Class<T> c, Serializable primaryKey) {
		Session session = HibernateConfiguration.getFactory().getCurrentSession();
		session.beginTransaction();
		T t = (T)session.get(c, primaryKey);
		session.getTransaction().commit();
		
		return t;
	}

	@Override
	public WSUser getCurrentUser(HttpSession session) {
		WSUser user = null;
		Object userId = session.getAttribute(Utility.USERID_SESSION_KEY);
		if(null != userId) {
			user = readModelWithId(WSUser.class, (String)userId);
		}
		return user;
	}
	
	@Override
	public <T> boolean saveModel(T t) {
		Session session = HibernateConfiguration.getFactory().getCurrentSession();
		session.beginTransaction();//to let know hibernate that the object below exists we have begin the transaction
		try {
			session.save(t);//it does not saves it here
			session.getTransaction().commit();//it saves the object here
			
			return true;
		} catch(HibernateException he) {
			logger.error("Exception while saving: " + t, he);
			session.getTransaction().rollback();
			return false;
		}
	}
	
	@Override
	public <T> boolean deleteModel(T t) {
		Session session = HibernateConfiguration.getFactory().getCurrentSession();
		session.beginTransaction();//to let know hibernate that the object below exists we have begin the transaction
		try {
			session.delete(t);//it does not delete it here
			session.getTransaction().commit();//it deletes the object here
			
			return true;
		} catch(HibernateException he) {
			logger.error("Exception while deleting: " + t, he);
			session.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<LineItem> getLineItemsForOrder(String orderId) {
		Session s = HibernateConfiguration.getFactory().getCurrentSession();
		s.beginTransaction();
		Query query = s.createQuery("from LineItem where orderId=:orderId");
		query.setString("orderId", orderId);
		List<LineItem> lineItems = query.list();
		s.getTransaction().commit();
		
		return lineItems == null ? new ArrayList<LineItem>(): lineItems;
	}

	@Override
	public ProductPricing getProductPrice(int productId, String siteInfo) {
		Session s = HibernateConfiguration.getFactory().getCurrentSession();
		s.beginTransaction();
		Query query = s.createQuery("from ProductPricing where siteInfo=:siteInfo and productId=:productId");
		query.setString("siteInfo", siteInfo);
		query.setInteger("productId", productId);
		
		ProductPricing pp = (ProductPricing)query.uniqueResult();
		
		return pp;
	}

	@Override
	public List<OrderDetail> getOrdersForCurrentUser(HttpSession session) {
		Customer customer = (Customer)getCurrentUser(session);
		Session s = HibernateConfiguration.getFactory().getCurrentSession();
		s.beginTransaction();
		Query query = s.createQuery("from OrderDetail where customerId=:uid");
		query.setString("uid", customer.getEmail());
		List<OrderDetail> orders = query.list();
		s.getTransaction().commit();
		
		return orders == null ? new ArrayList<OrderDetail>(): orders;
	}
}
