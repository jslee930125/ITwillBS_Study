<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/jsp3/sessionSet.jsp</h1>
   <%
     // 세션객체 생성(이미 생성완료-내장객체)
     
     // 세션 정보(값)생성
     //session.setAttribute("이름", "값");
     session.setAttribute("name", "ITWILL");
     session.setAttribute("tel", "010-1234-7894");
     
     System.out.println("session값 생성~!");

     // 페이지 이동(sessionTest.jsp) - js
   %>
   <script type="text/javascript">
      alert("세션값 생성완료 후 페이지 이동!");
      location.href='sessionTest.jsp';
   </script>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>