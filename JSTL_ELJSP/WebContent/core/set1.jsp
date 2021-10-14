<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core 라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/core/set1.jsp</h1>
   <%
     // jsp 페이지에서 java 코드를 사용
     // => 단점-set1.jsp 페이지에서만 사용가능(지역변수)
     int num1 = 10;
     int num2 = 20;
     int sum = num1 + num2;
   %>
     변수의 합 : <%=sum %><br>
   
   <h2> JSTL 사용 - 변수 선언 </h2>
   <%-- <c:set var="변수명" value="변수값"/> --%>
   <c:set var="num1" value="100"/>
   <c:set var="num2" value="200"/>
   <%-- <c:set var="sum" value="num1+num2"/> --%>
   <c:set var="sum" value="${num1+num2}"/>
   
   <c:out value="sum"/><br>
   jstl변수는 el표현식으로 호출<br>
   <c:out value="${sum }"/>
   <hr>
   
     데이터를 화면에 바로 출력(html)<br>
   <%=num1 %> + <%=num2 %> = <%=sum %><br>
   ${num1 } + ${num2 } = ${sum } <br>
   
   <hr>
   <!-- 
     JSTL을 사용한 변수의 선언은  JSP 영역객체를 활용 가능
     page < request < session < application   
    -->
   * scope 설정이 없는 경우 기본값으로 page영역<br>
   <c:set value="1000" var="data" />
   <%-- <c:set value="1000" var="data" scope="page" /> --%>
   
   <h3> set2.jsp 페이지로 정보를 전달 </h3>
   <%
      //request.setAttribute("name", "휴대폰");
   %>   
   <c:set var="name" value="휴대폰" scope="request"/>
   <c:set var="price" value="100" scope="request"/>
   <c:set var="model" value="아이폰" scope="request"/>
   
   <!-- 페이지 이동 set2.jsp페이지 -->
   <!-- 포워딩(forward)방식으로 이동 (request영역값을 사용) -->
   <!-- 페이지 주소는 변경 X, 화면만 변경 O -->
   
   <jsp:forward page="set2.jsp"/>
   
   
   
   
   
   
   
   
   
   
   

</body>
</html>