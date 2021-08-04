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
<%-- importing JSP header --%>
<jsp:include page="header-v1.jsp" />

<h2> JSP Expression, Scriplets, Declarations etc.</h2><br/>

<%--    JSP Expression --%>
    <%= new java.util.Date()  %>
    <br/>

<%--JSP Scriplet--%>
    <%
        for(int i=0; i<5; i++){
            out.print( "Hello: " + i );
        }
    %>
    <br/>

<%-- JSP Declaration --%>
    <%! public String makeLower(String data){
        return data.toLowerCase();
    }%>
<%-- Using in page Declaration --%>
    <%=
        makeLower("MAKE ME LOWER")
    %>
    <br/>

<%-- Using imported Declaration--%>
    <%=
        makeLower("MAKE ME LOWER")
    %>
    <br/>

<%-- Accessing build in objecs --%>
<h2> Built In Objects </h2><br/>
    Request user Agent <%= request.getHeader("User-Agent") %><br/>
    Request language: <%= request.getLocale() %><br/>

Form submitted by: <br/>
<%= request.getParameter("firstName") %>
${param.lastName} <br/>

<%-- importing JSP footer--%>
<jsp:include page="footer-v1.jsp" />

</body>
</html>
