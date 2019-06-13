<%@ page import="javaCode.Model"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<!-- Site made with Mobirise Website Builder v4.10.1, https://mobirise.com -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.10.1, mobirise.com">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1">
<link rel="shortcut icon" href="assets5/images/logo4.png"
	type="image/x-icon">
<meta name="description" content="">

<title>스마트폰 추천</title>
<link rel="stylesheet" href="assets5/tether/tether.min.css">
<link rel="stylesheet" href="assets5/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets5/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets5/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets5/theme/css/style.css">
<link rel="stylesheet" href="assets5/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>

	<%!


%>

	<%
	request.setCharacterEncoding("UTF-8");

	System.out.println("AAAAAAAA");
	
	Model firstPhone = new Model();
	Model secondPhone = new Model();
	Model thirdPhone = new Model();
	//String a=request.getParameter("data");
	//out.println(a);
	//a="abC";
	//String abc = "AA";
	firstPhone = (Model)request.getAttribute("phone1");
	//out.println(firstPhone.phoneName);
	secondPhone = (Model)request.getAttribute("phone2");
	thirdPhone = (Model)request.getAttribute("phone3");
	
	String s1 = String.valueOf(firstPhone.getCapacity());
	String s2 = String.valueOf(secondPhone.getCapacity());
	String s3 = String.valueOf(thirdPhone.getCapacity());
	
	String p1 = new String();
	String p2 = new String();
	String p3 = new String();
	
	double temp = Double.valueOf(firstPhone.getPhonePrice()).doubleValue();
	if(temp >= 1000000.0) // 1280000
	{
		temp = temp / 10000;
		p1 = String.format("%.1f", temp);	
	}
	else
	{
		temp = temp / 10000;
		p1 = String.format("%.1f", temp);
	}
	
	temp = Double.valueOf(secondPhone.getPhonePrice()).doubleValue();
	if(temp >= 1000000.0) // 1280000
	{
		temp = temp / 10000;
		p2 = String.format("%.1f", temp);	
	}
	else
	{
		temp = temp / 10000;
		p2 = String.format("%.1f", temp);
	}
	
	temp = Double.valueOf(thirdPhone.getPhonePrice()).doubleValue();
	if(temp >= 1000000.0) // 1280000
	{
		temp = temp / 10000;
		p3 = String.format("%.1f", temp);	
	}
	else
	{
		temp = temp / 10000;
		p3 = String.format("%.1f", temp);
	}
%>

	<section class="pricing-table3 cid-rruoh41Ypk" id="pricing-tables3-6"
		data-bg-video="https://www.youtube.com/watch?v=neqXWmV9J7k">



		<div class="mbr-overlay"
			style="opacity: 0.1; background-color: rgb(35, 35, 35);"></div>
		<div class="container">
			<div class="media-container-row">
				<div class=" col-12 col-lg-4 col-md-6 my-2">
					<div class="pricing">
						<div class="plan-header">
							<div class="plan-price">
								<span class="price-value mbr-fonts-style display-5"> </span> <span
									class="price-figure mbr-fonts-style display-2"><%=firstPhone.getPhoneName() %></span>
								<h3 class="plan-title mbr-fonts-style display-5"></h3>
								<hr>
							</div>
						</div>
						<div class="plan-body">
							<p class="mbr-text mbr-fonts-style display-7">
								회사 :
								<%=firstPhone.getCompany() %><br>가격 :
								<%=p1 %>만원<br>용량 :
								<%=firstPhone.getCapacity()%>GB<br>
							</p>
							<form action="detailphone.jsp" method="post">
								<input type="hidden" name="phoneName"
									value="<%= firstPhone.getPhoneName()%>">
								<div class="mbr-section-btn pt-4 text-center">
									<input type="submit" value="상세정보 보기"
										class="btn btn-primary display-4">
								</div>
							</form>
						</div>
					</div>
				</div>

				<div class="col-12 col-lg-4 col-md-6 my-2">
					<div class="pricing">
						<div class="plan-header">
							<div class="plan-price">
								<span class="price-value mbr-fonts-style display-5"> </span> <span
									class="price-figure mbr-fonts-style display-2"><%=secondPhone.getPhoneName() %></span>
								<h3 class="plan-title mbr-fonts-style display-5"></h3>
								<hr>
							</div>
						</div>
						<div class="plan-body">
							<p class="mbr-text mbr-fonts-style display-7">
								회사 :
								<%=secondPhone.getCompany() %><br>가격 :
								<%=p2 %>만원<br>용량 :
								<%=secondPhone.getCapacity()%>GB
							</p>
							<form action="detailphone.jsp" method="post">
								<input type="hidden" name="phoneName"
									value="<%= secondPhone.getPhoneName()%>">
								<div class="mbr-section-btn pt-4 text-center">
									<input type="submit" value="상세정보 보기"
										class="btn btn-primary display-4">
								</div>
							</form>
						</div>
					</div>
				</div>

				<div class="col-12 col-lg-4 col-md-6 my-2">
					<div class="pricing">
						<div class="plan-header">
							<div class="plan-price">
								<span class="price-value mbr-fonts-style display-5"> </span> <span
									class="price-figure mbr-fonts-style display-2"><%=thirdPhone.getPhoneName() %></span>
								<h3 class="plan-title mbr-fonts-style display-5"></h3>
								<hr>
							</div>
						</div>
						<div class="plan-body ">
							<p class="mbr-text mbr-fonts-style display-7">
								회사 :
								<%=thirdPhone.getCompany() %><br>가격 :
								<%=p3 %>만원<br>용량 :
								<%=thirdPhone.getCapacity()%>GB
							</p>
							<form action="detailphone.jsp" method="post">
								<input type="hidden" name="phoneName"
									value="<%= thirdPhone.getPhoneName()%>">
								<div class="mbr-section-btn pt-4 text-center">
									<input type="submit" value="상세정보 보기"
										class="btn btn-primary display-4">
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>


	<section class="engine">
		<a href="https://mobirise.info/v">free html templates</a>
	</section>
	<script src="assets5/web/assets/jquery/jquery.min.js"></script>
	<script src="assets5/popper/popper.min.js"></script>
	<script src="assets5/tether/tether.min.js"></script>
	<script src="assets5/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets5/smoothscroll/smooth-scroll.js"></script>
	<script src="assets5/ytplayer/jquery.mb.ytplayer.min.js"></script>
	<script src="assets5/vimeoplayer/jquery.mb.vimeo_player.js"></script>
	<script src="assets5/theme/js/script.js"></script>


</body>
</html>