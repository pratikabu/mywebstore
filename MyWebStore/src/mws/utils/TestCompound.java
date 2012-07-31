/**
 * 
 */
package mws.utils;

import mws.model.Product;
import mws.model.ProductPricing;
import mws.model.ShippingMode;
import mws.model.SiteInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author Pratik
 * Created on : 24-Apr-2011, 12:49:44 AM
 */
public class TestCompound {
	public static void main(String[] args) {
		initializeDB();
		updateData();
		
		System.out.println("Successfully updated/initialized.");
	}

	/**
	 * @param args
	 */
	public static void initializeDB() {
		//to execute the configuration
		new SchemaExport(HibernateConfiguration.getCfg()).create(true, true);
		//create(true, true) script: to print sqls in sql logs, export: to send sqls to db server
		
		//to run sqls we need the session factory so that we can get session objects
		SessionFactory factory = HibernateConfiguration.getFactory();
		
		Session session = factory.getCurrentSession();
		
		//to let know hibernate that the object below exists we have begin the transaction
		session.beginTransaction();
		
//		session.save(acc);//it does not saves it here
		
		session.getTransaction().commit();//it saves the object here
	}
	
	public static void updateData() {
		ShippingMode sm = new ShippingMode();
		sm.setShippingModeType("Normal Postal Service");
		SearchHelper.getFacade().saveModel(sm);
		
		sm = new ShippingMode();
		sm.setShippingModeType("Next Flight Service");
		SearchHelper.getFacade().saveModel(sm);
		
		sm = new ShippingMode();
		sm.setShippingModeType("Next Business Day Service");
		SearchHelper.getFacade().saveModel(sm);
		
		SiteInfo si = new SiteInfo();
		si.setSiteLocale("en");
		si.setTheme("entheme");
		SearchHelper.getFacade().saveModel(si);
		
		for(int i = 0; i < 6; i++) {
			Product p = new Product();
			p.setProductId(i);
			p.setProductName("My Mobile " + (i + 1));
			p.setProductDetail("did you like this mobile<br/>this is an awesome<br/> " + p.getProductName());
			SearchHelper.getFacade().saveModel(p);
			
			ProductPricing pp = new ProductPricing();
			pp.setAmount(50 * (i + 1));
			pp.setProduct(p);
			pp.setSiteInfo(si);
			SearchHelper.getFacade().saveModel(pp);
		}
	}

}
