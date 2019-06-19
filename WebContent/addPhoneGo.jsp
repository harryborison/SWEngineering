<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>
<%@ page import="javaCode.Model"%>
<%@ page import="javaCode.ModelControlDB"%>

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
	String phoneName = request.getParameter("phoneName");
	String company = request.getParameter("company");
	String phonePrice = request.getParameter("phonePrice");
	String screenSize = request.getParameter("screenSize");
	String os = request.getParameter("os");
	String capacity = request.getParameter("capacity");
	String RAM = request.getParameter("ram");
	String frontCamera = request.getParameter("frontCamera");
	String rearCamera = request.getParameter("rearCamera");
	String weight = request.getParameter("weight");
	String phoneSize = request.getParameter("phoneSize");
	String betteryCapacity = request.getParameter("betteryCapacity");
	String speed = request.getParameter("speed");
	String resolution = request.getParameter("resolution");
	String releaseYear = request.getParameter("releaseYear");
	String color = request.getParameter("color");
	String link = request.getParameter("link");
	String youtubeLink = request.getParameter("youtubeLink");
	
	int temp;
	double temp2;
	
	Model md = new Model();
	md.setPhoneName(phoneName);
	md.setCompany(company);
	temp = Integer.parseInt(phonePrice);
	md.setPhonePrice(temp);
	temp2 = Double.parseDouble(screenSize);
	md.setOs(os);
	temp = Integer.parseInt(capacity);
	md.setCapacity(temp);
	temp = Integer.parseInt(RAM);
	md.setRAM(temp);
	temp = Integer.parseInt(frontCamera);
	md.setFrontCamera(temp);
	temp = Integer.parseInt(rearCamera);
	md.setRearCamera(temp);
	temp = Integer.parseInt(weight);
	md.setWeight(temp);
	md.setPhoneSize(phoneSize);
	temp = Integer.parseInt(betteryCapacity);
	md.setBetteryCapacity(temp);
	temp2 = Double.parseDouble(speed);
	md.setSpeed(temp2);
	md.setResolution(resolution);
	temp = Integer.parseInt(releaseYear);
	md.setReleaseYear(temp);
	md.setColor(color);
	md.setLink(link);
	md.setVideolink(youtubeLink);
	md.setRecCount(0);
	
	ModelControlDB db = new ModelControlDB();
	db.insertModel(md);
	
	out.println("<script>");
	out.println("alert('성공적으로 추가되었습니다.')");
	out.println("location.href = 'managePhone.jsp'");
	out.println("</script>");
%>



</body>
</html>