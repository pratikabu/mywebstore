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
		<title>Select an Address</title>
	</head>
	<body class="zeroMargin">
		<%=Utility.getHTMLHeaderMenu()%>
		<div align="center">
			<form name="form1" method="post" action="processAddressSelection">
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
						<input type="submit" name="Submit" value="Select And Continue">
						<%}%>
					</p>
				</div>
			</form>
		</div>
	</body>
</html>