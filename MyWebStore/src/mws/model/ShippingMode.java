/**
 * 
 */
package mws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author pratsoni
 *
 */
@Entity
public class ShippingMode {
	private int shippingModeId;
	
	private String shippingModeType;

	@Id
	@GeneratedValue
	public int getShippingModeId() {
		return shippingModeId;
	}

	public void setShippingModeId(int shippingModeId) {
		this.shippingModeId = shippingModeId;
	}

	public String getShippingModeType() {
		return shippingModeType;
	}

	public void setShippingModeType(String shippingModeType) {
		this.shippingModeType = shippingModeType;
	}
}
