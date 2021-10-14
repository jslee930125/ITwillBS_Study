<%@page import="com.itwillbs.bean.Phone"%>
<%@page import="com.itwillbs.bean.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/el/BeanTest.jsp</h1>
   
   <h2> 전달받은 객체 정보를 출력 </h2>
   
   <!-- jsp코드 사용 -->
   <%
       Person p = (Person)request.getAttribute("person");
   %>
      사람의 이름 : <%=p.getName() %><br>
      사람의 나이 : <%=p.getAge() %><br>
      사람의 휴대폰 : <%=p.getPhone() %><br>
   휴대폰 정보 - 모델명 : <%=p.getPhone().getModel() %><br>
   휴대폰 정보 - 전화번호 : <%=p.getPhone().getTelNum()%><br>
   <%
      Phone phone = p.getPhone(); 
   %>
   <%=phone.getModel() %><br>
   <%=phone.getTelNum() %><br>
   
   
   <!-- EL표현식 사용 -->
  <hr> 
   이름 : ${person.name }<br>
   이름 : ${requestScope.person.name }<br>
   나이 : ${person.age } <br>
   휴대폰번호 :${person.phone.telNum } <br>
   휴대폰번호 :${requestScope.person.phone.telNum } <br>
   
   
   
   
   
   
   
   
   
</body>
</html>