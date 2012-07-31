<%@page import="mws.utils.SearchHelper"%>
<%@page import="mws.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>Product Showcase</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<div>
			<%
				List<Product> products = SearchHelper.getFacade().getProducts();
					if(products == null || products.isEmpty()) {
						out.println("There are no products found.");
					} else {
			%>
			<table width="100%"  border="0">
				<%
				int count = 0;
				for(Product p : products) {
					if(0 == count % 4) {
						if(0 != count) {
							out.println("</tr>");
						}
				%>
				<tr>
					<% } %>
					<td width="25%"><a href="productDetail.jsp?pid=<%= p.getProductId() %>"><%= p.getProductName() %></a><br>
						<table width="100%"  border="0">
							<tr>
								<td width="12%"><img src="siteInfo/product/<%= p.getImageUrl() %>" width="80" height="80"></td>
								<td width="88%"><%= p.getProductDetail() %></td>
							</tr>
						</table>
					</td>
				<%
				count++;
				}
				%>
			</table>
			<%}%>
		</div>
		<p>&nbsp;</p>
	</body>
</html>