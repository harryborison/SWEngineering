<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javaCode.DBTest"%>
<%@ page import="javaCode.DBCon"%>
<%@ page import="javaCode.CustomerControlDB" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");

	System.out.println(id);
	System.out.println(password);

	CustomerControlDB test = new CustomerControlDB();
	int check = test.loginCheck(id, password);
	System.out.println(check);
	// 1 이면 로그인 성공
	if(check == 1)
	{
		session.setAttribute("id", id);
		out.println("<script>");
		//out.println("alert('성공적으로 로그인 되었습니다.')");
		out.println("location.href = 'home.jsp'");
		out.println("</script>");
	}
	else
	{
		out.println("<script>");
		out.println("alert('아이디 또는 비밀번호가 올바르지 않습니다.')");
		out.println("location.href = 'login.jsp'");
		out.println("</script>");
	}




%>

</body>
</html>