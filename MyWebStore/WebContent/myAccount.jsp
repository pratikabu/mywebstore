<%@page import="mws.model.OrderDetail"%>
<%@page import="mws.model.PaymentDetail"%>
<%@page import="mws.model.Address"%>
<%@page import="java.util.List"%>
<%@page import="mws.utils.SearchHelper"%>
<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>My Account</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<div align="center">
			<h1>Address Stored</h1>
			<form name="form1" method="post" action="processAddressSelection">
				<input type="hidden" name="actionType" value="remove" />
				<%
					if(null != request.getParameter("noselect")) {
							out.println("Seems like you have nothing in your shopping cart. Please shop first.");
						}
						
						List<Address> adds = SearchHelper.getFacade().getAddressForCurrentUser(request.getSession());
						if(!adds.isEmpty()) {
				%>
				<table width="800px" border="0">
					<%
					int count = 0;
					for(Address add : adds) {
						if(0 == count % 3) {
							if(0 != count) {
								out.println("</tr>");
							}
					%>
					<tr>
						<%}%>
						<td width="200px"><input name="address" type="radio" checked="checked"
							value="<%= add.getAddressId() %>">Address <%= count + 1 %><br>
							<table width="100%" border="0">
								<tr>
									<td width="100%"><%=add.toHtmlAddress()%></td>
								</tr>
							</table></td>
					
					<%
					count++;
					}
					%>
				</table>
				<%}%>
				<div align="center">
					<p>
						<a href="address.jsp">Add a new Address</a>
						<%
						if(!adds.isEmpty()) {
						%>
						<br/><br/>
						<input type="submit" name="Submit" value="Remove Selected">
						<%}%>
					</p>
				</div>
			</form>
			
			<h1>Payment Options</h1>
			<form name="form1" method="post" action="processOrderPayment">
				<input type="hidden" name="actionType" value="remove" />
				<%
					List<PaymentDetail> paymentDetails = SearchHelper.getFacade().getPaymentDetailForCurrentUser(request.getSession());
						if(!paymentDetails.isEmpty()) {
				%>
				<table width="800px"  border="0">
					<%
					int count = 0;
					for(PaymentDetail pd : paymentDetails) {
						count++;
					%>
					<tr>
						<td><input name="paymentOption" type="radio" value="<%= pd.getPaymentDetailId() %>" >
							Payment Option <%= count %> <br>
							<table width="100%"  border="0">
								<tr>
									<td width="100%">Type: <%= pd.getCardType() %><br>
									Card No: <%=pd.toCcLast4Digits()%> </td>
								</tr>
							</table>
						</td>
					</tr>
					<% } %>
				</table>
				<% } %>
				<div align="center">
					<p>
						<a href="paymentDetail.jsp">Add a new Payment Detail </a>
						<% if(!paymentDetails.isEmpty()) { %>
						<br>
						<br>
						<input type="submit" name="Submit" value="Remove Selected">
						<% } %>
					</p>
				</div>
			</form>
			
			<div>
			<h1>Order Placed so far</h1>
				<input type="hidden" name="actionType" value="remove" />
				<%
					List<OrderDetail> orders = SearchHelper.getFacade().getOrdersForCurrentUser(request.getSession());
						if(!orders.isEmpty()) {
				%>
				<table width="800px"  border="0">
					<%
					int count = 0;
					for(OrderDetail ord : orders) {
						count++;
					%>
					<tr>
						<td><div align="center"><%= ord.getOrderId() %></div></td>
						<td><%= ord.getOrderDate() %></td>
<%-- 						<td><div align="right"><%=Utility.getPrintableAmount(productTotal)%></div></td> --%>
					</tr>
					<% } %>
				</table>
				<% } else { %>
				<br/>No orders placed yet
				<% } %>
			</div>
		</div>
	</body>
</html>