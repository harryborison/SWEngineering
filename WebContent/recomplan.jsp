<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>요금제 추천받기</title>

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
  
  




<script language="javascript">


function Data_OnOff(id)
{
   if(id == "inf")
   {
      document.all["da"].style.display = 'none';
      document.all["gb"].style.display = 'none';
      document.all["da"].value = "0";
   }
   else
   {      
      document.all["da"].style.display = '';
      document.all["gb"].style.display = '';
   }
}


function checkForm(myform2)
{
	var chk1 = document.myform2.c1.checked;
	var chk2 = document.myform2.c2.checked;
	var chk3 = document.myform2.c3.checked;
	
	   
    if(chk1 == "" && chk2 == "" && chk3 == "")
	{
		alert("Company를 한개 이상 선택해주세요.");
		return false;
	}
    
    var tq1 = document.myform2.t1.checked;
    var tq2 = document.myform2.t2.checked;
    
    if(tq1 == "" && tq2 == "")
	{
		alert("Type을 한개 이상 선택해주세요.");
		return false;
	}
    
    var minP = document.myform2.minPr.value;
    var maxP = document.myform2.maxPr.value;
    
    if(isNaN(minP) == true || isNaN(maxP) == true)
    {
 	   alert("price입력이 잘못되었습니다.");
 	   return false;
    }
    
    var minIntPrice = parseInt(minP);
    var maxIntPrice = parseInt(maxP);
    
    if(minIntPrice > maxIntPrice)
    {
 	   alert("Price입력이 잘못되었습니다.");
 	   return false;
    }
    
    var temp = document.all("data");
    if(temp[0].checked == false && temp[1].checked == false)
    {
    	alert("Data를 선택해주세요.");
    	return false;
    }
    
    var amount = document.myform2.da.value;
    
    if(temp[1].checked == true && isNaN(amount) == true)
    {
    	alert("Data양 입력이 잘못되었습니다.");
    	return false;
    }
    
    var oq1 = document.myform2.o1.checked;
    var oq2 = document.myform2.o2.checked;
    var oq3 = document.myform2.o3.checked;
    var oq4 = document.myform2.o4.checked;
    var oq5 = document.myform2.o5.checked;
    var oq6 = document.myform2.o6.checked;
    var oq7 = document.myform2.o7.checked;
    var oq8 = document.myform2.o8.checked;
    var oq9 = document.myform2.o9.checked;
    
    if(oq1 == "" && oq2 == "" && oq3 == "" && oq4 == "" && oq5 == "" &&
    		oq6 == "" && oq7 == "" && oq8 == "" && oq9 == "")
    {
    	alert("Option을 한개 이상 선택해주세요.");
		return false;
    }
}

</script>
  
</head>



<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">요금제 추천 - 원하는 항목을 체크해주세요.</div>
      <div class="card-body">
        
        <form name = "myform2" id = "form2" action = "RecomPlanServlet" method = "post"  onSubmit="return checkForm(this)">
          <div class="timeline-heading"><h4>Company(1개 이상 선택)</h4></div>
          <input type="checkbox" id = "c1" name = "company" value = "KT">KT&nbsp; 
          <input type="checkbox" id = "c2" name = "company" value = "LG U+">LG U+&nbsp;  
          <input type="checkbox" id = "c3" name = "company" value = "SKT">SKT&nbsp;<br><br>
          
          <div class="timeline-heading"><h4>Type(1개 이상 선택)</h4></div>
          <input type="checkbox" id = "t1" name = "type" value = "LTE">LTE&nbsp; 
		  <input type="checkbox" id = "t2" name = "type" value = "5G">5G&nbsp;<br><br>
          
          <div class="timeline-heading"><h4>Price(자연수 입력)</h4></div>
          <span class="fa-stack fa-2x">
          <input class="form-control" type="text" id = "minPr" name="minprice" placeholder="" required />
          </span><label for="username">원  &nbsp;&nbsp; ~&nbsp; &nbsp;</label>
          <span class="fa-stack fa-2x">
          <input class="form-control" type="text" id = "maxPr" name="maxprice" placeholder="" required />
           </span><label for="username">원</label>
          
          <div class="timeline-heading"><h4>Data</h4></div>
          <input type="radio" id = "d1" name = "data" value = "inf" onClick = "Data_OnOff('inf');">무제한&nbsp; 
		  <input type="radio" id = "d2" name = "data" value = "self" onClick = "Data_OnOff('self');">직접입력&nbsp;
		  <span class="fa-stack fa-2x"><input  style="display:none;" class="form-control" type="text" id = "da" name="dataAmount" value ="0" required /></span>
          <label id = "gb" style="display:none;" for="username">GB(소수점 입력 가능)</label><br><br>
          
          
          <div class="timeline-heading"><h4>Option(1개 이상 선택)</h4></div>
          <input type="checkbox" id = "o1" name = "option" value = "soldier">군인&nbsp; 
          <input type="checkbox" id = "o2" name = "option" value = "nextmonth">이월요금제&nbsp;  
          <input type="checkbox" id = "o3" name = "option" value = "vip">vip 멤버쉽&nbsp;
          <input type="checkbox" id = "o4" name = "option" value = "feature">피쳐폰 전용&nbsp;
          <input type="checkbox" id = "o5" name = "option" value = "notsee">시각장애인 전용&nbsp;<br>
          <input type="checkbox" id = "o6" name = "option" value = "notlisten">청각장애인 전용&nbsp;
          <input type="checkbox" id = "o7" name = "option" value = "disabled">장애인 혜택 요금제&nbsp;
          <input type="checkbox" id = "o8" name = "option" value = "old">65세 이상&nbsp;
          <input type="checkbox" id = "o9" name = "option" value = "young">청소년 요금제&nbsp;<br><br>
          
          
          <input type = "submit" value = "추천 해주세요!"  class="btn btn-primary btn-block"></input>
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