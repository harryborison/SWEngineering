<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>
<%@ page import="javaCode.ModelControlDB" %>

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
	
	
	ModelControlDB db = new ModelControlDB();

	request.setCharacterEncoding("UTF-8");
	String phoneName = request.getParameter("phoneName");	
	
	out.println("<script>");
	out.println("alert('성공적으로 삭제되었습니다.')");
	out.println("location.href = 'managePhone.jsp'");
	out.println("</script>");
	
	db.deletebyPhoneName(phoneName);
	
	
%>



</body>
</html>