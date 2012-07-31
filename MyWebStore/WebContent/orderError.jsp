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
		<title>Order Success</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<%
			OrderDetail cartOrder = SearchHelper.getFacade().getCartOrder(request.getSession());
				if(null != cartOrder) {
		%>
		<table width="800px"  border="0">
			<tr>
				<td colspan="5"><H1>Encountered an error while placing the Order.<br/>
				Your payment will be refunded within 2 business days.</H1></td>
			</tr>
		</table>
		<%}%>
	</body>
</html>