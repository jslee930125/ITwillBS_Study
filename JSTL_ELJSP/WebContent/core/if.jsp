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
   <h1>WebContent/core/if.jsp</h1>
   
   <c:set var="i" value="test" />
   
   <c:if test="${i == 'test' }">
       <h2>동일한 값!</h2>
   </c:if>
   
   <%
     if(true){
    	%>
    	 <h2>동일한 값222!</h2>
    	<% 
     }   
   %>
   
   <hr>
   <!-- 변수 2개를 사용해서 둘중에 더 큰값을 출력하는 코드 -->
   
   <c:set value="-10" var="num1"></c:set>
   <c:set value="200" var="num2"></c:set>
   
   <c:if test="${num1 > num2}">
        <h2>${num1 }데이터가 더 크다</h2>
   </c:if>
   
   <c:if test="${num1 < num2}">
        <h2>${num2 }데이터가 더 크다</h2>
   </c:if>
   
   <c:if test="${num1 lt num2}">
        <h2>${num2 }데이터가 더 크다</h2>
   </c:if>
   
   <h2> switch-case문과 유사한 구문 </h2>
   <!-- num1 값이 50보다 큰지 100보다 큰지 판단/그외 범위 -->
   <c:choose>
     <c:when test="${num1 > 50}">
        <h3>50보다 큰값!</h3>
     </c:when>
     <c:when test="${num1 > 100 }">
        <h3>100보다 큰값!</h3>
     </c:when>     
     <c:otherwise>
        <h3> 그외 나머지 데이터</h3>
        <c:if test="${num1 < 0 }">
          <h3> 음수!! </h3>
        </c:if>
     </c:otherwise>  
   </c:choose>
   
   
   
   
   
   
   
   

</body>
</html>