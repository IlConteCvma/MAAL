<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="logic.bean.TimeToExitBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAAL Assistant</title>
</head>
<body>
<%			
	TimeToExitBean req = (TimeToExitBean)(request.getAttribute("beanTime"));
	out.println(req.getHourToExit());
%>
<h1> ciao </h1>
</body>
</html>