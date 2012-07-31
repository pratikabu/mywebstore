<%@page import="mws.utils.SearchHelper"%>
<%@page import="mws.model.PaymentDetail"%>
<%@page import="java.util.List"%>
<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>Select Payment Option</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		
		<div align="center">
			<form name="form1" method="post" action="processOrderPayment">
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
						<input type="submit" name="Submit" value="Select And Continue">
						<% } %>
					</p>
				</div>
			</form>
		</div>
	</body>
</html>