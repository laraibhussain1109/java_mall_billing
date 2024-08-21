<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome ${customer.cname }</title>
</head>
<body>
	<h1>Welcome back! ${customer.cname }</h1>
	<form action="loadshop">
		<input type="submit" value="Go To Shop">
	</form>
</body>
</html>