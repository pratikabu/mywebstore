/**
 * 
 */
package mws.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author pratsoni
 *
 */
@Entity
public class SiteInfo {
	private String siteLocale, theme;

	@Id
	public String getSiteLocale() {
		return siteLocale;
	}

	public void setSiteLocale(String siteName) {
		this.siteLocale = siteName;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
