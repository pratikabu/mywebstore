<%@page import="mws.model.Product"%>
<%@page import="mws.model.LineItem"%>
<%@page import="mws.model.OrderDetail"%>
<%@page import="mws.utils.SearchHelper"%>
<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>Order Detail</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<%
			OrderDetail cartOrder = SearchHelper.getFacade().getCartOrder(request.getSession());
				if(null != cartOrder) {
		%>
		<table width="800px"  border="0">
			<tr>
				<th width="7%" scope="col"><div align="center"></div></th>
				<th width="8%" scope="col"><div align="center">Qty</div></th>
				<th width="59%" scope="col">Prodcut</th>
				<th width="12%" scope="col"><div align="right">Price</div></th>
				<th width="14%" scope="col"><div align="right">Total</div></th>
			</tr>
			<%
				for(LineItem li : cartOrder.getLineItems()) {
					Product p = li.getProduct();
					double price = SearchHelper.findProductPrice(p.getProductId(), session);
					double productTotal = price * li.getQuantity();
			%>
			<tr>
				<td><div align="center"><img src="<%=p.getImageUrl()%>" width="50" height="50"></div></td>
				<td><div align="center"><%=li.getQuantity()%></div></td>
				<td><%=p.getProductName()%></td>
				<td><div align="right"><%= Utility.getPrintableAmount(price) %></div></td>
				<td><div align="right"><%=Utility.getPrintableAmount(productTotal)%></div></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="4">&nbsp;</td>
				<td><div align="right"></div></td>
			</tr>
			<tr>
				<td colspan="4"><div align="right">Shipping:</div></td>
				<td><div align="right">$0.00</div></td>
			</tr>
			<tr>
				<td colspan="4"><div align="right">Gross Total: </div></td>
				<td><div align="right"><strong><%=Utility.getPrintableAmount(SearchHelper.calculateCartTotal(session))%></strong></div></td>
			</tr>
			<tr>
				<td colspan="5"><div align="right"><a href="paymentSelect.jsp"><input type="button" value="Proceed to Payment" /></a></div></td>
			</tr>
		</table>
		<%}%>
	</body>
</html>