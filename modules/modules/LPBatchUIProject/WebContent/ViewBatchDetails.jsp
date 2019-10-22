<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BatchDetails</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>BatchId</th>
			<th>BatchName</th>
			<th>BatchCapacity</th>
			<th>BatchMentorId</th>
			<th>BatchVenueId</th>
			<th>BatchStartDate</th>
			<th>BatchEndDate</th>
		</tr>
		<c:forEach items="${batchdetailsModelList}" var="batchDetialsModel">
			<tr>

				<td><c:out value="${batchDetialsModel.batchId}"></c:out></td>
				<td><c:out value="${batchDetialsModel.batchName}"></c:out></td>
				<td><c:out value="${batchDetialsModel.batchCapacity}"></c:out></td>
				<td><c:out value="${batchDetialsModel.batchMentorId}"></c:out></td>
				<td><c:out value="${batchDetialsModel.batchVenueId}"></c:out></td>
				<td><c:out value="${batchDetialsModel.batchStartDate}"></c:out></td>
				<td><c:out value="${batchDetialsModel.batchEndDate}"></c:out></td>
			</tr>

		</c:forEach>



	</table>

</body>
</html>