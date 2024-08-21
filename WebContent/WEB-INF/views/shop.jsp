<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>
	<h2>Shoping page</h2>
	
	<spring:form commandName="itemsBean" action="placeorder" method="post">
		<c:forEach var="shop" items="${allshops}">
			<h4>Shop Name: ${shop.shopName }</h4><p>
			<c:forEach var="item" items="${shop.items}">
				<spring:checkbox  value="${item.itemId }" path="items"/>${item.itemDescription }<p>
			</c:forEach>
		</c:forEach>
		<input type="submit">
	</spring:form>
	
</body>
</html>