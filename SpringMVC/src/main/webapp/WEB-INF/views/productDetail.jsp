<%@page import="com.itwillbs.domain.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WEB-INF/views/productDetail.jsp</h1>

	${itwill}
	<hr>
	
	<h1>key 값이 있는 경우</h1>
	${vo}<br>
	${vo.name}<br>
	${vo.price}<br>
	<hr>
	<%=request.getAttribute("vo") %>
	<%
	 ProductVO pvo = (ProductVO)request.getAttribute("vo");
	%>
	<br>
	<%-- 	
		<%=pvo.getName() %><br>
		<%=pvo.getPrice() %><br>
	--%> 
	<hr>
	
	<h1>key 값이 없는 경우</h1>
	<h2>전달되는 데이터타입의 첫글자만 소문자로 변경해서 키값으로 사용(규칙)</h2>
	${productVO}<br>
	${productVO.name} <br>
	${productVO.price} <br>
	 
</body>
</html>