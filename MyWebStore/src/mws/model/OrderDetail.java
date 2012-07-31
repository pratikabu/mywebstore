/**
 * 
 */
package mws.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author pratsoni
 *
 */
@Entity
public class OrderDetail {
	private String orderId;
	
	private Customer customer;
	
	private Address address;
	
	private PaymentDetail paymentDetail;
	
	private ShippingMode shippingMode;
	
	private Date orderDate;
	
	private List<LineItem> lineItems;

	@Id
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(targetEntity = Address.class)
	@JoinColumn(name = "addressId")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(targetEntity = PaymentDetail.class)
	@JoinColumn(name = "payementDetailId")
	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	@ManyToOne(targetEntity = ShippingMode.class)
	@JoinColumn(name = "shippingModeId")
	public ShippingMode getShippingMode() {
		return shippingMode;
	}

	public void setShippingMode(ShippingMode shippingMode) {
		this.shippingMode = shippingMode;
	}

	@OneToMany(targetEntity = LineItem.class, fetch = FetchType.LAZY,
			mappedBy = "order", cascade = CascadeType.ALL)
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
