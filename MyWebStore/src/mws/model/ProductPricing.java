/**
 * 
 */
package mws.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author pratsoni
 *
 */
@Entity
public class ProductPricing extends Pricing {
	private Product product;

	@ManyToOne
	@JoinColumn(name = "productId")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
