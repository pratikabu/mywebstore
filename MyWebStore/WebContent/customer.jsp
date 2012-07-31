<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>New Customer Form</title>
	</head>
	<body class="zeroMargin">
		<%= Utility.getHTMLHeaderMenu() %>
		<div><table width="100%"  border="0">
			<tr>
				<td><div align="center">
					<form name="cutomerDetailForm" method="post" action="processCustomer">
						<table width="373" border="0">
							<tr>
								<td colspan="2"><div align="center">Please fill the details </div></td>
							</tr>
							<tr>
								<td width="167"><div align="right">First Name:</div></td>
								<td width="196"><div align="left">
									<input name="firstName" type="text" id="firstName">
								</div></td>
							</tr>
							<tr>
								<td width="167"><div align="right">Last Name:</div></td>
								<td width="196"><div align="left">
									<input name="lastName" type="text" id="lastName">
								</div></td>
							</tr>
							<tr>
								<td width="167"><div align="right"></div></td>
								<td width="196"><div align="left">
								</div></td>
							</tr>
							<tr>
								<td width="167"><div align="right">Phone:</div></td>
								<td width="196"><div align="left">
									<input name="phone" type="text" id="phone">
								</div></td>
							</tr>
							<tr>
								<td width="167"><div align="right">Mobile:</div></td>
								<td width="196"><div align="left">
									<input name="mobile" type="text" id="mobile">
								</div></td>
							</tr>
							<tr>
								<td width="167"><div align="right">Email:</div></td>
								<td width="196"><div align="left">
									<input name="email" type="text" id="email">
								</div></td>
							</tr>
							<tr>
								<td><div align="right">Password:</div></td>
								<td><div align="left">
									<input name="password" type="password" id="password" value="">
								</div></td>
							</tr>
							<tr>
								<td><div align="right">Confirm Password:</div></td>
								<td><div align="left">
									<input name="cpassword" type="password" id="cpassword" value="">
								</div></td>
							</tr>
							<tr>
								<td colspan="2"><div align="right">
									<%
									if(null != request.getParameter("error")) {
									%>
									The record is not saved.<br/>
									<%}%>
									<input type="submit" name="Submit" value="Create User">
								</div></td>
							</tr>
						</table>
					</form>
				</div></td>
			</tr>
		</table></div>
		
	</body>
</html>