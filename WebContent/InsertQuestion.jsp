<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,logic.bean.SubjectBean, logic.Session"%>
    
<jsp:useBean id="insQuesControl" scope="request"
	class="logic.controller.InsertQuestionController" />    

	
<%
	if(session.getAttribute("complete") != null){
		session.setAttribute("complete",false);
		session.setAttribute("subject", null);
	}
	if(request.getParameter("materia") != null){
		session.setAttribute("materia", null);
		session.setAttribute("subject", request.getParameter(request.getParameter("materia")));
		session.setAttribute("complete",true);
	}
%>

<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>MAAL Assistant</title>
  
  <!-- Bootstrap -->

  <link href="css/bootstrap-3.4.1.css" rel="stylesheet" type="text/css">
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">



</head>
<body style="background-color: #e2e7ec">
  
  
  
<div class="container"><br>
  <br>
  <!-- Navbar --> 
  <div class="row text-center"><br>
    <nav style="background-color: white;border-color: black" class="navbar navbar-default">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#defaultNavbar1" aria-expanded="false"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
          <a class="navbar-brand" href="prova.jsp">MAAL</a></div>
          
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="defaultNavbar1">
          <ul class="nav navbar-nav">
            <li class="home"><a href="prova.jsp">Home<span class="sr-only">(current)</span></a></li>
            <li><a href="#">Calendar</a></li>
            
            <li class="active"><a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Forum<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="InsertQuestion.jsp">Insert question</a></li>
                <li><a href="AllQuestion.jsp">View all question</a></li>
              </ul>
            </li>
            
            <li><a href="#">Profile</a></li>
         
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group"> </div>
            <input type="text" class="form-control" placeholder="Search">
          </form>
          <%
          	String usr = Session.getSession().getStudent().getName()+" "+Session.getSession().getStudent().getSurname()+"("+Session.getSession().getStudent().getUsername()+")";
          %>
          <table style="margin-top:2%">
          	<tr>
          		<th>  <li disable><label"><%=usr%>  </label></li></th>
          		<th> <a href="index.jsp">
           				<img style="width:20px;height:19px;margin-left:5xpx" src="img/logout.png">
           			</a> 
           		</th>
          	</tr>
          </table>
          </ul>
	</div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </div>
  <!-- Close navbar -->
  
  <!-- Open page contenent -->
<div class="row">
	<!-- Right menu -->
     <div class="col-md-4">
       <div style="background-color: #A22531; min-width: 370px; min-height: 507px" class="btn-group-vertical jumbotron text-center" aria-label="Vertical button group" role="group"><br>
       
       	<%
       	boolean value = false;
		if(session.getAttribute("complete") != null){
		     value = (Boolean) session.getAttribute("complete");
		}
		if(value){
       	%>
       	<p class="label"><%= 
       	(String)session.getAttribute("subject")
       	%></p>
       	<!-- ${pageContext.request.contextPath}/QuestionServlet -->
       	
       <form action="questionPage.jsp" name="formQuestionType" method="POST">
       		<%String toSend = (String)session.getAttribute("subject");%>
       		
       		<input type="hidden" name="subject" value="<%=toSend%>">
       		<br>
       		<button name="typeQuest" value="exercise" type="submit" class ="btn btn-primary btn-lg" style="background-color: #272F54; width: 100%">Exercise</button>
       		<br>
       		<br>
       		<button name="typeQuest" value="problem" type="submit" class ="btn btn-primary btn-lg" style="background-color: #272F54; width: 100%">Problem</button>
       		<br>
       		
       		
       </form>
       <%}%>
      	 	
       		<br>
       		<br>
       		<a href="AllQuestion.jsp">
			<button style="background-color: #272F54; width: 100%" type="button" class="btn btn-primary btn-lg" >View all<br> question</button>
       		</a>
			<br>

         
       </div>
     </div>
     <!-- End right menu -->
     
	<div style="background-color: #F6C640;min-height:507px" class="jumbotron jumbotron-fluid text-center col-lg-8 col-md-8">
	  <h2 class="display-4">Choose a subject</h2>

	  	
	  	<p class="lead">These are the subjects you follow
	  	<br>Select one
	  	</p>

	  <hr class="my-4">
		<p class="lead"> 
	<form action="InsertQuestion.jsp" method="POST">
			<% List<SubjectBean> subjects = insQuesControl.getSubjects();
			if(subjects != null) {
				for(int i = 0; i<subjects.size();i++) {
					String color = "#272F54";
					if(i%5==0){
						%>
						<br>
						<%
					}
					%>
					<div class="col-xs-3">
	
						<input type="submit" name="materia" value="<%=subjects.get(i).getAbbrevation()%>" class="btn btn-info" style="width:100%; background-color:#272F54">
						<input type="hidden" name="<%=subjects.get(i).getAbbrevation()%>" value="<%=subjects.get(i).getName()%>">
						<br><br>
					
					</div>										
					<%
				}
			}
			else {
				%><script>alert("Non hai domande") </script>
		<%}%>
	</form>
	</div>
	
 </div>
  <!-- Close page contenent -->
</div>
<!-- Close all page -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
    <!-- <script src="js/jquery-3.4.1.min.js"></script> -->
    <script src="js/jquery-1.12.4.min.js"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed --> 
    <script src="js/popper.min.js"></script>
    <!-- <script src="js/bootstrap-4.4.1.js"></script> -->
  <script src="js/bootstrap-3.4.1.js"></script>
</body>
</html>
