<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/el/AttributeTest.jsp</h1>
  <%
     //int cnt = (int)request.getAttribute("cnt");
     //Integer cnt = (Integer)request.getAttribute("cnt");
     int cnt = (Integer)request.getAttribute("cnt");
     
     // 세션 객체에 있는 전달 정보를 저장
     int cnt2 = (Integer)session.getAttribute("cnt");
     
  %>
  
  
  <%
     cnt = 1000;
  %>
  
  <h2> 전달된 데이터 출력 </h2>
  <h3>
     jsp 표현식 : 속성을 사용가능, 하지만 지역변수의 개념으로 사용
                             값의 변화가 쉬움. <br>
                             연산가능 / 반드시 형변환이 필요하다.         
  </h3>
  JSP : <%=cnt %><br>
  JSP +100 : <%=cnt+100 %><br>
  
    <h3> JSP표현식으로 사용한 cnt값은 '변수' </h3>
  <hr>
  <h3>
      EL 표현식 : 속성을 사용가능, 속성값을 그대로 사용가능<br>
                              연산가능 / 자동으로 형변환(다운캐스팅) 된다.
  </h3>
  EL : ${requestScope.cnt }<br>
  EL(영역객체 생략) : ${cnt }<br>
  EL(영역객체 생략) +100 : ${cnt+100 }<br>
    <h3> EL 표현식으로 사용한 cnt값은  '속성' </h3>  
  
  <hr>
  <h2> 세션 영역 데이터 </h2>
   JSP : <%=cnt2 %><br>
   JSP : <%=session.getAttribute("cnt") %><br>
   <%-- JSP : <%=session.getAttribute("cnt")+100 %><br> --%><!-- (x) -->
   <hr>
   EL : ${sessionScope.cnt }<br>
   
   <hr><hr>
   
   EL (request) : ${requestScope.cnt } <br>
   EL (session) : ${sessionScope.cnt }<br>
   
   EL (영역 생략) : ${cnt }<br>
   
   <h3>
      영역객체의 이름이 생략된 경우 <br>
      page -> request -> session -> application 영역을
      순차적으로 돌면서 'cnt' 속성을 찾는다.
     그리고 속성을 찾은경우 다음영역의 데이터는 검색 X     
   </h3>
   
  
  
  
  
  
  
  
  

</body>
</html>