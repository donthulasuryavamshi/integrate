<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lp Registration</title>
<link href="css/form.css" rel="stylesheet"/>

</head>
<body>
<div align="center">
<form method="post" action="admincontroller?action=register">
<table>
<tr>
<td><label for="lpId">lp Id:</label></td>
<td><input type="number" name="lpId"/>&nbsp;<label style="color:red"><c:out value="${employeeIderror}"/></label></td>
</tr>

<tr>
<td><label for="firstName">First Name:</label></td>
<td><input type="text" name="firstName"/>&nbsp;<label style="color:red"><c:out value="${firstnameerror}"/></label></td>
</tr>

<tr>
<td><label for="lastName">Last Name:</label></td>
<td><input type="text" name="lastName"/>&nbsp;<label style="color:red"><c:out value="${lastnameerror}"/></label></td>
</tr>

<tr>
<td><label for="date of birth">date of birth:</label></td>
<td><input type="text" name="dob"/>&nbsp;<label style="color:red"><c:out value="${lastnameerror}"/></label></td>
</tr>
<tr>
<td><label for="email">Email:</label></td>
<td><input type="email" name="email"/>&nbsp;<label style="color:red"><c:out value="${emailerror}"/></label><label style="color:red"><c:out value="${emailexisterror}"/></label></td>
</tr>
<tr>
<td><label for="role">designation:</label></td>
<td><input type="text" name="role"/>&nbsp;<label style="color:red"><c:out value="${lastnameerror}"/></label></td>
</tr>
<tr>
<td><label for="phoneNumber">Phone Number:</label></td>
<td><input type="text" name="phoneNumber"/></td>
</tr>

<tr>
<td><label for="city">City:</label></td>
<td><input type="text" name="city"/></td>
</tr>

<tr>
<td><label for="state">State:</label></td>
<td><input type="state" name="state"/></td>
</tr>

<tr>
<td><label for="country">Country:</label></td>
<td><input type="country" name="country"/></td>
</tr>

<tr>
<td><input type="submit" value="Register" class="button"></td>
<td><input type="reset" value="Cancel" class="button"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>