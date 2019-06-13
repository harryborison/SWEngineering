<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>
<%@ page import="javaCode.CustomerControlDB" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>

<title>회원가입</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="hh/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="hh/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="hh/css/util.css">
<link rel="stylesheet" type="text/css" href="hh/css/main.css">
<!--===============================================================================================-->
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

<script type="text/javascript">

function checkForm()
{
	// check ID
	var ch;
	var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	
	if (document.myform.ID.value.indexOf(" ") >= 0) 
	{
        alert("아이디에 공백을 사용할 수 없습니다.");
        document.myform.ID.value = "";
        return false;
    }
	
	for (var i = 0; i < document.myform.ID.value.length; i++) 
	{
        ch = document.myform.ID.value.charAt(i);
        
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) 
        {
            alert("아이디는 영문 대소문자, 숫자만 입력가능합니다.");
            document.myform.ID.value = "";
            return false;
        }
    }
	
	if (document.myform.ID.value.length < 4 || document.myform.ID.value.length > 12) 
	{
        alert("아이디는 4~12 자까지 입력 가능합니다.");
        document.myform.ID.value = "";
        return false;
    }
	
	
	// check password
	if (document.myform.password.value.indexOf(" ") >= 0) 
	{
        alert("비밀번호에 공백을 사용할 수 없습니다.");
        document.myform.password.value = "";
        document.myform.passwordRepeat.value = "";
        return false;
    }
	
	for (i = 0; i < document.myform.password.value.length; i++) 
	{
        ch = document.myform.password.value.charAt(i);
        
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) 
        {
            alert("비밀번호는 영문 대소문자, 숫자만 입력가능합니다.");
            document.myform.password.value = "";
            document.myform.passwordRepeat.value = "";
            return false;
        }
    }
	
	if (document.myform.password.value.length < 4 || document.myform.password.value.length > 8) 
	{
        alert("비밀번호는 4~8자까지 입력 가능합니다.");
        document.myform.password.value = "";
        document.myform.passwordRepeat.value = "";
        return false;
    }
	
	if (document.myform.password.value != document.myform.passwordRepeat.value) {
        alert("비밀번호가 일치하지 않습니다")
        document.myform.password.value = "";
        document.myform.passwordRepeat.value = "";
        return false;
    }
	
	// check name
	if(!check.test(document.myform.name.value))
	{
		alert("이름은 한글로 입력해주십시오.");
		document.myform.name.value = "";
		return false;
	}
	
	if(document.myform.name.value.length > 4)
	{
		alert("이름이 너무 깁니다. 4자 이하로 입력해주세요.");
		document.myform.name.value = "";
		return false;
	}
	
	// check age
	if (isNaN(document.myform.age.value) == true) 
	{
        alert("나이는 숫자만 입력할 수 있습니다.");
        document.myform.age.value = "";
        return false;
    }
	else
	{
		var age = document.myform.age.value;
		age *= 1;
		if(age < 0 || age > 120)
		{
			alert("나이 입력이 올바르지 않습니다.");
			document.myform.age.value = "";
	        return false;
		}	
	}
	
	// check phone number
	if (isNaN(document.myform.phone_number1.value) == true ||
		isNaN(document.myform.phone_number2.value) == true ||
		isNaN(document.myform.phone_number3.value) == true) 
	{
        alert("휴대폰 번호 입력이 올바르지 않습니다.");
        document.myform.phone_number1.value = "";
        document.myform.phone_number2.value = "";
        document.myform.phone_number3.value = "";
        return false;
    }
	else
	{
		var p1 = document.myform.phone_number1.value;
		var p2 = document.myform.phone_number2.value;
		var p3 = document.myform.phone_number3.value;
		p2 *= 1; p3 *= 1;
		if(p1 != "010" || p2 < 1000 || p2 > 9999 || p3 < 1000 || p3 > 9999)
		{
			alert("휴대폰 번호 입력이 올바르지 않습니다.");
			document.myform.phone_number1.value = "";
	        document.myform.phone_number2.value = "";
	        document.myform.phone_number3.value = "";
	        return false;
		}
	}
	
	// check email
	for (i = 0; i < document.myform.email1.value.length; i++) {
        ch = document.myform.email1.value.charAt(i);
        
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
            alert("이메일 입력이 올바르지 않습니다.");
            document.myform.email1.value = "";
            document.myform.email2.value = "";
            return false;
        }
    }
	
	for (i = 0; i < document.myform.email2.value.length; i++) {
        ch = document.myform.email2.value.charAt(i);
        
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z') && !(ch ==".")) {
            alert("이메일 입력이 올바르지 않습니다.");
            document.myform.email1.value = "";
            document.myform.email2.value = "";
            return false;
        }
    }
	
	// check sex
	if(document.myform.man.checked == "" && document.myform.woman.checked == "")
	{
		alert("성별을 체크해주세요.");
		return false;
	}
}

</script>



</head>
<body>

	<div class="limiter">
		<div class="container-login100">



			<form name="myform" action="signupCheck.jsp" method="post"
				onSubmit="return checkForm()">
				<div class="form-group">
					<label for="username">ID(영문 대소문자 or 숫자)</label> <input
						class="form-control" type="text" name="ID" id="ID"
						placeholder="4 ~ 12 자리" required />
				</div>
				
				<div class="form-group">
					<label for="password">PASSWORD(영문 대소문자 or 숫자)</label> <input
						class="form-control" type="password" name="password" id="password"
						placeholder="4 ~ 8 자리" style="width: 150px" required />
				</div>
				<div class="form-group">
					<label for="passwordRepeat">REPEAT PASSWORD</label> <input
						class="form-control" type="password" name="passwordRepeat"
						id="passwordRepeat" placeholder="4 ~ 8 자리" style="width: 150px"
						required />
				</div>
				<div class="form-group">
					<label for="username">NAME(한글)</label> <input class="form-control"
						type="text" name="name" id="name" placeholder="홍길동"
						style="width: 100px" required />
				</div>
				<div class="form-group">
					<label for="username">AGE</label> <input class="form-control"
						type="text" name="age" id="age" placeholder="25"
						style="width: 50px" required />
				</div>
				<div class="form-group">
					<label for="username">PHONE NUMBER</label>
					<div class="form-group">
						<input class="form-control" type="text" name="phone_number1"
							id="phone_number1" placeholder="010"
							style="display: inline; width: 50px" required /> <label>
							- </label> <input class="form-control" type="text" name="phone_number2"
							id="phone_number2" placeholder="****"
							style="display: inline; width: 60px" required /> <label>
							- </label> <input class="form-control" type="text" name="phone_number3"
							id="phone_number3" placeholder="****"
							style="display: inline; width: 60px" required />
					</div>
				</div>
				<div class="form-group">
					<label for="password">EMAIL</label>
					<div class="form-group">
						<input class="form-control" type="text" name="email1" id="email1"
							placeholder="ID" style="display: inline; width: 120px" required />
						<label> @ </label> <input class="form-control" type="text"
							name="email2" id="email2" placeholder="knu.ac.kr"
							style="display: inline; width: 150px" required />
					</div>
				</div>
				<div class="form-group">
					<label for="username">SEX</label><br> <input type="radio"
						id="man" name="sex" value="man">남자&nbsp;&nbsp; <input
						type="radio" id="woman" name="sex" value="woman">여자
				</div>

				<div class="m-t-lg">
					<ul class="list-inline">
						<li><input class="btn btn--form" type="submit"
							value="Register" /></li>
						<li><a class="signup__link" href="login.jsp">I am already
								a member</a></li>
					</ul>
				</div>
			</form>





		</div>
	</div>



	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

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