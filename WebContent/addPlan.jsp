<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javacode.DBTest"%>
<%@ page import="javacode.DBCon"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="en">
<head>

<link href="0618css/123.min.css" rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Website CSS style -->
<link href="addadd/css/bootstrap.min.css" rel="stylesheet">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css">
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<title>요금제 등록</title>

<script type="text/javascript">

function checkForm()
{
	if(document.myform.planName.value == "")
	{
		alert("요금제 이름 항목이 입력되지 않았습니다.");
		return false;
	}
	
	if(document.myform.c1.checked == false &&
			document.myform.c2.checked == false &&
			document.myform.c2.checked == false)
	{
		alert("통신사 항목이 입력되지 않았습니다.");
		return false;
	}
	if(document.myform.b1.checked == false &&
			document.myform.b2.checked == false)
	{
		alert("기기 항목이 입력되지 않았습니다.");
		return false;
	}
	
	if(document.myform.planPrice.value == "")
	{
		alert("가격 항목이 입력되지 않았습니다.");
		return false;
	}
	if(document.myform.videoCall.value == "")
	{
		alert("영상통화 항목이 입력되지 않았습니다.");
		return false;
	}
	if(document.myform.call.value == "")
	{
		alert("전화 항목이 입력되지 않았습니다.");
		return false;
	}
	if(document.myform.message.value == "")
	{
		alert("문자 항목이 입력되지 않았습니다.");
		return false;
	}
	if(document.myform.option.value == "")
	{
		alert("특이사항 항목이 입력되지 않았습니다.");
		return false;
	}
	
	if(document.myform.data2.value == "")
	{
		alert("data2 항목이 입력되지 않았습니다.");
		return false;
	}
	
}

</script>

</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h5>요금제 등록</h5>
				<form id = "myform" class="" method="post" action="addPlanGo.jsp" onSubmit="return checkForm()">

					<div class="form-group"
						style="display: inline; float: left; width: 230px">
						<label for="name" class="cols-sm-2 control-label">요금제 이름</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="planName"
									id="planName" placeholder="" />
							</div>
						</div>
					</div>
					<div class="form-group"
						style="display: inline; float: left; width: 150px">
						<label for="username" class="cols-sm-2 control-label">가격</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="planPrice"
									id="planPrice" placeholder="" style="width:100px"/>
									
							</div>
							<label style = "display:inline;">&nbsp;원</label>
						</div>
					</div>
					<div class="form-group"
						style="display: inline; float: left; width: 180px">
						<label for="email" class="cols-sm-2 control-label">통신사</label>
						<div class="cols-sm-10">
							<input type="radio" id = "c1" name = "operator" value = "kt">KT&nbsp; 
          					<input type="radio" id = "c2" name = "operator" value = "skt">SKT&nbsp;  
          					<input type="radio" id = "c3" name = "operator" value = "lg">LG U+&nbsp;
         					
						</div>
					</div>
					
					<div class="form-group"style="display: inline; float: left; width: 120px">
						<label for="email" class="cols-sm-2 control-label">기기</label>
						<div class="cols-sm-10">
							<input type="radio" id = "b1" name = "mobile" value = "lte">LTE&nbsp; 
          					<input type="radio" id = "b2" name = "mobile" value = "5g">5G&nbsp;  
						</div>
					</div>
					
					<br><br><br><br>
					<div style = "width:800px">
					<div class="form-group" style="display:inline;float:left;width:150px">
						<label for="confirm" class="cols-sm-2 control-label">전화</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="call"
									id="call" placeholder=""style="width: 100px" />
							</div>
							
						</div>
					</div>
					
					<div class="form-group" style="display:inline;float:left;width: 150px">
						<label for="password" class="cols-sm-2 control-label">데이터</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="data"
									id="data" placeholder="" style="width: 120px"/>
							</div>
							
						</div>
					</div>
					
					<div class="form-group" style=" float: left; width: 120px">
						<label for="confirm" class="cols-sm-2 control-label">메세지</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="message" id="message"
									placeholder="" style="width: 70px"/>
							</div>
						
						</div>
					</div>

				
					
					<div class="form-group"
						style="display: inline; float: left; width: 130px">
						<label for="confirm" class="cols-sm-2 control-label">영상통화</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="videoCall" id="videoCall"
									placeholder="" style="width: 100px"/>
							</div>
						</div>
					</div>
					
					<div class="form-group"
						style="display: inline; float: left; width: 130px">
						<label for="confirm" class="cols-sm-2 control-label">data2</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="data2" id="data2"
									placeholder="" style="width: 100px"/>
							</div>
						</div>
					</div>
					
					</div>

					<div class="form-group" style="width:720px">
						<label for="confirm" class="cols-sm-2 control-label" style="width:800px">특이사항</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="option" id="option"
									placeholder="" style="width: 720px"/>
							</div>
							
						</div>
					</div>
					<br>
					<br>
					<div class="form-group" style="width:720px">
						<label for="confirm" class="cols-sm-2 control-label" style="width:800px">유튜브 링크</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="youtubeLink" id="youtubeLink"
									placeholder="" style="width: 720px"/>
							</div>
							
						</div>
					
					<br>
					
					
					<br>
					
					<div class="form-group ">
						<input href="https://deepak646.blogspot.com/" target="_blank"
							type="submit" id="button" value = "등록"
							class="btn btn-primary btn-lg btn-block login-button">
					</div>

				</form>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="addadd/js/bootstrap.min.js"></script>
</body>
</html>