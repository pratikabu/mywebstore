<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>Customer Login</title>
	</head>
	<body class="zeroMargin" onLoad="document.getElementById('username').focus();">
		<%= Utility.getHTMLHeaderMenu() %>
		<div><table width="100%"  border="0">
			<tr>
				<td><div align="center">
					<form name="loginForm" method="post" action="loginServlet">
						<%
						if(null != request.getParameter("error")) {
						%>
						<div style="color:RED">Unable to login with the provided credentials.</div>
						<%}%>
						<table width="278" border="0">
							<tr>
								<td colspan="2"><div align="center">Login with your account </div></td>
							</tr>
							<tr>
								<td width="109"><div align="right">Username:</div></td>
								<td width="150"><div align="left">
									<input name="username" type="text" id="username">
								</div></td>
							</tr>
							<tr>
								<td><div align="right">Password:</div></td>
								<td><div align="left">
									<input name="password" type="password" id="password" value="">
								</div></td>
							</tr>
							<tr>
								<td colspan="2"><div align="right">
									<input type="submit" name="Submit" value="Login">
								</div></td>
							</tr>
							<tr>
								<td colspan="2"><div align="right"><a href="customer.jsp">Create a new account for free</a></div></td>
							</tr>
						</table>
					</form>
				</div></td>
			</tr>
		</table></div>
		
	</body>
</html>