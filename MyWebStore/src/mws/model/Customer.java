/**
 * 
 */
package mws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author pratsoni
 *
 */
@Entity
public class Customer extends WSUser {
	private List<Address> addresses;
	
	private List<PaymentDetail> paymentDetails;

	@OneToMany(targetEntity = Address.class, fetch = FetchType.LAZY,
			mappedBy = "customer", cascade = CascadeType.ALL)
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(targetEntity = PaymentDetail.class, fetch = FetchType.LAZY,
			mappedBy = "customer", cascade = CascadeType.ALL)
	public List<PaymentDetail> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
}
