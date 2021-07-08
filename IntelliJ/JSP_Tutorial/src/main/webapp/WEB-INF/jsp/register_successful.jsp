<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <h2>Successful Registration Details</h2>
    <span>First Name: </span><span>${user.fName}</span>
    <span>Last Name: </span><span>${user.lName}</span>
    <span>Contact: </span><span>${user.contactNo}</span>
    <span>Email: </span><span>${user.email}</span>
</body>
</html>