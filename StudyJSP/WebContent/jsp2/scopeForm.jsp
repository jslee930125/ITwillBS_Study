<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/jsp2/scopeForm.jsp</h1>
	<!-- p209~ -->
	<%
		// 영역(scope) : 내장객체 중에서 일부만 데이터를 공유가능한 범위 
		// 속성(attribute) : 영역객체가 공유하는 데이터 
		
		// 영역				영역객체			속성의 유효범위
		// page				pageContext		해당 페이지
		// request			request			페이지 요청이 처리되는 페이지
		// session			session			세션이 유지되는 동안 모든 페이지
		// application		application		서버가 실행되는 동안 모든 페이지
		
		// * 속성 정보를 저장 /사용 메서드 
		// [영역객체].setAttribute("이름",값);
		// [영역객체].getAttribute("이름");
	%>


   <fieldset>
     <form action="scopePro.jsp" method="get">
          아이디 : <input type="text" name="id">
       <input type="submit" value="입력하기">
     </form>   
   </fieldset>






</body>
</html>