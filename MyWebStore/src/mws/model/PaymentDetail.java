package mws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author pratsoni
 *
 */
@Entity
public class PaymentDetail {
	private int paymentDetailId;
	
	private String cardType;
	
	private String ccNumber, ccPin;
	
	private Customer customer;

	@Id
	@GeneratedValue
	public int getPaymentDetailId() {
		return paymentDetailId;
	}

	public void setPaymentDetailId(int paymentDetailId) {
		this.paymentDetailId = paymentDetailId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	
	public String toCcLast4Digits() {
		return "XXXX XXXX XXXX "  + ccNumber.substring(ccNumber.length() - 4);
	}

	public String getCcPin() {
		return ccPin;
	}

	public void setCcPin(String ccPin) {
		this.ccPin = ccPin;
	}

	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
