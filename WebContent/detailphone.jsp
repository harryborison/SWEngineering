<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javacode.DBTest"%>
<%@ page import="javacode.DBCon"%>


<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <!-- Site made with Mobirise Website Builder v4.10.0, https://mobirise.com -->
  <meta charset="EUC-KR">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.10.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets3/images/logo4.png" type="image/x-icon">
  <meta name="description" content="">
  
  <title>스마트폰 상세보기</title>
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
	request.setCharacterEncoding("UTF-8");

	phoneName = request.getParameter("phoneName");
 	System.out.println(phoneName);
	ResultSet result = null;
	String query = null;
	  // 쿼리를 실행하기 위한 Statement 객체 생성
	  DBCon dbc = new DBCon();
	  Connection connection = dbc.getmyConnection();
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
                    <p class="mbr-text mbr-fonts-style display-5">제조사 : <%=result.getString(2) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;가격 : <%=result.getString(3) %>원</p>
                    <p class="mbr-text mbr-fonts-style display-5">화면사이즈 : <%=result.getString(4) %>inch</p>
                    <p class="mbr-text mbr-fonts-style display-5">운영체제 : <%=result.getString(5) %></p>
                    <p class="mbr-text mbr-fonts-style display-5">용량 : <%=result.getString(6) %>GB</p>
                    <p class="mbr-text mbr-fonts-style display-5">램 : <%=result.getString(7) %>GB&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전면카메라 : <%=result.getString(8) %>만 화소</p>
                    <p class="mbr-text mbr-fonts-style display-5">후면카메라 : <%=result.getString(9) %>만 화소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;무게 : <%=result.getString(10) %>g</p>
                   
                    <p class="mbr-text mbr-fonts-style display-5">크기 : <%=result.getString(11) %>(mm)&nbsp;&nbsp;&nbsp;&nbsp;속도 : <%=result.getString(13) %>Ghz</p>
                  	<p class="mbr-text mbr-fonts-style display-5">배터리 용량 : <%=result.getString(12) %>mAh</p>
                    <p class="mbr-text mbr-fonts-style display-5">해상도 : <%=result.getString(14) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;출시년도 : <%=result.getString(15) %></p>
                   
                   
                    
                    
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