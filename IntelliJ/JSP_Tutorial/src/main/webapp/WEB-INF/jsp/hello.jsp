<jsp:useBean id="name" scope="request" type="java.lang.String"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h2 align="center">Hello ${name}!</h2>
</body>
</html>