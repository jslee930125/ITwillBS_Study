<%@page import="com.itwillbs.bean.MemberBean"%>
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
  <h1>WebContent/core/set2.jsp</h1>
  
  <h2> set1.jsp 페이지에서 전달된 정보 출력 </h2>
  <%
    String name = (String)request.getAttribute("name");
    String price = (String)request.getAttribute("price");
    String model = (String)request.getAttribute("model"); 
  %>
  name : <%=name %><br>
  price : <%=price %><br>
  model : <%=model %><br>
  <hr>
  
  <h2>el 표현식 사용</h2>
  name : ${requestScope.name }<br>
  <!-- requestScope 생략 가능 -->
  name : ${name }<br>
  price : ${price }<br>
  model : ${model }<br>
  
  <hr>
  <c:out value="<c:remove/>사용하여 출력 "/>
   name 정보를 삭제 후 다시 출력<br>
   <%
     //request.removeAttribute(arg0);
       
   %>
  <%-- <c:remove var="name"/> <!-- 권장(x)  --> --%>
  <c:remove var="name" scope="request"/> <!-- 권장(O)  -->
   
  name : ${name }<br>
  price : ${price }<br>
  model : ${model }<br>
  
  <hr><hr>
  
  <h2> 서블릿을 사용하여 정보 전달 </h2>
  
  <h4>아이디 : ${requestScope.mb.id } </h4>
  <h4>비밀번호 :
   <%
     MemberBean mb = (MemberBean)request.getAttribute("mb");
    %>
    <%=mb.getPw() %>
  </h4>
  <h4>이름 : ${mb.name }</h4>
  <c:set var="m" value="${requestScope.mb}"/>
  <h4>나이 : ${m.age }</h4>
  
  <hr>
  <!-- "itwill/1q2w3e/김학생/20" 학생의 정보를 생성후 (ServletTest)
       set2.jsp 페이지에서 정보 출력
   -->
   <hr>
   이름 : ${requestScope.MemberBean.name}<br>
   나이 : ${MemberBean.age }<br>
  <c:set var="mb1" value="${requestScope.MemberBean }"/> 
   아이디 : ${mb1.id }<br>
   비밀번호 : ${mb1.pw }<br>  
   
   <hr>
   
   <h3> 서블릿에서 전달되는 리스트 정보를 출력 </h3>
   <!-- 리스트 첫번째 요소만 출력 -->
   
   아이디 : ${requestScope.memberList[0].id }  
   비밀번호 : ${memberList[0].pw } 
   이름: ${memberList[0].name }
   나이: ${memberList[0].age }<br>
   
   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

</body>
</html>