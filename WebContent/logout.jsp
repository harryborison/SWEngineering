<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.removeAttribute("id");
	out.println("<script>");
	out.println("alert('로그아웃 되었습니다.')");
	out.println("location.href = 'home.jsp'");
	out.println("</script>");


%>
</body>
</html>