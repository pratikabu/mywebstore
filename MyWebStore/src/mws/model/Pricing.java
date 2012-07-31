/**
 * 
 */
package mws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author pratsoni
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pricing {
	private int pricingId;
	
	private double amount;
	
	private SiteInfo siteInfo;
	
	@Id
	@GeneratedValue
	public int getPricingId() {
		return pricingId;
	}

	public void setPricingId(int pricingId) {
		this.pricingId = pricingId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@ManyToOne
	@JoinColumn(name = "siteId")
	public SiteInfo getSiteInfo() {
		return siteInfo;
	}

	public void setSiteInfo(SiteInfo siteInfo) {
		this.siteInfo = siteInfo;
	}
	
}
