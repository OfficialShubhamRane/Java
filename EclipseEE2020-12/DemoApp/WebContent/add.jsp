<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor = "green">

	<%
		int x = Integer.parseInt(request.getParameter("num1")); 	
		int y = Integer.parseInt(request.getParameter("num2"));
	
		int add = x + y;
		System.out.println(add); // para Debugging
		out.println(add);
	%>




  
</body>
</html>