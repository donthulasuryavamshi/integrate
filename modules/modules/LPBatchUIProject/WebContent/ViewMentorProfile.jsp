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
<!--<form method="get" action="/mentorprofileviewservlet">-->
<table>
<tr>
<th>Employee Id</th><th>Full Name</th><th>Contact Details</th>
</tr>
<c:forEach items="${mentorModelList}" var="mentormodel">
<tr>
<td><c:out value="${mentormodel.id}"/></td>
<td><c:out value="${mentormodel.fullName}"/></td>
<td><c:out value="${mentormodel.contactDetails}"/></td>
<td><c:out value="${mentormodel.role}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>