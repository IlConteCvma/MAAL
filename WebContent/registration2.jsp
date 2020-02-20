<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="logic.bean.CourseBean"%>

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
	<div style="position:absolute;left:10%;top:30%;">
	<h1>Welcome MAAL Assistant</h1>
	<h5>Are you already registred?</h5>
	<a href="index.jsp"><button style="background-color: #272F54;"
			type="button" class="btn btn-primary btn-lg">Sign in</button></a>
	</div>
	<img style="position:absolute;left:25%;top:50%;width:20%;max-height:50%" src="img/regMan.png">
	<form action="${pageContext.request.contextPath}/SubjectFollowServlet"
		name="myform" method="POST">
		<jsp:useBean id="courseBean" scope="request"
			class="logic.bean.CourseBean" />

		<div style="background-color: #A22531; border: solid; position: absolute; top:25%;left: 45%; width: 50%; text-align: center;">
			<center>
				<h1 style="color:white">Choose subject to follow</h1>
				<table>
					<form>
						<%
							CourseBean cBean = (CourseBean) request.getAttribute("courseBean");
							for (int i = 0; i < cBean.getSubjectOfCourse().size(); i++) {
						%>
					
					<tr>
						<th><input type="checkbox" name="subject" value="<%=courseBean.getSubjectOfCourse().get(i).getName()%>">  <span style="color:white"><%=courseBean.getSubjectOfCourse().get(i).getName()%> </span>
						</th>
					</tr>
					<%
						}
					%>
					</form>
				</table>
				<br> <input name="login" type="submit" id="login"
					value="Sign up" class="btn btn-info"
					style="background-color: #272F54"> <br> <br>

			</center>
	</form>
</body>


</html>