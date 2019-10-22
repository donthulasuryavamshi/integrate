<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<th>Batch Id</th><th>Batch Name</th><th>Mentor Id</th><th>Venue Id</th><th>Venue Capacity</th>
</tr>
<c:forEach items="${batchModelList}" var="batchModel">

<tr>
<td><c:out value="${batchModel.batchId}"/></td>
<td><c:out value="${batchModel.batchName}"/></td>
<td><c:out value="${batchModel.batchMentorId}"/></td>
<td><c:out value="${batchModel.batchVenueId}"/></td>
<td><c:out value="${batchModel.batchCapacity}"/></td>




</tr>

</c:forEach>

</table>

</body>
</html>