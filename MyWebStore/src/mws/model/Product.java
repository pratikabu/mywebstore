/**
 * 
 */
package mws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author pratsoni
 *
 */
@Entity
public class Product {
	private int productId;
	
	private String productName, productDetail, imageUrl;
	
	private List<ProductPricing> productPricings;

	@Id
	@GeneratedValue
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@OneToMany(targetEntity = ProductPricing.class, fetch = FetchType.LAZY,
			mappedBy = "product", cascade = CascadeType.ALL)
	public List<ProductPricing> getProductPricings() {
		return productPricings;
	}

	public void setProductPricings(List<ProductPricing> productPricings) {
		this.productPricings = productPricings;
	}
}
