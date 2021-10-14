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
   <h1>WebContent/admin_order/admin_order_list.jsp</h1>
   
  <h2> 쇼핑몰 전체 주문목록 (관리자) </h2>
  
  <table border="1">
    <tr>
      <td>주문번호</td>
      <td>상품명</td>
      <td>결제금액</td>
      <td>결제방법</td>
      <td>주문상태</td>
      <td>주문일자</td>
      <td>주문자</td>
      <td>수정/삭제</td>
    </tr>
    
    <!-- 
         주문 상태 
         0 - 대기중, 1 - 발송준비, 2 - 발송완료
         3 - 배송중, 4 - 배송완료, 5 - 주문취소    
     -->
    
    <c:forEach var="aordto" items="${adminOrderList }">
	    <tr>
	      <td>${aordto.o_trade_num }</td>
	      <td>${aordto.o_g_name }</td>
	      <td>${aordto.o_sum_money }</td>
	      <td>${aordto.o_trade_type }</td>
	      
	      <c:if test="${aordto.o_status == 0 }"> <td>대기중!</td> </c:if>
	      <c:if test="${aordto.o_status == 1 }"> <td>발송준비!</td> </c:if>
	      <c:if test="${aordto.o_status == 2 }"> <td>발송완료!</td> </c:if>
	      <c:if test="${aordto.o_status == 3 }"> <td>배송중!</td> </c:if>
	      <c:if test="${aordto.o_status == 4 }"> <td>배송완료!</td> </c:if>
	      <c:if test="${aordto.o_status == 5 }"> <td>주문취소!</td> </c:if>
	      
	      <td>${aordto.o_date }</td>
	      <td>${aordto.o_m_id }</td>
	      <td>
	         <a href="./AdminOrderDetail.ao?trade_num=${aordto.o_trade_num }">수정</a>
	      /삭제</td>
	    </tr>
    </c:forEach>
  </table>
  
  <h2><a href="./Main.me">[메인 페이지]</a></h2>
  <h2><a href="./GoodsList.go">[쇼핑몰 페이지]</a></h2>
   
   
</body>
</html>