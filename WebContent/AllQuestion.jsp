<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,logic.bean.QuestionBean"%>
	
<jsp:useBean id="allQuestController" scope="request"
	class="logic.controller.AllQuestionController" />    
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> MAAL Assistant </title>
</head>
<body>
<h1> Question summary </h1>
	<%
	List<QuestionBean> bean = allQuestController.getQuestions();
	if(bean != null) {
		for(int i = 0; i<bean.size();i++) {
			out.println(bean.get(i).getSubject());
			%><br><%
		}
	}
	else {
		%><script>alert("Non hai domande") </script>
	<%}
	
	%>
	<a href="InsertQuestion.jsp"> Insert question </a>
</body>
</html>