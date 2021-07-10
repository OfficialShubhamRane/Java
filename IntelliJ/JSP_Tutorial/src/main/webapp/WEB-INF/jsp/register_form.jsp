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
        <div>
            <form:form action="register" method="post" modelAttribute="user" >
                <form:label path="fullName">Full Name:</form:label>
                <form:input path="fullName"/>
                <br>
                <form:label path="contactNo">Contact No.:</form:label>
                <form:input path="contactNo"/>
                <br>
                <form:label path="email">Email:</form:label>
                <form:input path="email"/>
                <br>
                <form:label path="password">Password:</form:label>
                <form:password path="password"/>
                <br>
                <form:label path="ConfirmPassword">Confirm Password:</form:label>
                <form:password path="confirmPassword"/>
                <br>
                <form:label path="gender">Gender:</form:label>
                <form:radiobutton path="gender"  value='M' />Male
                <form:radiobutton path="gender"  value='F' />Female
                <br>
                <form:label path="birthdate">Birthdate (yyyy-mm-dd):</form:label>
                <form:input path="birthdate"/>
                <br>
                <form:label path="highestEducation">Highest Education:</form:label>
                <jsp:useBean id="highestEdu_List" scope="request" type="java.util.List"/>
                <form:select path="highestEducation" items="${highestEdu_List}"/>
                <br>
                <form:label path="isMarried">Married:</form:label>
                <form:checkbox path="isMarried"/>
                <br>
                <form:label path="note">Note:</form:label>
                <form:textarea path="note" rows="5" cols="25"/>
                <br>

                <form:button>Register</form:button>
            </form:form>
        </div>

    </div>
</body>
</html>