<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,logic.bean.QuestionBean, logic.Session"%>
	
<jsp:useBean id="allQuestController" scope="request"
	class="logic.controller.AllQuestionController" />   
	
	


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
  
  
  
<div class="container">
  <br>
  <br>
  <!-- Navbar --> 
  <div class="row text-center">
    <br>
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
 			<a href="InsertQuestion.jsp">
			<button style="background-color: #272F54; width: 100%" type="button" class="btn btn-primary btn-lg" >Insert new question</button>
			</a>
			<br>
			<br>
			<a href="#">
			<button style="background-color: #272F54; width: 100%" type="button" class="btn btn-primary btn-lg" >My question</button>

       		<br>
       		<br>
       		<br>
       		<br>
       		<br>
       		<br>
       			
       		<a href="prova.jsp">
			<button style="background-color: #272F54; width: 100%" type="button" class="btn btn-primary btn-lg" >Home page</button>
       		</a>
			<br>

         
       </div>
     </div>
     <!-- End right menu -->
     
	<div style="background-color: #F6C640; min-height:507px" class="jumbotron jumbotron-fluid text-center col-lg-8 col-md-8">
	  <h2 class="display-4">Question summary</h2>

	  <hr class="my-4">
		<p class="lead"> 
		<div>
		
	<%
	List<QuestionBean> bean = allQuestController.getQuestions();
	if(bean != null) {
		for(int i = 0; i<bean.size();i++) {
			
			%>
			<div class="row" style="background-color: white;text-align: left">
			<div class="captation">
				<table class="table-bordered" style="width: 100%;height: 100%;border: 5px;border-color: #000">	
					<tr >
						<td><text style="padding: 2px"><%=String.valueOf(bean.get(i).getId()).toString()%></text></td>
						<td><text style="padding: 2px"><%=bean.get(i).getTitle()%></text></td>
						<td><text style="padding: 2px"><%=bean.get(i).getStudent()%></text></td>
						<td><text style="padding: 2px"><%=bean.get(i).getSubject()%></text></td>
						<td><text style="padding: 2px"><%=bean.get(i).getType().toString()%></text></td>
					</tr>
				</table>		
				
			</div>
			</div>
			<br>
			
			
			<%
		}
	}
	else {
		%><script>alert("Non question for the subbject you follow") </script>
	<%}
	
	%>
	
	</div>
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
	