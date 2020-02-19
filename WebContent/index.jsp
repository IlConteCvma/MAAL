<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>MAAL Assistant</title>
</head>

<body>
<body style="background-color:#F6C640 ">
	<div style="position:absolute;left:20%;top:30%;">
	<h1>Welcome MAAL Assistant</h1>
	<h5>If you are not already registered and you want a personal assistant</h5>
	<a href="registration.jsp"><button style="background-color: #272F54;"
						type="button" class="btn btn-primary btn-lg"> Sign up</button></a>
	</div>
	<img style="position:absolute;left:40%;top:50%;width:20%;max-height:50%" src="img/manBook.png">
	<form action="${pageContext.request.contextPath}/LoginServlet" name="myform" method="POST">

		<div style="background-color:#A22531;border: solid; position: absolute; top:25%;left: 60%; width: 20%; min-height:55%; text-align: center;">
		<br>
			<p style="font-size:26px;color:white"> Sign in <p>	<br><br>
			<label style="color:white">Insert username</label> <br> <input id="username" name="username" type="text"> 
			<br> 
			<br>
			<label style="color:white">Insert password</label>
			<br> <input id="password" name="password" type="password">
			<br><br>
			<br> <input name="login" type="submit" id="login" value="Sign in" class="btn btn-info" style="background-color:#272F54;width:50%">
			<br> <a href="#"> Forgot the password? </a>
				 <input name="tipoLogin" type="hidden" value="user" id="tipoLogin" class="btn btn-warning">
			<br>
			
			<%
				if(request.getAttribute("exit") != null){
					int exit = (int)request.getAttribute("exit");
					switch(exit){
						case 2:	%> <script> alert("error connection db") </script> <% 
								break;
						case 3: %> <p> Dati errati </p> <%
								break;
						case 4: %> <script> alert("compile form please") </script> <% 
								break;
					}
				}
				
			%>
			
		</div>
	</form>
</body>


</html>