<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javacode.DBTest"%>
<%@ page import="javacode.DBCon"%>
<%@ page import="javacode.Plan"%>
<%@ page import="javacode.PlanControlDB"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	String operator = request.getParameter("operator");	
	String planName = request.getParameter("planName");	
	String mobile = request.getParameter("mobile");	
	String planPrice = request.getParameter("planPrice");	
	String data = request.getParameter("data");	
	String videoCall = request.getParameter("videoCall");	
	String call = request.getParameter("call");	
	String message = request.getParameter("message");	
	String option = request.getParameter("option");
	String data2 = request.getParameter("data2");
	String youtubeLink = request.getParameter("youtubeLink");
	
	PlanControlDB db = new PlanControlDB();
	
	int temp1 = Integer.parseInt(planPrice);
	int temp2 = Integer.parseInt(data2);
	
	Plan p = new Plan();
	p.setOperator(operator);
	p.setPlanName(planName);
	p.setMobile(mobile);
	p.setPlanPrice(temp1);
	p.setAmtOfData(data);
	p.setVideoCall(videoCall);
	p.setCall(call);
	p.setMessage(message);
	p.setOption(option);
	p.setData2(temp2);
	p.setLink(youtubeLink);
	
	db.insertPlan(p);
	
	out.println("<script>");
	out.println("alert('성공적으로 추가되었습니다.')");
	out.println("location.href = 'managePlan.jsp'");
	out.println("</script>");
%>




</body>
</html>