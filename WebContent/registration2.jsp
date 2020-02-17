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
	<h1>Welcome MAAL Assistant</h1>
	<a href="index.jsp"><button style="background-color: #272F54;"
			type="button" class="btn btn-primary btn-lg">Sign in</button></a>
	<form action="${pageContext.request.contextPath}/SubjectFollowServlet"
		name="myform" method="POST">
		<jsp:useBean id="courseBean" scope="request"
			class="logic.bean.CourseBean" />

		<div
			style="background-color: #A22531; border: solid; position: absolute; left: 40%; width: 50%; text-align: center;">
			<center>
				<h1>Choose subject to follow</h1>
				<table>
					<form>
						<%
							CourseBean cBean = (CourseBean) request.getAttribute("courseBean");
							for (int i = 0; i < cBean.getSubjectOfCourse().size(); i++) {
						%>
					
					<tr>
						<th><input type="checkbox" name="subject" value="<%=courseBean.getSubjectOfCourse().get(i).getName()%>"> <%=courseBean.getSubjectOfCourse().get(i).getName()%>
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