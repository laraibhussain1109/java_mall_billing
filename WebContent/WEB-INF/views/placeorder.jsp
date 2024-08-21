<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
</head>
<body>
	<jsp:useBean id="invoice" class="com.bean.InvoiceDisplayBean"></jsp:useBean>
	<jsp:setProperty property="items" name="invoice" value="${items }"/>
	<br><br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">${customer.cname}'s Invoice</h3>
			<hr>
			<table class="table table-bordered table-stripped text-center">
				<thead>
					<tr>
						<th>Sl.No</th>
						<th>Item Description</th>
						<th>Unit</th>
						<th>Qty</th>
						<th>Price</th>
						<th>Cost</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${items }">
					<tr>
						<td>${invoice.slno }</td>
						<td><c:out value="${item.itemDescription }"/></td>
						<td><c:out value="${item.unit }"/></td>
						<td>1</td>
						<td><c:out value="${item.price }"/></td>
						<td><c:out value="${item.price }"></c:out>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<p class="text-xl-right font-weight-bold">Total cost:     ${invoice.total}</p>
			<hr>
			<form action="login">
				<button class="btn btn-danger">Login Page/Logout</button>
			</form>		
		</div>	
	</div>	
</body>
</html>