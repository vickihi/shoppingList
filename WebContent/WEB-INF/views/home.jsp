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
<title>Home Page</title>
</head>

<body>
	
		<div align="center" class="page-header bg-title"><h1>Your Shopping Lists</h1></div>
		<div align="center" class="container jumbotron col-md-6">
		<table class="table table-striped table-light col-md-10">
		<thead class="thead-dark">
		<tr>
				<th style="width: 70%">shopping list name</th>
				<th style="width: 15%"></th>
				<th style="width: 15%"></th>
			</tr>
		</thead>
			
			<c:forEach var="list" items="${listList}">
				<tr>
					<td><c:out value="${list.name}"></c:out></td>
					<td><a href="editlist?listId=${list.id}" class="btn btn-secondary center-block" role="button">edit</a></td>
					<td><a href="deletelist?listId=${list.id}" class="btn btn-secondary center-block" role="button">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	
	<div align="center" class="container col-md-6">
		<a href="addlist" class="btn btn-primary btn-lg btn-block" role="button">Add a new list</a>
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