<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- FONT AWESOME -->
<script src="https://kit.fontawesome.com/ce3727e4c1.js"
	crossorigin="anonymous"></script>
<!-- custom style -->
<style>
	.bg-title {
    background-color: #0275d8; 
    color: #ffffff;
  }
</style>
<title>Add an item</title>
</head>
<body class="text-center">

	<div class="page-header bg-title"><h1>Add item to shopping list "<span>${listMapping[listId]}</span>"</h1></div>
	<br>
	<div align="center" class="container-fluid">
		<form:form action="saveItem" method="post" modelAttribute="editedlist">
			<input id="listId" name="listId" type="hidden" value="${listId}" />
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Item</td>
					<td><form:input path="name"/></td>
				</tr>
				<tr class="mt-3">
					<td>Category</td>
					<td><form:input path="category.name" /></td>
				</tr>
				<%-- <tr>
					<td>List</td>
					<td><form:input path="list.name" /></td>
				</tr> --%>
				<%-- <tr>
					<td>Category Id</td>
					<td><form:select path="category_id">
							<form:options items="${categoryList}" itemValue="id"
								itemLabel="name" />
						</form:select></td>
				</tr> --%>
			</table>
			<tr>
				<td colspan="2"><input type="submit" value="Add Item" class="btn btn-primary center-block mt-3"></td>
			</tr>
		</form:form>
	</div>
	
	<br>
	<br>
	<div align="center" class="container jumbotron col-md-6">
		<h2>${listMapping[listId]}</h2>
		<table class="table table-striped table-light col-md-10">
		<thead class="thead-dark">
		<tr>
				<th style="width: 40%">Item</th>
				<th style="width: 40%">Category</th>
				<th style="width: 20%"></th>
			</tr>
		</thead>
			
			<c:forEach var="item" items="${itemList}">
				<tr>
					<td><c:out value="${item.name}"></c:out></td>
					<td><c:out value="${categoryMapping[item.category.id]}"></c:out></td>
					<td><a href="deleteitem?itemId=${item.id}&listId=${listId}" class="btn btn-secondary center-block" role="button">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div align="center" class="container col-md-6">
		<a href="getlists" class="btn btn-primary btn-lg btn-block" role="button">Save</a>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
