<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/member/main.jsp</h1>
   
   <h2>메인 페이지 (Model2)</h2>
   <!-- 로그인시 접근 가능한 페이지 -->
   <%
     // 세션영역에 있는 정보를 저장
     String id = (String) session.getAttribute("id");
     // 정보가 없으면 로그인 페이지로 이동   
     
     if(id == null){
    	 response.sendRedirect("./MemberLogin.me");
     }
   %>
   <!-- 회원 아이디 출력 -->
   <%=id %>님 환영합니다
   <input type="button" value="로그아웃" 
          onclick="location.href='./MemberLogout.me';"><br>
   
   <hr>
   
   <a href="./MemberInfo.me"> 회원 정보 조회 (select)</a><br>
   
   <a href="./MemberUpdate.me"> 회원 정보 수정(update)</a><br>
   
   <a href="./MemberDelete.me"> 회원 정보 삭제(delete)</a> <br>
   
   <hr>
   <h3> 쇼핑몰 </h3>
	   
   <a href="./GoodsList.go"> 쇼핑몰 목록</a> <br>
   <a href="./BasketList.ba"> 쇼핑몰 장바구니 목록 </a> <br>
   <a href="./OrderStart.or"> 쇼핑몰 주문 상세페이지 </a> <br>
   <a href="./OrderList.or"> 쇼핑몰 주문 리스트(개인) </a> <br>
   
   
   <!-- admin(관리자) 메뉴  -->
 
   
   <%
//     if(id != null){
//      	if(id.equals("admin")){
    // * 데이터값 비교시 null인지 체크후 비교!! 		
    if( id != null && id.equals("admin")){ 		
   %>
     <hr>
   	 <h3> 관리자 기능</h3>
	   <a href="./MemberListAction.me"> 회원 정보 목록(List)</a> <br>
	   
	   <a href="./GoodsAdd.ag"> 관리자 상품 등록</a> <br>

	   <a href="./AdminGoodsList.ag"> 관리자 상품 리스트(List)</a> <br>
	   
	   <a href="./AdminOrderList.ao"> 관리자 주문 리스트(List)</a> <br>
	   
   <%
    }
   %>
   
</body>
</html>