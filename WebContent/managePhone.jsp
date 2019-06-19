<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javacode.DBTest"%>
<%@ page import="javacode.DBCon"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<!-- Site made with Mobirise Website Builder v4.10.0, https://mobirise.com -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.10.0, mobirise.com">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1">
<link rel="shortcut icon" href="assets/images/logo4.png"
	type="image/x-icon">
<meta name="description" content="">


<title>스마트폰 관리</title>
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet"
	href="assets/datatables/data-tables.bootstrap4.min.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">

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

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="home.jsp">HOME</a>

		</div>
	</nav>


	<section class="section-table cid-rq6r9igM31" id="table1-3">
		<div class="container container-table">
			<h2
				class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
				<strong> 스마트폰 DB</strong>
			</h2>
			<h3
				class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
				<strong> 관리자 전용 페이지 입니다.</strong>
			</h3>
			<h3
				class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">

			</h3>

			<div class="table-wrapper">

				<div class="container">
					<div class="mbr-section-btn pt-4 text-center">
						<form action="addPhone.jsp" method="post">
							<input type="submit" value="데이터 추가"
								class="btn btn-primary display-4">
						</form>
					</div>
					<div class="row search">
						<div class="col-md-7"></div>
						<div class="col-md-7">
							<div class="dataTables_filter">
								<label class="searchInfo mbr-fonts-style display-7"><strong>검색</strong></label>
								<input class="form-control input-sm" disabled="">
							</div>

						</div>

					</div>

				</div>

				<div class="container scroll">
					<table class="table isSearch" cellspacing="0">
						<thead>
							<tr class="table-heads ">




								<th class="head-item mbr-fonts-style display-7">휴대폰 이름</th>
								<th class="head-item mbr-fonts-style display-7">제조사</th>
								<th class="head-item mbr-fonts-style display-7">용량</th>
								<th class="head-item mbr-fonts-style display-7">&nbsp;가격</th>
								<th class="head-item mbr-fonts-style display-7">출시일</th>
								<th class="head-item mbr-fonts-style display-7">관리</th>
							</tr>
						</thead>

						<tbody>







							<%
             
         ResultSet result = null;
         String query = null;
           // 쿼리를 실행하기 위한 Statement 객체 생성 
           Connection connection = DBCon.getmyConnection();System.out.println("ASDASD");
           Statement statement =connection.createStatement();
         // 쿼리문 작성 
         query = "SELECT * from testdb.phoneInfo ";
         // 쿼리문 실행 
         result = statement.executeQuery(query);
         
         while(result.next())
         {
             out.println("<tr><td class=\"body-item mbr-fonts-style display-7\">"+result.getString(1)+"</td>"
                      +"<td class=\"body-item mbr-fonts-style display-7\">"+result.getString(2)+"</td>"
                     +"<td class = \"body-item mbr-fonts-style display-7\">"+Integer.parseInt(result.getString(6))+"</td>"
                     +"<td class = \"body-item mbr-fonts-style display-7\">"+Integer.parseInt(result.getString(3))+"</td>"
                     +"<td class = \"body-item mbr-fonts-style display-7\">"+Integer.parseInt(result.getString(15))+"</td>"
                     +"<td>"
                    +"<form action = \"deletePhone.jsp\" style=\"display: inline;\" method = \"post\"><input type = \"hidden\" name = \"phoneName\""
                    +"value = \""+result.getString(1)+"\">"
                    +"<input type = \"submit\" value = \"삭제\"  class=\"body-item mbr-fonts-style display-7\"></form>"
                    
                   ); 
         }
         
         result.close();
         
         %>

						</tbody>









					</table>
				</div>
				<div class="container table-info-container">
					<div class="row info">
						<div class="col-md-7">
							<div class="dataTables_info mbr-fonts-style display-7">
								<span class="infoBefore">Showing</span> <span
									class="inactive infoRows"></span> <span class="infoAfter">entries</span>
								<span class="infoFilteredBefore">(filtered from</span> <span
									class="inactive infoRows"></span> <span
									class="infoFilteredAfter"> total entries)</span>
							</div>
						</div>
						<div class="col-md-7"></div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="engine">
		<a href="https://mobirise.info/r">bootstrap template</a>
	</section>
	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/datatables/jquery.data-tables.min.js"></script>
	<script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
	<script src="assets/theme/js/script.js"></script>

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