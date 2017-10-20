<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incident List</title>
</head>
<body>
	<table border="1">
		<tr>
		<th>
			<form action="ClouserController">
				<input type="submit" name="btn_new"
				value="New"/>
			</form>
		</th>
		<th>Id</th>
		<th>Name</th>
		<th>Creation Date</th>
		<th>Modification Date</th>
		<th>User Name</th>
		</tr>
		<c:forEach var="clouser" items="${clousers}">
		<tr>
		<td>
		<form action="ClouserController">
			<input type="hidden" name="id" value="${clouser.id}"/>
			<input type="submit" name="btn_edit" value="Edit"/>
			<input type="submit" name="btn_delete"value="Delete"/>
		</form>
		</td>
			<td>${clouser.id}</td>
			<td>${clouser.name}</td>
			<td>${clouser.creationDate}</td>
			<td>${clouser.modificationDate}</td>
			<td>${clouser.username}</td>
		</tr>
		</c:forEach> <!-- Etiqueta de la libreria jstl -->
	</table>
</body>
</html>
