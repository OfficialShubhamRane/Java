<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Shubham Rane Locale
  Date: 8/1/2021
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.jsp_tutorial.controller.ExpressionController" %>
<html>
<head>
    <title>Expression Test</title>
</head>
<body>

    <%= new java.util.Date()  %>
    <br>

    <%
        for(int i=0; i<5; i++){
            out.print( "Hello: " + i );
        }
    %>
    <br>

    <%! public String makeLower(String data){
        return data.toLowerCase();
    }%>
    <%=
        makeLower("MAKE ME LOWER")
    %>
    <br>

    <%=
        makeLower("MAKE ME LOWER")
    %>

</body>
</html>
