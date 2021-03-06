<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

	<%	
		int x = Integer.parseInt(request.getParameter("num1"));
		int y = Integer.parseInt(request.getParameter("num2"));
		int addition = x + y;
		out.println(addition);
	%>

</body>
</html>