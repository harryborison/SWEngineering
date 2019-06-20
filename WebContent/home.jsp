<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javacode.DBTest"%>
<%@ page import="javacode.DBCon"%>
<%@ page import="javacode.CustomerControlDB" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>홈</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">

</head>

<body id="page-top">
	<%
	String name = "";
	String id = new String();
	id = null;
	//session.removeAttribute("id");
	id = (String)session.getAttribute("id");
	if(id != null)
	{
		CustomerControlDB test = new CustomerControlDB();
		name = test.getNameFromID(id);
	}
	%>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">HOME</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">Services</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#team">Team</a></li>

					<%if(id == null){%>

					<li class="nav-item">
						<h4 class="service-heading">
							<a href="login.jsp">LOGIN</a>
						</h4>
					</li>
					<%}else{ %>
					<li class="nav-item">
						<h4 class="service-heading">
							<a href="logout.jsp">LOGOUT</a>
						</h4>
					</li>
					<%} %>

					<li class="nav-item">
						<h4 class="service-heading">
							<a>&nbsp;&nbsp;</a>
						</h4>
					</li>
					<li class="nav-item">
						<h4 class="service-heading">
							<a href="signup.jsp">SIGN UP</a>
						</h4>
					</li>
				</ul>

			</div>




		</div>
	</nav>

	<!-- Header -->
	<header class="masthead">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in"></div>
				<%if(id != null){%>
					<h2 class="section-heading text-uppercase"><%=name %> 님 안녕하세요!</h2><br>
					
					<%}%>
				<div class="intro-heading text-uppercase">스마트폰 & 요금제 추천</div>
				
				
				
					
				
				
				
				
				<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
					href="#services">START</a>

			</div>
		</div>
	</header>

	<!-- Services -->
	<section class="page-section" id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Services</h2>
					<h3 class="section-subheading text-muted"></h3>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/1.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="lookupsmartphone.jsp">스마트폰 조회</a>
					</h4>
					<p class="text-muted"></p>
				</div>

				<%if(id == null){%>
				<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/2.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="login.jsp">스마트폰 추천</a>
					</h4>
					<p class="text-muted">Login required.</p>
				</div>

				<%}else{ %>
				<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/2.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="recomsmartphone.jsp">스마트폰 추천</a>
					</h4>
					<p class="text-muted">Login required.</p>
				</div>

				<%} %>





				<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/3.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="lookupplan.jsp">요금제 조회</a>
					</h4>
					<p class="text-muted"></p>
				</div>
				
				<%if(id == null){%>
					<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/4.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="login.jsp">요금제 추천</a>
					</h4>
					<p class="text-muted">Login required.</p>
				</div>
					
					<%}else{ %>
					<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/4.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="recomplan.jsp">요금제 추천</a>
					</h4>
					<p class="text-muted">Login required.</p>
				</div>
					<%} %>
				
				
				<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/5.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="ranking.jsp">랭킹 조회</a>
					</h4>
					<p class="text-muted"></p>
				</div>
				
				<%if(id != null && id.equals("admin")){%>
				
				
				<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/a1.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="managePhone.jsp">스마트폰 데이터 관리</a>
					</h4>
					<p class="text-muted"></p>
				</div>
				
				<div class="col-md-3">
					<span class="fa-stack fa-4x"> 
					<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/a2.jpg"
									alt="" style = "width:130px;height:130px;">
							</div>
					</span>
					<h4 class="service-heading">
						<a href="managePlan.jsp">요금제 데이터 관리</a>
					</h4>
					<p class="text-muted"></p>
				</div>
				<%} %>
			</div>
		</div>
	</section>

	<!-- About -->
	<section class="page-section" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">PROJECT PROCESS</h2>
					<h3 class="section-subheading text-muted">Lorem ipsum dolor
						sit amet consectetur.</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<ul class="timeline">
						<li>
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/1.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>2009-2011</h4>
									<h4 class="subheading">Our Humble Beginnings</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/11.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>March 2011</h4>
									<h4 class="subheading">An Agency is Born</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/22.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>December 2012</h4>
									<h4 class="subheading">Transition to Full Service</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/33.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>July 2014</h4>
									<h4 class="subheading">Phase Two Expansion</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<h4>
									Be Part <br>Of Our <br>Story!
								</h4>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<!-- Team -->
	<section class="bg-light page-section" id="team">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Team Seven Valley</h2>
					<h3 class="section-subheading text-muted">Software Engineering
						Team 9</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/ssm.jpg" alt="">
						<h4>신승민</h4>
						<p class="text-muted">Project Manager</p>
						<ul class="list-inline social-buttons">
							
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/hsy.jpg" alt="">
						<h4>황석영</h4>
						<p class="text-muted">Web Developer</p>
						<ul class="list-inline social-buttons">
							
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/psg.jpg" alt="">
						<h4>박성곤</h4>
						<p class="text-muted">Data Manager</p>
						<ul class="list-inline social-buttons">
							
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/pwh.jpg" alt="">
						<h4>박윤화</h4>
						<p class="text-muted">DB Developer</p>
						<ul class="list-inline social-buttons">
							
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<p class="large text-muted"></p>
				</div>
			</div>
		</div>
	</section>

	<!-- Clients -->
	<section class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<a href="#"> <img class="img-fluid d-block mx-auto"
						 alt="">
					</a>
				</div>
				<div class="col-md-3 col-sm-6">
					<a href="http://sselab.dothome.co.kr/"> <img class="img-fluid d-block mx-auto"
						src="img/logos/logo1.jpg" alt="">
					</a>
				</div>
				<div class="col-md-3 col-sm-6">
					<a href="http://knu.ac.kr"> <img class="img-fluid d-block mx-auto"
						src="img/logos/logo2.jpg" alt="">
					</a>
				
			</div>
		</div>
	</section>


	<!-- Footer -->
	

	<!-- Portfolio Modals -->

	<!-- Modal 1 -->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="img/portfolio/01-full.jpg" alt="">
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Threads</li>
									<li>Category: Illustration</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 2 -->
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="img/portfolio/02-full.jpg" alt="">
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Explore</li>
									<li>Category: Graphic Design</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 3 -->
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="img/portfolio/03-full.jpg" alt="">
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Finish</li>
									<li>Category: Identity</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 4 -->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="img/portfolio/04-full.jpg" alt="">
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Lines</li>
									<li>Category: Branding</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 5 -->
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="img/portfolio/05-full.jpg" alt="">
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Southwest</li>
									<li>Category: Website Design</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 6 -->
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="img/portfolio/06-full.jpg" alt="">
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2017</li>
									<li>Client: Window</li>
									<li>Category: Photography</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Contact form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/agency.min.js"></script>

</body>

</html>