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
<body style="background-color: #F6C640">
	<h1>Welcome MAAL Assistant</h1>
	<a href="index.jsp"><button style="background-color: #272F54;"
			type="button" class="btn btn-primary btn-lg">Sign in</button></a>
	<form action="${pageContext.request.contextPath}/RegistrationServlet"
		name="myform" method="POST">

		<div style="background-color: #A22531; border: solid; position: absolute; left: 40%; width: 50%; text-align: center;">
			<center>
				<h1>Compile form</h1>
				<table>
					<tr>
						<th><label>Name</label></th>
						<th><input style="margin: 5px;" name="name" type="text">
						</th>
						<th><label>Surname</label></th>
						<th><input style="margin: 5px;" name="surname" type="text">
						</th>
					</tr>
					<tr>
						<th><label>Address</label></th>
						<th><input style="margin: 5px;" name="street" type="text">
							<input style="width: 40px; margin: 5px;" name="streetNumber"
							type="text"></th>
						<th><label>City</label></th>
						<th><input style="margin: 5px;" name="city" type="text">
						</th>
					</tr>
					<tr>
						<th><label>Username</label></th>
						<th><input style="margin: 5px;" name="username" type="text">
						</th>
						<th><label>Password</label></th>
						<th><input style="margin: 5px;" name="password" type="text">
						</th>
					</tr>
					<tr>
						<th><label>Who are you? </label></th>
						<th><select name="profession" style="margin: 5px;">
								<option>Student</option>
								<option>Professor</option>
						</select></th>
						<th><label>Which vehicle you use? </label></th>
						<th><select name="vehicle" style="margin: 5px;">
								<option>BUS</option>
								<option>CAR</option>
								<option>SCOOTER</option>
						</select></th>
					</tr>
					<tr>
						<th><label> Select course: </label></th>
						<th><select name="course" style="margin: 5px;">
								<option>Software engineer</option>
								<option>Civil engineer</option>
						</select></th>
					</tr>
				</table>
				<%
					if (request.getAttribute("exit") != null && request.getAttribute("exit").equals(0)) {
				%><p>Dati errati</p>
				<%
					}
				%>
				<br> <input name="login" type="submit" id="login"
					value="Go to subject" class="btn btn-info"
					style="background-color: #272F54"> <br> <br>
	</div>
			</center>
	</form>
</body>


</html>