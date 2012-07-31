<%@page import="mws.utils.SearchHelper"%>
<%@page import="mws.model.ShippingMode"%>
<%@page import="java.util.List"%>
<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>Select Shipping Mode</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<div align="center"><form name="shippingModeSelectForm1" method="post" action="processShippingSelection">
		<%
			if(null != request.getParameter("noselect")) {
			out.println("Seems like you have nothing in your shopping cart. Please shop first.");
				}
				
				List<ShippingMode> shippingModes = SearchHelper.getFacade().getShippingMode();
				if(!shippingModes.isEmpty()) {
		%>
		<table width="800px"  border="0">
			<%
			for(ShippingMode sm : shippingModes) {
			%>
			<tr>
				<td width="25%"><input name="shippingMode" type="radio" value="<%= sm.getShippingModeId() %>" >
					<%= sm.getShippingModeType() %></td>
			</tr>
			<% } %>
		</table>
		<div align="center">
			<p>
				<input type="submit" name="Submit" value="Select And Continue">
			</p>
		</div>
		<% } %>
		</form>
		</div>
		
	</body>
</html>