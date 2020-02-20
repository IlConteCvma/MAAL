<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="logic.bean.TimeToExitBean, logic.Session"%>

<!DOCTYPE>


<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<style>
#mapcanvas {
	height: 360px;
	width: 100%
}
</style>

<style>
.div {
	text-align: center;
}

.room {
	display: grid;
	grid-template-columns: 16% 16% 16% 16% 16% 16%;
	padding: 1px;
}

.seat {
	border: 1px solid rgba(0, 0, 0, 0.8);
	padding: 2px;
	margin: 1px;
	font-size: 10px;
	text-align: center;
}

.grid-container {
	display: grid;
	grid-template-columns: 50% 50%;
	padding: 2px;
}

.grid-item {
	background-color: #A22531;
	border: 1px solid rgba(0, 0, 0, 0.8);
	padding: 2px;
	margin: 1px;
	font-size: 20px;
	text-align: center;
}
</style>

<title>MAAL Assistant</title>
<!-- Bootstrap -->
<link href="css/bootstrap-3.4.1.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">


</head>
<%
	TimeToExitBean req = (TimeToExitBean) (session.getAttribute("timeBean2"));
%>
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

							<li><a class="dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Forum<span
									class="caret"></span></a>
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
								String usr = Session.getSession().getStudent().getName() + " "
										+ Session.getSession().getStudent().getSurname() + "("
										+ Session.getSession().getStudent().getUsername() + ")";
							%>
							<table style="margin-top: 2%">
								<tr>
									<th>
										<li disable><label"><%=usr%> </label></li>
									</th>
									<th><a href="index.jsp"> <img
											style="width: 20px; height: 19px; margin-left: 5xpx"
											src="img/logout.png">
									</a></th>
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
						type="button" class="btn btn-primary btn-lg">Lesson info</button>
					<br> <br> <a href="index.jsp">
						<button style="background-color: #272F54; width: 100%;"
							type="button" class="btn btn-primary btn-lg">Logout</button>
					</a> <br> <br>


				</div>
			</div>
			<div style="background-color: #F6C640; min-height: 507px;"
				class="jumbotron jumbotron-fluid text-center col-lg-8 col-md-8">
				<div class="grid-container">
					<div class="grid-item">
						<p style="color: #F6C640">Next lesson is</p>
						<p style="color: #F6C640;font-size: 50px;">
							<%=req.getNextLesson().getSubjectLesson().getAbbrevation()%>
						</p>
						<p style="color: #F6C640">
							ROOM
							<%=req.getNextLesson().getRoomLesson().getName()%>
						</p>
					</div>

					<div class="grid-item">
						<p style="color: #F6C640">Book the seat</p>
						<form style="display: block-inline"
							action="${pageContext.request.contextPath}/ManageRoomServlet"
							method="POST">
							<div class="room">

								<%
									for (int i = 0; i < req.getNextLesson().getRoomLesson().getNumberOfPlaces(); i++) {
								%>
								<div class="seat">
									<%
										if (req.getNextLesson().getRoomLesson().getPlaces().get(i).getState()) {
												if (Session.getSession().getIndexOfSeat() == (i+1)) {
									%>
									<input style="display: inline; background-color: #EDC32C"
										type="submit" name="seat" value="<%=i + 1%>">
									<%
										} else {
									%>
									<input style="display: inline; background-color: red"
										type="submit" name="seat" value="<%=i + 1%>" disabled>
									<%
										}
									%>
									<input type="hidden" name="<%=i + 1%>" value="red">
									<%
										}else{ 
											if (((int) Session.getSession().getIndexOfSeat() != -1 && (int) Session.getSession().getIndexOfSeat() != 0)) {
									%>
									<input style="display: inline; background-color: green"
										type="submit" name="seat" value="<%=i + 1%>" disabled> <input
										type="hidden" name="<%=i + 1%>" value="green">
									<%
										}else{
											%>
											<input style="display: inline; background-color: green"
										type="submit" name="seat" value="<%=i + 1%>"> <input
										type="hidden" name="<%=i + 1%>" value="green">
											<%
										}
										}
									%>
								</div>
								<%
									}
								%>

							</div>
						</form>
					</div>

					<div class="grid-item">
						<p style="color: #F6C640">Leave home at</p>
						<p style="color: #F6C640;font-size: 50px">
							<%=req.getHourToExit()%>
						</p>
						<p style="color: #F6C640">
							FOR SEATS IN THE BAND
							<%=req.getPriority()%>
						</p>
					</div>
					<div class="grid-item">
						<div style="height: 100%" id="mapcanvas">

							<script type="text/javascript">
								document.map = new google.maps.Map(document
										.getElementById("mapcanvas"));
								var latlng = new google.maps.LatLng(41.85,
										12.63);
								var Options = {
									zoom : 15,
									center : latlng,
									mapTypeId : google.maps.MapTypeId.ROADMAP
								};
								var map = new google.maps.Map(document
										.getElementById("mapcanvas"), Options);
								//var carMarkerImage = new google.maps.MarkerImage('resources/images/car.png');
								var marker = new google.maps.Marker({
									position : new google.maps.LatLng(
											41.8546187, 12.6208633),
									map : map,
									draggable : false,
									//icon: carMarkerImage,
									title : "",
									autoPan : true

								});
								var infobulle = new google.maps.InfoWindow({
									content : "University of Tor Vergata"
								});
								google.maps.event.addListener(marker,
										'mouseover', function() {
											infobulle.open(map, marker);
										});

								document.goToLocation = function(x, y) {
									alert("goToLocation, x: " + x + ", y:" + y);
									var latLng = new google.maps.LatLng(x, y);
									marker.setPosition(latLng);
									map.setCenter(latLng);
								}
							</script>


						</div>

					</div>
					<div style="border: none; background-color: #F6C640;"
						class="grid-item"></div>
					<jsp:useBean id="controlRoad" scope="session"
						class="logic.controller.ViewRoadController" />
					<a target="_blank" href="<%=controlRoad.getRoad()%>"><button
							style="background-color: #272F54;color: white; width: 100%" >Go to
							google maps</button> </a>
				</div>
			</div>
		</div>
	</div>
	
	<%
		if(request.getAttribute("exit")!=null){
			int valueExit = (int)request.getAttribute("exit");
			switch(valueExit){
				case 7:	%><script> alert("Seat unbooked") </script><%
						break;
				case 8:	%><script> alert("Seat booked") </script><%
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