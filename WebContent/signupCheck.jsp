<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.sql.*" %>  
<%@ page import="javacode.DBTest"%>
<%@ page import="javacode.DBCon"%>
<%@ page import="javacode.CustomerControlDB" %>

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
		String[] cusInfo = new String[7];

		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone_number1 = request.getParameter("phone_number1");
		String phone_number2 = request.getParameter("phone_number2");
		String phone_number3 = request.getParameter("phone_number3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String sex = request.getParameter("sex");

		cusInfo[0] = id;
		cusInfo[1] = password;
		cusInfo[2] = name;
		cusInfo[3] = age;
		cusInfo[4] = phone_number1 + phone_number2 + phone_number3;
		cusInfo[5] = email1 + "@" + email2;
		cusInfo[6] = sex;
		
		for(int i=0; i<cusInfo.length; i++)
			System.out.println(cusInfo[i]);

		CustomerControlDB test = new CustomerControlDB();
		int check = test.signinCheck(id);
		if(check == 1) // 중복
		{
			out.println("<script>");
			out.println("alert('ID가 이미 사용중입니다. 다른 ID를 입력해주세요.')");
			out.println("location.href = 'signup.jsp'");
			out.println("</script>");
		}
		else // 중복아님
		{
			DBTest db = new DBTest();
			db.connectDB();
			db.setCustomerDB(cusInfo);
			session.setAttribute("id", id);
			out.println("<script>");
			out.println("alert('회원가입이 완료되었습니다.')");
			out.println("location.href = 'home.jsp'");
			out.println("</script>");
		}
	
	%>







</body>
</html>