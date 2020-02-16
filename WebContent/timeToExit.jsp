<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="logic.bean.TimeToExitBean"%>

<!DOCTYPE>


<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap - Prebuilt Layout</title>
<!-- Bootstrap -->
<!-- <link href="css/bootstrap-4.4.1.css" rel="stylesheet"> -->
<link href="css/bootstrap-3.4.1.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<style>
.grid-container {
  display: grid;
  grid-template-columns: 50% 50%;
  padding: 10px;
}
.grid-item {
  background-color: #A22531;
  border: 1px solid rgba(0, 0, 0, 0.8);
  padding: 20px;
  margin: 2px;
  font-size: 30px;
  text-align: center;
}
</style>

</head>
<%
	TimeToExitBean req = (TimeToExitBean) (request.getAttribute("timeBean"));
%>
<div class="container">
	<br> <br>
	<div class="row text-center">
		<br>
		<nav style="background-color: white; border-color: black"
			class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#defaultNavbar1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">MAAL</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="defaultNavbar1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="prova.jsp">Home<span
								class="sr-only">(current)</span></a></li>
						<li><a href="#">Calendar</a></li>

						<li class="Forum"><a class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Forum<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="InsertQuestion.jsp">Insert question</a></li>
								<li><a href="AllQuestion.jsp">View all question</a></li>
							</ul></li>

						<li><a href="#">Profile</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group"></div>
						<input type="text" class="form-control" placeholder="Search">
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
	<div class="row">
		<div class="col-md-4">
			<div style="background-color: #A22531"
				class="btn-group-vertical jumbotron text-center"
				aria-label="Vertical button group" role="group">
				<br>
				<button type="button" class="btn btn-primary btn-lg"
					style="background-color: :#272F54">Communication</button>
				<br>
				<button style="background-color: :#272F54" type="button"
					class="btn btn-primary btn-lg">
					Today<br> lesson <br>
				</button>
				<br>

				<button style="background-color: :#272F54" type="button"
					class="btn btn-primary btn-lg">Lesson&nbsp;</button>
				<br> <br> <a href="index.jsp">
					<button style="background-color: :#272F54" type="button"
						class="btn btn-primary btn-lg">Logout</button>
				</a> <br> <br>

				
			</div>
		</div>
		<div style="background-color: #F6C640;"
			class="jumbotron jumbotron-fluid text-center col-lg-8 col-md-8">
			<div class="grid-container">
					<div class="grid-item">
						<p>Next lesson is</p>
						<p style="font-size:50px"> 
						<%=req.getNextLesson().getSubjectLesson().getAbbrevation()%>
						</p>
						<p> ROOM  
						<%=req.getNextLesson().getRoomLesson().getName()%>
						</p>
					</div>
					<div class="grid-item">2</div>
					<div class="grid-item">
						<p>Leave home at</p>
						<p style="font-size:50px"> 
						<%=req.getHourToExit()%>
						</p>
						<p> FOR SEATS IN THE BAND   
						<%=req.getPriority()%>
						</p>
					</div>
					<div class="grid-item">2</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>