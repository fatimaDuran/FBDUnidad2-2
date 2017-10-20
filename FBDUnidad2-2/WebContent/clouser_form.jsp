<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body> 
  <form action="ClouserController">
   <label>Name:</label><br />
  	<input type="text" name="name" value="${clouser.name}"/><br />
  <label>Creation date:</label></br>
  	<input type="text" name="creationDate" value="${clouser.creationDate}"/></br>
  	<label>Modification date:</label></br>
  	<input type="text" name="modificationDate" value="${clouser.modificationDate}"/></br>
  	<label>User name:</label></br>
  	  	<input type="text" name="username" value="${clouser.username}"/></br>
<input type="submit" name="btn_save" value="Save"/>
  </form>
</body>
</html>
