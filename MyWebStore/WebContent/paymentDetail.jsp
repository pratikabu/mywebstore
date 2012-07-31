<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>New Payment Detail</title>
	</head>
	<body class="zeroMargin">
		<%= Utility.getHTMLHeaderMenu() %>
		<div><table width="100%"  border="0">
			<tr>
				<td><div align="center">
					<form name="form1" method="post" action="processPaymentDetail">
						<table width="329" border="0">
							<tr>
								<td colspan="2"><div align="center">Add new Payment Detail</div></td>
							</tr>
							<tr>
								<td width="113"><div align="right">Card Type : </div></td>
								<td width="206"><div align="left">
									<input name="cardType" type="radio" value="visa" checked>
									Visa
									<input name="cardType" type="radio" value="mastercard">
								Master Card </div></td>
							</tr>
							<tr>
								<td width="113"><div align="right">Card Number:</div></td>
								<td width="206"><div align="left">
									<input name="cardNumber" type="text" id="cardNumber">
								</div></td>
							</tr>
							<tr>
								<td width="113"><div align="right">Card Pin :</div></td>
								<td width="206"><div align="left">
									<input name="pin" type="password" id="pin">
								</div></td>
							</tr>
							<tr>
								<td colspan="2"><div align="right">
									<%
									if(null != request.getParameter("error")) {
									%>
									The record is not saved.<br/>
									<%}%>
									<input type="submit" name="Submit" value="Add Payment Detail">
								</div></td>
							</tr>
						</table>
					</form>
				</div></td>
			</tr>
		</table></div>
		
	</body>
</html>