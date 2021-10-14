<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/jsp4/cookieDel.jsp</h1>
   <h2> 서버 </h2>
   <%
   // 기존의 쿠키값 삭제
   
   // 1) 기존의 쿠키값 가져오기 (배열의 형태로 저장)
   Cookie[] cookies = request.getCookies();
   
   // 2) 쿠키 배열을 처음부터 끝까지 검색 - 필요정보 확인
   if(cookies != null){
	   for(int i=0;i<cookies.length;i++){
		   if(cookies[i].getName().equals("name")){
			 // 3) 쿠키값을 삭제 
             // 쿠키값 데이터 자체의 사용시간->0 (파일삭제 X)
             cookies[i].setMaxAge(0);	
             
             // 4) 쿠키삭제정보를 클라이언트로 전달
             response.addCookie(cookies[i]);
		   }		   
	   }
   }
   %>
   <script type="text/javascript">
     alert("서버 : 쿠키값 삭제!");
     location.href="cookieTest.jsp";   
   </script>
   
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>