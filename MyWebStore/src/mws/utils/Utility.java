/**
 * 
 */
package mws.utils;



/**
 * @author pratsoni
 *
 */
public class Utility {
	
	public static final String CART_SESSION_KEY = "CART_ORDER_KEY";
	public static final String USERID_SESSION_KEY = "USERID_KEY";
	public static final String SITE_INFO_KEY = "SITE_INFO_KEY";

	/**
	 * This will return the common header menu HTML.
	 * @return
	 */
	public static String getHTMLHeaderMenu() {
		return "<div class=\"headerSlot\">" +
		"<table width=\"100%\"  border=\"0\">" +
		"<tr>" +
		"<td><ul>" +
		"<li><a class=\"menuLink\" href=\"index.jsp\">Home</a></li>" +
		"<li><a class=\"menuLink\" href=\"myAccount.jsp\">My Account</a></li>" +
		"<li><a class=\"menuLink\" href=\"loginServlet?logout=true\">Logout</a></li>" +
		"<li><a class=\"menuLink\" href=\"cart.jsp\">My Cart</a></li>" +
		"</ul></td>" +
		"</tr>" +
		"</table>" +
		"</div>";
	}
	
	/**
	 * Returns a printable amount for the website.
	 * @param amount
	 * @return
	 */
	public static String getPrintableAmount(double amount) {
		return "$" + amount;
	}
}
