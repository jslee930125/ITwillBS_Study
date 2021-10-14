<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/jsp1/testPro1.jsp</h1>
  <!-- 
    testForm1.jsp 페이지에서 전달된 정보 파라미터값을 저장
   -->
   <%
    // 스크립틀릿 : JSP/Java코드 작성
    //http://localhost:8088/StudyJSP/jsp1/testPro1.jsp?num=222
    //request.getParameter("파라미터명");
   
    //* 데이터를 전달할때(파라미터값 생성시) 모든데이터는 String 타입으로 처리
   
    String num = request.getParameter("num");
    out.print(request.getParameter("num"));
    
    // 문자열데이터(문자형 숫자)를 숫자로 변경
    int num2 = Integer.parseInt(request.getParameter("num")); 
   %>
   
  <%=request.getParameter("num") %>
  <hr>
  <%=num %><br>
  num + 100 = <%=num+100 %><br>
  num2 + 100 = <%=num2+100 %><br>
  
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>