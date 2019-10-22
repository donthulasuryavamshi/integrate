<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>
<link href="css/style.css" rel="stylesheet"/>

</head>
<body>
<!--<form method="get" action="/lpprofileviewservlet">-->
<table>
<tr>
<th>Employee Id</th><th>Full Name</th><th>Contact Details</th>
</tr>
<c:forEach items="${lpModelList}" var="lpmodel">
<tr>
<td><c:out value="${lpmodel.id}"/></td>
<td><c:out value="${lpmodel.fullName}"/></td>
<td><c:out value="${lpmodel.contactDetails}"/></td>
<td><c:out value="${lpmodel.role}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>