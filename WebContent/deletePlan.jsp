<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javacode.DBTest"%>
<%@ page import="javacode.DBCon"%>
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
	String planName = request.getParameter("planName");	
	System.out.println("AAAAAA" + planName + "AAAAAAA");
	PlanControlDB db = new PlanControlDB();
	db.deletebyPlanName(planName);
	
	
	
	
	
	
	
	out.println("<script>");
	out.println("alert('성공적으로 삭제되었습니다.')");
	out.println("location.href = 'managePlan.jsp'");
	out.println("</script>");
%>



</body>
</html>