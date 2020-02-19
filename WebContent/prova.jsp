<%@ 
page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
import="logic.Session"
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MAAL Assistant</title>
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

</head>
<body style="background-color: #e2e7ec">
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
						<a class="navbar-brand" href="prova.jsp">MAAL</a>
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
						
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group"></div>
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
		<div class="row">
			<div class="col-md-4">
				<div
					style="background-color: #A22531; min-width: 370px; min-height: 507px;"
					class="btn-group-vertical jumbotron text-center"
					aria-label="Vertical button group" role="group">
					<br>
					<button type="submit" class="btn btn-primary btn-lg"
						style="background-color: #272F54; width: 100%">Communication</button>
					<br>
					<button style="background-color: #272F54; width: 100%"
						type="button" class="btn btn-primary btn-lg">
						Today lesson <br>
					</button>
					<br>

					<button style="background-color: #272F54; width: 100%"
						type="button" class="btn btn-primary btn-lg">Lesson info </button>
					<br> <br> <a href="index.jsp">
						<button style="background-color: #272F54; width: 100%;"
							type="button" class="btn btn-primary btn-lg">Logout</button>
					</a> <br> <br>


				</div>
			</div>
			<div style="background-color: #F6C640; min-height: 507px;"
				class="jumbotron jumbotron-fluid text-center col-lg-8 col-md-8">
				<h1 class="display-4">Welcome</h1>
				<h2> <%=Session.getSession().getStudent().getName()+" "+Session.getSession().getStudent().getSurname()%>  </h2>
				<p class="lead">Would you use the assistant of you journey to
					University?</p>
				<br> <br> <br> <br> <br> <br>
				<hr class="my-4">
				<p class="lead">
				<form action="${pageContext.request.contextPath}/TimeToExitServlet"
					name="myform" method="POST">
					<input name="login" type="submit" id="login" value="Get started"
						class="btn btn-info" style="background-color: #272F54">
				</form>
			</div>
		</div>
	</div>
	
	
	
	<%
		if(request.getAttribute("exit")!=null){
			int valueExit = (int)request.getAttribute("exit");
			switch(valueExit){
				case 2:	%><script> alert("It's too late") </script><%
						break;
				case 3:	%><script> alert("You haven't lesson today, good relax") </script><%
						break;
				case 4:	%><script> alert("Error request to google maps, retry") </script><%
						break;
				case 5:	%><script> alert("Internal error") </script><%
						break;
				case 6:	%><script> alert("Error connect to db") </script><%
						break;
			}
		}
	%>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- <script src="js/jquery-3.4.1.min.js"></script> -->
	<script src="js/jquery-1.12.4.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/popper.min.js"></script>
	<!-- <script src="js/bootstrap-4.4.1.js"></script> -->
	<script src="js/bootstrap-3.4.1.js"></script>
</body>
</html>


