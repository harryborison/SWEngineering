<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>


<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
  <!-- Site made with Mobirise Website Builder v4.10.0, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.10.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets3/images/logo4.png" type="image/x-icon">
  <meta name="description" content="">
  
  <title>상세보기</title>
  <link rel="stylesheet" href="assets3/tether/tether.min.css">
  <link rel="stylesheet" href="assets3/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets3/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets3/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets3/theme/css/style.css">
  <link rel="stylesheet" href="assets3/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<body>
<%!
	String phoneName, company, phonePrice, screenSize, os, capacity, ram, frontCamera, 
	rearCamera, weight, phoneSize, betteryCapacity, speed, resolution, releaseYear, adURL;
%>

<%
	request.setCharacterEncoding("EUC-KR");

	phoneName = request.getParameter("phoneName");
 	
	ResultSet result = null;
	String query = null;
	  // 쿼리를 실행하기 위한 Statement 객체 생성 
	  Connection connection = DBCon.getmyConnection();
	  Statement statement =connection.createStatement();
	// 쿼리문 작성 
query = "SELECT * from phoneInfo WHERE phoneName = '" + phoneName + "'";
    result = statement.executeQuery(query);
    result.next();
	System.out.printf("\nrquery : %s",query);
	System.out.printf("\n\nresult : %s",result.getString(2));
	
	
%>

  <section class="header7 cid-rrg5WhmoYo" id="header7-g">
    <div class="container">
        <div class="media-container-row">

            <div class="media-content align-right">
                <h1 class="mbr-section-title mbr-white pb-3 mbr-fonts-style display-2"><strong>
                    <%=phoneName %></strong></h1>
                <div class="mbr-section-text mbr-white pb-3">
                    <p class="mbr-text mbr-fonts-style display-5">제조사 : <%=result.getString(2) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;화면사이즈 : <%=result.getString(4) %>inch</p>
                    <p class="mbr-text mbr-fonts-style display-5">운영체제 : <%=result.getString(5) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용량 : <%=result.getString(6) %>GB</p>
                    <p class="mbr-text mbr-fonts-style display-5">램 : <%=result.getString(7) %>GB&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전면카메라 : <%=result.getString(8) %>만 화소</p>
                    <p class="mbr-text mbr-fonts-style display-5">후면카메라 : <%=result.getString(9) %>만 화소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;무게 : <%=result.getString(10) %>g</p>
                   
                    <p class="mbr-text mbr-fonts-style display-5">크기 : <%=result.getString(11) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배터리 용량 : <%=result.getString(12) %></p>
                  
                    <p class="mbr-text mbr-fonts-style display-5">속도 : <%=result.getString(13) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;해상도 : <%=result.getString(14) %></p>
                   
                    <p class="mbr-text mbr-fonts-style display-5">출시년도 : <%=result.getString(15) %></p>
                   
                    
                    
                </div>
                
            </div>

            <div class="mbr-figure" style="width: 135%;"><iframe class="mbr-embedded-video" src="<%=result.getString(19)%>?rel=0&amp;amp;showinfo=0&amp;autoplay=0&amp;loop=0" width="1920" height="1080" frameborder="0" allowfullscreen></iframe></div>
 		<%result.close(); %>
        </div>
    </div>
</section>


  <section class="engine"><a href="https://mobirise.info/r">bootstrap template</a></section><script src="assets3/web/assets/jquery/jquery.min.js"></script>
  <script src="assets3/popper/popper.min.js"></script>
  <script src="assets3/tether/tether.min.js"></script>
  <script src="assets3/bootstrap/js/bootstrap.min.js"></script>
  <script src="assets3/smoothscroll/smooth-scroll.js"></script>
  <script src="assets3/theme/js/script.js"></script>
  
  
</body>
</html>