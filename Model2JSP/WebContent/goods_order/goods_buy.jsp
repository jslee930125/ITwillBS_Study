<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.admin.goods.db.GoodsDTO"%>
<%@page import="com.itwillbs.basket.db.BasketDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/goods_order/goods_buy.jsp</h1>
   <%
    // OrderStartAction객체
    //request.setAttribute("basketList", basketList);
	//request.setAttribute("goodsList", goodsList);
	//request.setAttribute("mdto", mdto);
	
	List<BasketDTO> basketList = (List<BasketDTO>) request.getAttribute("basketList");
	List<GoodsDTO> goodsList = (List<GoodsDTO>) request.getAttribute("goodsList");
	MemberDTO mdto = (MemberDTO)request.getAttribute("mdto");
   
   %> 
   
   <h2> 주문상세 페이지 </h2>
   
   <form action="./OrderAddAction.or" method="post">
   <!-- 배송지 정보 + 결제정보만 전달
               장바구니 정보/상품정보는 없음 (DB에서 조회)
    -->   
   <table border="1">
     <tr>
       <td colspan="6">
         <h3> 주문 상품 정보 </h3>
       </td>
     </tr>
   
     <tr>
       <td>상품사진</td>
       <td>상품명</td>
       <td>구매수량</td>
       <td>구매옵션(크기)</td>
       <td>구매옵션(색상)</td>
       <td>가격</td>
     </tr>
     
     <% 
     int total_money = 0;
     for(int i=0;i<basketList.size();i++){
    	     BasketDTO bkdto = basketList.get(i);
    	     GoodsDTO gdto = goodsList.get(i);
    	     
    	     total_money += (bkdto.getB_g_amount() * gdto.getPrice()); 
    	 %>
     <tr>
       <td>
         <img src="./upload/<%=gdto.getImage().split(",")[0]%>"
              width="50" height="50" >
       </td>
       <td>
         <a href="./GoodsDetail.go?num=<%=bkdto.getB_g_num()%>"><%=gdto.getName() %></a>
       </td>       
       <td><%=bkdto.getB_g_amount() %></td>
       <td><%=bkdto.getB_g_size() %></td>
       <td><%=bkdto.getB_g_color() %></td>
       <td><%=gdto.getPrice() %></td>
     </tr>
     <% } %>
     
     <tr>
       <td colspan="6">
         <h3> 총 가격 : <%=total_money %>원</h3>
       </td>
     </tr>
     
     
     <tr>
       <td colspan="6">
         <h3> 주문자 정보 </h3>
       </td>
     </tr>
     
     <tr>
       <td colspan="6">
         <h5> 이름 : <%=mdto.getName() %></h5>
         <h5> 전화번호 :  </h5>
         <h5> 이메일주소 : <%=mdto.getEmail() %> </h5>
       </td>
     </tr>
     
     <tr>
       <td colspan="6">
         <h3> 배송지 정보 </h3>
       </td>
     </tr>
     
     <tr>
        <td colspan="6">
          <h5> 받는사람 : <input type="text" name="o_r_name" value="<%=mdto.getName()%>"> </h5>
          <h5> 전화번호 : <input type="text" name="o_r_phone"> </h5>
          <h5> 배송지 주소 : <input type="text" name="o_r_addr1"> </h5>
          <h5> 배송지 세부주소 : <input type="text" name="o_r_addr2"> </h5>
          <h5> 요청사항 : <input type="text" name="o_r_msg"> </h5>
        </td>
     </tr>
     
     <tr>
       <td colspan="6">
         <h3> 결제 정보 </h3>
       </td>
     </tr>
     
     <tr>
       <td colspan="6">
           <h5>입금자명(온라인) : <input type="text" name="o_trade_payer" value="<%=mdto.getName()%>"> </h5>
           <input type="radio" name="o_trade_type" value="신용카드">신용카드<br>
           <input type="radio" name="o_trade_type" value="체크카드">체크카드<br>
           <input type="radio" name="o_trade_type" value="카카오페이">카카오페이<br>
           <input type="radio" name="o_trade_type" value="네이버페이">네이버페이<br>
           <input type="radio" name="o_trade_type" value="온라인입금" checked>온라인입금<br>
       </td>
     </tr>
    
     <tr>
       <td colspan="6">
          <input type="submit" value="주문하기">       
          <input type="reset" value="취소하기">       
       </td>
     </tr>
     
   </table>
   </form>
   
   
   
   
   
   
   
</body>
</html>