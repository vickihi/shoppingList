<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add an item</title>
</head>
<body>
	<div align="center">
		<form:form action="saveItem" method="post"
			modelAttribute="item">
			<table>
				<form:hidden path="id" />

				<tr>
					<td>Item</td>
					<td><form:input path="name" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>