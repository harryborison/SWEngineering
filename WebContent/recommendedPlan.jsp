<%@ page import="javaCode.Plan"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Site made with Mobirise Website Builder v4.10.1, https://mobirise.com -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.10.1, mobirise.com">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1">
<link rel="shortcut icon" href="assets4/images/logo4.png"
	type="image/x-icon">
<meta name="description" content="">

<title>����� ��õ</title>
<link rel="stylesheet" href="assets4/tether/tether.min.css">
<link rel="stylesheet" href="assets4/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets4/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets4/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets4/theme/css/style.css">
<link rel="stylesheet" href="assets4/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	Plan firstPlan = new Plan();
	Plan secondPlan = new Plan();
	Plan thirdPlan = new Plan();
	
	firstPlan = (Plan)request.getAttribute("plan1");
	secondPlan = (Plan)request.getAttribute("plan2");
	thirdPlan = (Plan)request.getAttribute("plan3");
	
	String p1 = new String();
	String p2 = new String();
	String p3 = new String();
	
	double temp = Double.valueOf(firstPlan.getPlanPrice()).doubleValue();
	temp /= 10000; 
	p1 = String.format("%.1f", temp);
	
	temp = Double.valueOf(secondPlan.getPlanPrice()).doubleValue();
	temp /= 10000; 
	p2 = String.format("%.1f", temp);
	
	temp = Double.valueOf(thirdPlan.getPlanPrice()).doubleValue();
	temp /= 10000; 
	p3 = String.format("%.1f", temp);
%>



	<section class="pricing-table3 cid-rruaJ6FYPe" id="pricing-tables3-1"
		data-bg-video="https://www.youtube.com/watch?v=dlk9xmhntrI">



		<div class="mbr-overlay"
			style="opacity: 0; background-color: rgb(206, 191, 175);"></div>
		<div class="container">
			<div class="media-container-row">
				<div class=" col-12 col-lg-4 col-md-6 my-2">
					<div class="pricing">
						<div class="plan-header">
							<div class="plan-price">
								<span class="price-value mbr-fonts-style display-5"> $ </span> <span
									class="price-figure mbr-fonts-style display-1"><%=p1 %></span>
								<h3 class="plan-title mbr-fonts-style display-5"><%=firstPlan.getPlanName() %></h3>
								<hr>
							</div>
						</div>
						<div class="plan-body">
							<p class="mbr-text mbr-fonts-style display-7">
								<%=firstPlan.getOperator() %>&nbsp;&nbsp;&nbsp;&nbsp;<%=firstPlan.getMobile() %>
								�����<br>
								<br>�� ������ :
								<%=firstPlan.getAmtOfData() %><br>�� ��ȭ :
								<%=firstPlan.getCall() %><br>�� ���� :
								<%=firstPlan.getMessage() %><br>
								<br>
							</p>
							<form action="detailplan.jsp" method="post">
								<input type="hidden" name="planName"
									value="<%= firstPlan.getPlanName()%>">
								<div class="mbr-section-btn pt-4 text-center">
									<input type="submit" value="������ ����"
										class="btn btn-primary display-4">
								</div>
						</div>
					</div>
				</div>

				<div class="col-12 col-lg-4 col-md-6 my-2">
					<div class="pricing">
						<div class="plan-header">
							<div class="plan-price">
								<span class="price-value mbr-fonts-style display-5"> $ </span> <span
									class="price-figure mbr-fonts-style display-1"> <%=p2 %>
								</span>
								<h3 class="plan-title mbr-fonts-style display-5"><%=secondPlan.getPlanName() %></h3>
								<hr>
							</div>
						</div>
						<div class="plan-body">
							<p class="mbr-text mbr-fonts-style display-7">
								<%=secondPlan.getOperator() %>&nbsp;&nbsp;&nbsp;&nbsp;<%=secondPlan.getMobile() %>
								�����<br>
								<br>�� ������ :
								<%=secondPlan.getAmtOfData() %><br>�� ��ȭ :
								<%=secondPlan.getCall() %><br>�� ���� :
								<%=secondPlan.getMessage() %><br>
								<br>
							</p>
							<form action="detailplan.jsp" method="post">
								<input type="hidden" name="planName"
									value="<%= secondPlan.getPlanName()%>">
								<div class="mbr-section-btn pt-4 text-center">
									<input type="submit" value="������ ����"
										class="btn btn-primary display-4">
								</div>
						</div>
					</div>
				</div>

				<div class="col-12 col-lg-4 col-md-6 my-2">
					<div class="pricing">
						<div class="plan-header">
							<div class="plan-price">
								<span class="price-value mbr-fonts-style display-5"> $ </span> <span
									class="price-figure mbr-fonts-style display-1"> <%=p3 %>
								</span>
								<h3 class="plan-title mbr-fonts-style display-5">
									<%=thirdPlan.getPlanName() %></h3>
								<hr>
							</div>
						</div>
						<div class="plan-body ">
							<p class="mbr-text mbr-fonts-style display-7">
								<%=thirdPlan.getOperator() %>&nbsp;&nbsp;&nbsp;&nbsp;<%=thirdPlan.getMobile() %>
								�����<br>
								<br>�� ������ :
								<%=thirdPlan.getAmtOfData() %><br>�� ��ȭ :
								<%=thirdPlan.getCall() %><br>�� ���� :
								<%=thirdPlan.getMessage() %><br>
								<br>
							</p>
							<form action="detailplan.jsp" method="post">
								<input type="hidden" name="planName"
									value="<%= thirdPlan.getPlanName()%>">
								<div class="mbr-section-btn pt-4 text-center">
									<input type="submit" value="������ ����"
										class="btn btn-primary display-4">
								</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>


	<section class="engine">
		<a href="https://mobirise.info/q">responsive website templates</a>
	</section>
	<script src="assets4/web/assets/jquery/jquery.min.js"></script>
	<script src="assets4/popper/popper.min.js"></script>
	<script src="assets4/tether/tether.min.js"></script>
	<script src="assets4/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets4/smoothscroll/smooth-scroll.js"></script>
	<script src="assets4/ytplayer/jquery.mb.ytplayer.min.js"></script>
	<script src="assets4/vimeoplayer/jquery.mb.vimeo_player.js"></script>
	<script src="assets4/theme/js/script.js"></script>


</body>
</html>