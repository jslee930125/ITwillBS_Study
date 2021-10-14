<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/el/ArrayTest.jsp</h1>
   
   <h2> 전달된 배열의 정보 출력 </h2>
   <h3> JSP </h3>
   <%
     // 전달된 배열의 정보를 출력
     String[] foods = (String[])request.getAttribute("foods");
     for(int i=0;i<foods.length;i++){
    	 out.println(foods[i]+"<br>");
     }   
     
     ArrayList sports = (ArrayList)request.getAttribute("sports");
     
     for(int i=0;i<sports.size();i++){
    	 out.print(sports.get(i)+"<br>");    	 
     }
     
   
   %>
   <h3> EL </h3>
   ${requestScope.foods }<br>
   ${requestScope.foods[0] }<br>
   ${requestScope.foods[3] }<br>
   
   ${requestScope.sports[0] }<br>
   ${requestScope.sports[3] }<br>
   
   
   <h3> JSTL + EL </h3>
   
   <c:forEach var="food" items="${requestScope.foods }">
          음식 : ${food }<br>    
   </c:forEach>
   
   <c:forEach var="s" items="${sports }">
          스포츠 : ${s }<br>
   </c:forEach>
   
   
   
</body>
</html>