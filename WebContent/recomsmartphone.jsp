<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>����Ʈ�� ��õ�ޱ�</title>

  <!-- Custom fonts for this template-->
  <link href="template1/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="template1/css/sb-admin.css" rel="stylesheet">
  <!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="hh/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="hh/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="hh/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="hh/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="hh/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="hh/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="hh/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="hh/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="hh/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="hh/css/util.css">
	<link rel="stylesheet" type="text/css" href="hh/css/main.css">
<!--===============================================================================================-->
<!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="signup/css/agency.min.css" rel="stylesheet">
</head>

<script language="javascript">
function checkCompany(myform)
{
   var chk1 = document.myform.c1.checked;
   var chk2 = document.myform.c2.checked;
   var chk3 = document.myform.c3.checked;
   var chk4 = document.myform.c4.checked;
   
   if(chk1 == "" && chk2 == "" && chk3 == "" && chk4 == "")
   {
	   alert("company�� �Ѱ� �̻� �������ּ���.");
	   return false;
   }
   
   var minP = document.myform.minPr.value;
   var maxP= document.myform.maxPr.value;
   
   if(isNaN(minP) == true || isNaN(maxP) == true)
   {
	   alert("price�Է��� �߸��Ǿ����ϴ�.");
	   return false;
   }
   
   var minIntPrice = parseInt(minP);
   var maxIntPrice = parseInt(maxP);
   
   if(minIntPrice > maxIntPrice)
   {
	   alert("price�Է��� �߸��Ǿ����ϴ�.");
	   return false;
   }
   
   var p1 = document.myform.p1.checked;
   var p2 = document.myform.p2.checked;
   var p3 = document.myform.p3.checked;
   var p4 = document.myform.p4.checked;
   var p5 = document.myform.p5.checked;
  
   var p7 = document.myform.p7.checked;
   var p8 = document.myform.p8.checked;
   
   if(p1 == "" && p2 == "" && p3 == "" && p4 == "" &&
		   p5 == ""  && p7 == "" && p8 == "")
   {
	   alert("purpose�� �Ѱ� �̻� �������ּ���.");
	   return false;
   }
}


</script>



<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">����Ʈ�� ��õ - ���ϴ� �׸��� üũ���ּ���.</div>
      <div class="card-body">
        
        <form name = "myform" action = "Recomsmartphone" method = "post" onSubmit="return checkCompany(this)">
          <div class="timeline-heading"><h4>Company(1�� �̻� ����)</h4></div>
          <input type="checkbox" id = "c1" name = "company" value = "samsung">�Ｚ&nbsp; 
          <input type="checkbox" id = "c2" name = "company" value = "lg">����&nbsp;  
          <input type="checkbox" id = "c3" name = "company" value = "apple">����&nbsp;
          <input type="checkbox" id = "c4" name = "company" value = "xiaomi">������&nbsp;<br><br>
          
          <div class="timeline-heading"><h4>Price(�ڿ��� �Է�)</h4></div>
          <span class="fa-stack fa-2x">
          <input class="form-control" id = "minPr" type="text" name="minPrice" placeholder="30" required />
          </span><label for="username">����  &nbsp;&nbsp; ~&nbsp; &nbsp;</label>
          <span class="fa-stack fa-2x">
          <input class="form-control" id = "maxPr" type="text" name="maxPrice" placeholder="85" required />
           </span><label for="username">����</label>
          
          <br><br><div class="timeline-heading"><h4>Purpose(1�� �̻� ����)</h4></div>
          <input type="checkbox" id = "p1" name = "purpose" value = "game">���� ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
          <input type="checkbox" id = "p2" name = "purpose" value = "battery">��뷮 ���͸�&nbsp;
          <input type="checkbox" id = "p3" name = "purpose" value = "camera">���� ī�޶�&nbsp;
          <input type="checkbox" id = "p4" name = "purpose" value = "screen">ū ȭ��&nbsp;<br>
          <input type="checkbox" id = "p5" name = "purpose" value = "storage">��뷮 ���丮��&nbsp;
          <input type="checkbox" id = "p7" name = "purpose" value = "new">�ֽ� �޴���&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="checkbox" id = "p8" name = "purpose" value = "light">������ ����&nbsp;<br><br>
          
          
          <input type = "submit" value = "��õ ���ּ���!" class="btn btn-primary btn-block"></input>
        </form>
        
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="template1/vendor/jquery/jquery.min.js"></script>
  <script src="template1/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="template1/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>