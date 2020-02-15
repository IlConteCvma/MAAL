<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,logic.bean.SubjectBean"%>
    
<jsp:useBean id="insQuesControl" scope="request"
	class="logic.controller.InsertQuestionController" />    

	
<%
	if(request.getParameter("materia") != null){
		session.setAttribute("subject", request.getParameter(request.getParameter("materia")));
		session.setAttribute("complete",true);
	}
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAAL Assistant</title>
</head>
<body>
<h1> Choose a subject</h1>
<form action="InsertQuestion.jsp" method="POST">
<%
	List<SubjectBean> subjects = insQuesControl.getSubjects();
	if(subjects != null) {
		for(int i = 0; i<subjects.size();i++) {
			
			%>
			<input type="submit" name="materia" value="<%=subjects.get(i).getAbbrevation()%>" class="btn btn-info" style="width:20%; background-color:#272F54">
			<input type="hidden" name="<%=subjects.get(i).getAbbrevation()%>" value="<%=subjects.get(i).getName()%>">
			<br><%
		}
	}
	else {
		%><script>alert("Non hai domande") </script>
<%}%>

</form>

	<%
		if((boolean)session.getAttribute("complete").equals(true)){
			%>
			<br>
			<form action="questionPage.jsp" name="myform" method="POST">
				<input name="exercise" type="submit" value="Exercise" class="btn btn-info" style="background-color:#272F54">
				<input name="problem" type="submit" value="Problem" class="btn btn-info" style="background-color:#272F54">
			</form>
			
			<%}%>

</body>
</html>