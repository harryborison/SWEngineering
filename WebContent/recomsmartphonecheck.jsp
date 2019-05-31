<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%!
	String company[];
	String minPrice, maxPrice;
	String[] purpose;
	
	int minP, maxP;
	
	boolean companyError = false;
	boolean priceError = false;
	boolean purposeError = false;
	
	public boolean isNumeric(String s) {
		  try {
		      Double.parseDouble(s);
		      return true;
		  } catch(NumberFormatException e) {
		      return false;
		  }
	}
	
	public static boolean isInteger(String num)
    {
     try
     {
      Integer.parseInt(num);    // int 형으로 변환해보고
      return true;                      // 이상없으면 true를 리턴
     }
     catch (NumberFormatException e)
     {
      return false;                    // 이상 있으면 false를 리턴
     }
    }
%>

<%
	
	request.setCharacterEncoding("EUC-KR");
	
	// company 입력 에러 검사
	if(request.getParameterValues("company") != null)
		company = request.getParameterValues("company");
	else
		companyError = true;
	
	minPrice = request.getParameter("minPrice");
	maxPrice = request.getParameter("maxPrice");
	
	// price 입력 에러 검사
	if(isNumeric(minPrice) == false || isNumeric(maxPrice) == false)
		priceError = true;
	else
	{
		if(isInteger(minPrice) == false || isInteger(maxPrice) == false)
		{
			priceError = true;
		}
		else
		{
			minP = Integer.parseInt(minPrice);
			maxP = Integer.parseInt(maxPrice);
			if(minP > maxP)
				priceError = true;
		}
	}
	
	
	// purpose 입력 에러 검사
	if(request.getParameterValues("purpose") != null)
		purpose = request.getParameterValues("purpose");
	else	
		purposeError = true;
	
	if(companyError == true)
	{
		System.out.println("company error");
		response.sendRedirect("recomsmartphone.jsp");
	}
	else if(priceError == true)
	{
		//out.println("<script>alert('price 입력 오류');history.back();</script>");
		System.out.println("price error");
		response.sendRedirect("recomsmartphone.jsp");
	}
	else if(purposeError == true)
	{
		//out.println("<script>alert('purpose 미선택');history.back();</script>");
		System.out.println("purpose error");
		response.sendRedirect("recomsmartphone.jsp");
	}
	else
	{
		System.out.println("No error");
	}
%>


</body>
</html>