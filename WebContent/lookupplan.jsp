<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Site made with Mobirise Website Builder v4.10.0, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.10.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo4.png" type="image/x-icon">
  <meta name="description" content="">
 
  
  <title>����� ��ȸ</title>
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/datatables/data-tables.bootstrap4.min.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

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
      <h2 class="mbr-section-title mbr-fonts-style align-center pb-3 display-2"><strong>
          ����� ��ü ����</strong></h2>
      <h3 class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5"><strong>
            ����� ��ü���� ����Դϴ� �˻���ɰ� ���Ʒ� ��ư�� ���ؼ� ���ı���� ��� �� �� �ֽ��ϴ�.</strong></h3>
      <div class="table-wrapper">
        <div class="container">
          <div class="row search">
            <div class="col-md-5"></div>
            <div class="col-md-5">
                <div class="dataTables_filter">
                  <label class="searchInfo mbr-fonts-style display-7"><strong>�˻�</strong></label>
                  <input class="form-control input-sm" disabled="">
                </div>
            </div>
          </div>
        </div>

        <div class="container scroll">
          <table class="table isSearch" cellspacing="0">
            <thead>
              <tr class="table-heads ">
                  
                  
                  
                   <th class="head-item mbr-fonts-style display-7">��Ż�</th>
              <th class="head-item mbr-fonts-style display-7">����� �̸�</th><th class="head-item mbr-fonts-style display-7">
                      ���� (��)</th><th class="head-item mbr-fonts-style display-7">
                      ������</th><th class="head-item mbr-fonts-style display-7">
                      �󼼺���</th></tr>
            </thead>

            <tbody>
           	
           <%
             
         ResultSet result = null;
         String query = null;
           // ������ �����ϱ� ���� Statement ��ü ���� 
           Connection connection = DBCon.getmyConnection();
           Statement statement =connection.createStatement();
         // ������ �ۼ� 
         query = "SELECT * from testdb.planInfo ";
         // ������ ���� 
         result = statement.executeQuery(query);
         
         while(result.next())
         {
             out.println("<tr><td class=\"body-item mbr-fonts-style display-7\">"+result.getString(1)+"</td>"
            		 +"<td class=\"body-item mbr-fonts-style display-7\">"+result.getString(2)+"</td>" 
            		 +"<td class=\"body-item mbr-fonts-style display-7\">"+result.getString(4)+"</td>"
                     +"<td class = \"body-item mbr-fonts-style display-7\">"+result.getString(5)+"</td>"
                     +"<td>"
                    +"<form action = \"detailplan.jsp\" method = \"post\"><input type = \"hidden\" name = \"planName\""
                    +"value = \""+result.getString(2)+"\">"
                    +"<input type = \"submit\" value = \"�󼼺���\" class=\"body-item mbr-fonts-style display-7\"></form></tr>" 
                   ); 
         }
         
         result.close();
         
         %>
              
            </tbody>
                
                
                
                
                </table>
        </div>
        <div class="container table-info-container">
          <div class="row info">
            <div class="col-md-5">
              <div class="dataTables_info mbr-fonts-style display-7">
                <span class="infoBefore">Showing</span>
                <span class="inactive infoRows"></span>
                <span class="infoAfter">entries</span>
                <span class="infoFilteredBefore">(filtered from</span>
                <span class="inactive infoRows"></span>
                <span class="infoFilteredAfter"> total entries)</span>
              </div>
            </div>
            <div class="col-md-5"></div>
          </div>
        </div>
      </div>
    </div>
</section>


  <section class="engine"><a href="https://mobirise.info/r">bootstrap template</a></section><script src="assets/web/assets/jquery/jquery.min.js"></script>
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