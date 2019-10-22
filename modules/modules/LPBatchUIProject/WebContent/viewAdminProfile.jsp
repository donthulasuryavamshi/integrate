<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminProfile</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>AdminId</th>
			<th>Full Name</th>
			<th>Contact Details</th>
			<th>Designation</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${adminModelList}" var="adminModel">
			<tr>
				<td><c:out value="${adminModel.id}" /></td>
				<td><c:out value="${adminModel.fullName}" /></td>
				<td><c:out value="${adminModel.contactDetails}" /></td>
				<td><c:out value="${adminModel.role}" /></td>
				<td><c:out value="${adminModel.address}" /></td>

			</tr>
		</c:forEach>
		</table>
</body>
</html>