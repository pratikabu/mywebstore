/**
 * 
 */
package mws.utils;

import mws.model.Address;
import mws.model.Customer;
import mws.model.LineItem;
import mws.model.OrderDetail;
import mws.model.PaymentDetail;
import mws.model.Pricing;
import mws.model.Product;
import mws.model.ProductPricing;
import mws.model.ShippingMode;
import mws.model.SiteInfo;
import mws.model.WSUser;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author pratsoni
 *
 */
public class HibernateConfiguration {
	private static AnnotationConfiguration cfg;
	
	private static SessionFactory factory;

	/**
	 * This method returns the configuration object which is used for the current application.
	 * @return
	 */
	public static AnnotationConfiguration getCfg() {
		if(cfg == null) {
			cfg = new AnnotationConfiguration();
			cfg.addPackage("mws.model");
			populateModel();
			cfg.configure();
		}
		
		return cfg;
	}

	/**
	 * This method will return the heavy object of SessionFactory configured for the current instance of configuration.
	 * @return
	 */
	public static SessionFactory getFactory() {
		if(factory == null) {
			factory = getCfg().buildSessionFactory();
		}
		
		return factory;
	}
	
	private static void populateModel() {
		HibernateConfiguration.getCfg().addAnnotatedClass(WSUser.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(Customer.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(Address.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(PaymentDetail.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(ShippingMode.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(Product.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(OrderDetail.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(LineItem.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(SiteInfo.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(Pricing.class);
		HibernateConfiguration.getCfg().addAnnotatedClass(ProductPricing.class);
	}
}
