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

<title>스마트폰 등록</title>


<script type="text/javascript">

function checkForm()
{
	if (document.myform.phoneName.value == "") 
	{
        alert("phoneName 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.c1.checked == false &&
			document.myform.c2.checked == false &&
			document.myform.c3.checked == false &&
			document.myform.c4.checked == false) 
	{
        alert("company 항목이 선택되지 않았습니다.");
        return false;
    }
	if (document.myform.phonePrice.value == "") 
	{
        alert("phonePrice 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.screenSize.value == "") 
	{
        alert("screenSize 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.os.value == "") 
	{
        alert("os 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.capacity.value == "") 
	{
        alert("capacity 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.ram.value == "") 
	{
        alert("RAM 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.frontCamera.value == "") 
	{
        alert("frontCamera 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.rearCamera.value == "") 
	{
        alert("rearCamera 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.weight.value == "") 
	{
        alert("weight 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.phoneSize.value == "") 
	{
        alert("phoneSize 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.betteryCapacity.value == "") 
	{
        alert("betteryCapacity 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.speed.value == "") 
	{
        alert("speed 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.resolution.value == "") 
	{
        alert("resolution 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.phonePrice.value == "") 
	{
        alert("phonePrice 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.releaseYear.value == "") 
	{
        alert("releaseYear 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.color.value == "") 
	{
        alert("color 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.link.value == "") 
	{
        alert("link 항목이 입력되지 않았습니다.");
        return false;
    }
	if (document.myform.youtubeLink.value == "") 
	{
        alert("youtubeLink 항목이 입력되지 않았습니다.");
        return false;
    }
}

</script>


</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h5>스마트폰 등록</h5>
				<form name="myform" class="" method="post" action="addPhoneGo.jsp" onSubmit="return checkForm()">

					<div class="form-group"
						style="display: inline; float: left; width: 230px">
						<label for="name" class="cols-sm-2 control-label">phoneName</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="phoneName"
									id="phoneName" placeholder="" />
							</div>
						</div>
					</div>

					<div class="form-group"
						style="display: inline; float: left; width: 230px">
						<label for="email" class="cols-sm-2 control-label">company</label>
						<div class="cols-sm-10">
							<input type="radio" id = "c1" name = "company" value = "samsung">삼성&nbsp; 
          					<input type="radio" id = "c2" name = "company" value = "lg">엘지&nbsp;  
          					<input type="radio" id = "c3" name = "company" value = "apple">애플&nbsp;
         					 <input type="radio" id = "c4" name = "company" value = "xiaomi">샤오미&nbsp;
						</div>
					</div>

					<div class="form-group"
						style="display: inline; float: left; width: 230px">
						<label for="username" class="cols-sm-2 control-label">phonePrice</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="phonePrice"
									id="phonePrice" placeholder="" style="width:100px"/>
									
							</div>
							<label style = "display:inline;">&nbsp;원</label>
						</div>
					</div>

					<div class="form-group" style="float: left; width: 150px">
						<label for="password" class="cols-sm-2 control-label">screenSize</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="screenSize"
									id="screenSize" placeholder="" style="width: 50px"/>
							</div>
							<label style = "display:inline;">&nbsp;inch</label>
						</div>
					</div>

					<div class="form-group"
						style="display: inline; float: left; width: 130px">
						<label for="confirm" class="cols-sm-2 control-label">OS</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="os" id="os"
									placeholder="" style="width: 100px"/>
							</div>
						</div>
					</div>

					<div class="form-group"
						style="display: inline; float: left; width: 150px">
						<label for="confirm" class="cols-sm-2 control-label">capacity</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="capacity"
									id="capacity" placeholder=""style="width: 60px" />
							</div>
							<label style = "display:inline;">&nbsp;GB</label>
						</div>
					</div>

					<div class="form-group" style="display: inline; float: left; width: 120px">
						<label for="confirm" class="cols-sm-2 control-label">RAM</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="ram" id="ram"
									placeholder="" style="width: 40px"/>
							</div>
							<label style = "display:inline;">&nbsp;GB</label>
						</div>
					</div>

					<div class="form-group" style="display: inline; float: left; width: 150px">
						<label for="confirm" class="cols-sm-2 control-label">frontCamera</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="frontCamera" id="frontCamera"
									placeholder="" style="width: 70px"/>
							</div>
							<label style = "display:inline;">&nbsp;만 화소</label>
						</div>
					</div>
					
								<div class="form-group" style="display: inline; float: left; width: 150px">
						<label for="confirm" class="cols-sm-2 control-label">rearCamera</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="rearCamera" id="rearCamera"
									placeholder="" style="width: 70px"/>
							</div>
							<label style = "display:inline;">&nbsp;만 화소</label>
						</div>
					</div>

					<div class="form-group" style="display: inline; float: left; width: 100px">
						<label for="confirm" class="cols-sm-2 control-label">weight</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="weight" id="weight"
									placeholder="" style="width: 60px"/>
							</div>
							<label style = "display:inline;">&nbsp;g</label>
						</div>
					</div>
					<div class="form-group"style="display: inline; float: left; width: 230px">
						<label for="confirm" class="cols-sm-2 control-label">phoneSize</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="phoneSize" id="phoneSize"
									placeholder="" />
							</div>
						</div>
					</div>
					<div class="form-group" style="display: inline;float:left; width: 150px">
						<label for="confirm" class="cols-sm-2 control-label">betteryCapacity</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="betteryCapacity" id="betteryCapacity"
									placeholder="" style="width: 70px"/>
							</div>
							<label style = "display:inline;">&nbsp;mAh</label>
						</div>
					</div>
					
					<div class="form-group" style="display: inline;float:left; width: 150px">
						<label for="confirm" class="cols-sm-2 control-label">speed</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="speed" id="speed"
									placeholder="" style="width: 70px"/>
							</div>
							<label style = "display:inline;">&nbsp;Ghz</label>
						</div>
					</div>
					
					<div class="form-group" style="display: inline;float:left; width: 150px">
						<label for="confirm" class="cols-sm-2 control-label">resolution</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="resolution" id="resolution"
									placeholder="" style="width: 100px"/>
							</div>
						</div>
					</div>
					
					<div class="form-group" style="display: inline;float:left; width: 150px">
						<label for="confirm" class="cols-sm-2 control-label">releaseYear</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="releaseYear" id="releaseYear"
									placeholder="" style="width: 60px"/>
							</div>
							<label style = "display:inline;">&nbsp;년</label>
						</div>
					</div>
					
					<div class="form-group" style="display: inline;float:left; width: 230px">
						<label for="confirm" class="cols-sm-2 control-label">color</label>
						<div class="cols-sm-10">
							<div class="input-group">

								<input type="text" class="form-control" name="color" id="color"
									placeholder="" style="width: 170px"/>
							</div>
		
						</div>
					</div>
					
					<div class="form-group" style="display: inline;float:left; width: 350px">
						<label for="confirm" class="cols-sm-2 control-label">link</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="link" id="link"
									placeholder="" style="width: 300px"/>
							</div>
		
						</div>
					</div>
					
					<div class="form-group" style="display: inline;float:left; width: 350px">
						<label for="confirm" class="cols-sm-2 control-label">youtubeLink</label>
						<div class="cols-sm-10">
							<div class="input-group" style = "display:inline;">

								<input type="text" class="form-control" name="youtubeLink" id="youtubeLink"
									placeholder="" style="width: 300px"/>
							</div>
		
						</div>
					</div>
					
					<div class="form-group" style="width: 100px">
						<label for="confirm" class="cols-sm-2 control-label"></label>
						
					</div>
					
					
					
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