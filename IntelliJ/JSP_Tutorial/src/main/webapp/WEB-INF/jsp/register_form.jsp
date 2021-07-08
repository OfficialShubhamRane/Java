<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <h2>Welcome to Registration Page</h2>
    <h4> Fill up the below form to complete the registration</h4>
    <div>
        <%--@elvariable id="user" type="com.example.jsp_tutorial.model.User"--%>
        <form:form action="register" method="post" modelAttribute="user">
            <form:label path="fName">First Name:</form:label>
            <form:input path="fName"/>

            <form:button>Register</form:button>
        </form:form>
    </div>
</body>
</html>