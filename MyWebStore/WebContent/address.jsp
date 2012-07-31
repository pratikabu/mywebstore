<%@page import="mws.utils.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="siteInfo/en/stylesheet.css">
		<title>New Address</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<div>
			<table width="100%" border="0">
				<tr>
					<td><div align="center">
						<form name="form1" method="post" action="processAddressDetail">
							<table width="373" border="0">
								<tr>
									<td colspan="2"><div align="center">Add new Address
									</div></td>
								</tr>
								<tr>
									<td width="167"><div align="right">Address Line 1:</div></td>
									<td width="196"><div align="left">
										<input name="addLine1" type="text" id="addLine1">
									</div></td>
								</tr>
								<tr>
									<td width="167"><div align="right">Address Line 2:</div></td>
									<td width="196"><div align="left">
										<input name="addLine2" type="text" id="addLine2">
									</div></td>
								</tr>
								<tr>
									<td width="167"><div align="right">Address Line 3:</div></td>
									<td width="196"><div align="left">
										<input name="addLine3" type="text" id="addLine3">
									</div></td>
								</tr>
								<tr>
									<td width="167"><div align="right">City:</div></td>
									<td width="196"><div align="left">
										<input name="city" type="text" id="city">
									</div></td>
								</tr>
								<tr>
									<td width="167"><div align="right">State:</div></td>
									<td width="196"><div align="left">
										<input name="state" type="text" id="state">
									</div></td>
								</tr>
								<tr>
									<td width="167"><div align="right">Country:</div></td>
									<td width="196"><div align="left">
										<input name="country" type="text" id="country">
									</div></td>
								</tr>
								<tr>
									<td colspan="2"><div align="right">
										<%
										if(null != request.getParameter("error")) {
										%>
										The record is not saved.<br/>
										<%}%>
										<input type="submit" name="Submit" value="Add Address">
									</div></td>
								</tr>
							</table>
						</form>
					</div></td>
				</tr>
			</table>
		</div>
	</body>
</html>