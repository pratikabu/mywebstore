<%@page import="mws.model.Product"%>
<%@page import="mws.utils.SearchHelper"%>
<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>Product Detail</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<%
		Product p = null;
		try {
			p = SearchHelper.getFacade().readModelWithId(Product.class, Integer.parseInt(request.getParameter("pid")));
		} catch(Exception e) {}
			
		if(p == null) {
			out.println("No Product exists with the provided pid.");
		} else {
		%>
		<table width="100%"  border="0">
			<tr>
				<td width="300px"><img src="" width="300px" height="200px"><br>
					<form name="productDetailForm" method="post" action="addProductToCart">
						Quantity: 
						<input name="quantity" type="text" id="quantity">
						<input type="hidden" name="pid" value="<%= request.getParameter("pid") %>">
						<br>
						Amount: <%= Utility.getPrintableAmount(SearchHelper.findProductPrice(p.getProductId(), session)) %>
						<p>
							<input type="submit" name="Submit" value="Add to Cart">
						</p>
					</form></td>
					<td><%= p.getProductName() %><br>
						<%= p.getProductDetail() %></td>
			</tr>
		</table>
		<%}%>
	</body>
</html>