<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="logic.Session,execption.TimeException,execption.LessonNotFoundException"%> %>


	
<!-- Si dichiara la variabile loginBean e istanzia un oggetto LoginBean -->
<jsp:useBean id="studentBean" scope="session"
	class="logic.bean.StudentBean" />
	
<jsp:useBean id="useCaseController" scope="request"
	class="logic.controller.ViewTimeToExitController" />

<jsp:useBean id="timeToExitBean" scope="session"
	class="logic.bean.TimeToExitBean" />

<jsp:setProperty name="studentBean" property="*"/>
<jsp:setProperty name="useCaseController" property="*"/>

<%

    
					studentBean.setUsername(Session.getSession().getStudent().getUsername());
        	
            		// Passa il controllo alla nuova pagina
            		try {
            			timeToExitBean = useCaseController.estimateTimeToExit();
            			request.setAttribute("beanTime", timeToExitBean);
            		} catch (TimeException e) {
						%> <script> alert("Non hai tempo");</script><% 
					} catch (LessonNotFoundException e) {
						%> <script> alert("Finite lezioni");</script><%
					}%> 
            		<jsp:forward page="timeToExit.jsp"/>