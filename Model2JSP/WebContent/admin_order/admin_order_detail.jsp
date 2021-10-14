<%@page import="com.itwillbs.order.db.OrderDTO"%>
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
   <h1>WebContent/admin_order/admin_order_detail.jsp</h1>
   <%
     List aodList = (List) request.getAttribute("aodList");
     
     //공통의 정보 사용객체 (주문자 정보,배송지정보....)
     OrderDTO odto0 =(OrderDTO) aodList.get(0);
        
   %>
   
   <h2> 주문상세 페이지 (관리자-수정) </h2>
   
   <form action="./AdminOrderModify.ao" method="post">
   
   <input type="hidden" name="trade_num" value="<%=odto0.getO_trade_num()%>">
  
   <table border="1">
     <tr>
       <td colspan="6">
         <h3> 주문 상품 정보  : <%=odto0.getO_trade_num() %></h3>
       </td>
     </tr>
   
     <tr>
       <td>상품명</td>
       <td>구매수량</td>
       <td>구매옵션(크기)</td>
       <td>구매옵션(색상)</td>
       <td>가격</td>
     </tr>
     
     <%
     int total = 0;
     for(int i=0;i<aodList.size();i++){
    	     OrderDTO odto = (OrderDTO)aodList.get(i);
    	     total += odto.getO_sum_money();
    	 %>
	     <tr>
	       <td><%=odto.getO_g_name() %></td>
	       <td><%=odto.getO_g_amount() %></td>
	       <td><%=odto.getO_g_size() %></td>
	       <td><%=odto.getO_g_color() %></td>
	       <td><%=odto.getO_sum_money() %></td>
	     </tr>
     <%} %>
     
     
     
     <tr>
       <td colspan="6">
         <h3> 배송지 정보 </h3>
       </td>
     </tr>
     
     <tr>
        <td colspan="6">
          <h5> 받는사람 :  <%=odto0.getO_r_name() %>  </h5>
          <h5> 전화번호 :  <%=odto0.getO_r_phone() %></h5>
          <h5> 배송지 주소 : <%=odto0.getO_r_addr1() %> </h5>
          <h5> 배송지 세부주소 : <%=odto0.getO_r_addr2() %></h5>
          <h5> 요청사항 : <%=odto0.getO_r_msg() %> </h5>
        </td>
     </tr>
     
     <tr>
       <td colspan="6">
         <h3> 결제 정보 </h3>
       </td>
     </tr>
     
     <tr>
       <td colspan="6">
         <h3>주문 총 금액 : <%=total %> </h3>
         <h3>결제 방법 : <%=odto0.getO_trade_type() %> </h3>
         <h3>운송장번호 : <input type="text" name="trans_num" value="<%=odto0.getO_trans_num()%>"></h3>
         <h3> 주문상태 </h3> 
          <select name="status">
            <option value="0"
               <%
                if(odto0.getO_status() == 0){
                	%>
                	 selected
                	<%
                }
               %>
             >대기중</option>
            <option value="1"
               <%
                if(odto0.getO_status() == 1){
                	%>
                	 selected
                	<%
                }
               %>
            >발송준비</option>
            <option value="2"
               <%
                if(odto0.getO_status() == 2){
                	%>
                	 selected
                	<%
                }
               %>
            >발송완료</option>
            <option value="3"
                <%
                if(odto0.getO_status() == 3){
                	%>
                	 selected
                	<%
                }
               %>
            >배송중</option>
            <option value="4"
               <%
                if(odto0.getO_status() == 4){
                	%>
                	 selected
                	<%
                }
               %>
            >배송완료</option>
            <option value="5"
               <%
                if(odto0.getO_status() == 5){
                	%>
                	 selected
                	<%
                }
               %>
            >주문취소</option>
          </select>
                 
       
       </td>
     </tr>
    
     <tr>
       <td colspan="6">
          <input type="submit" value="정보 수정하기">       
          <input type="reset" value="취소하기">       
       </td>
     </tr>
     
   </table>
   </form>
   
   
   
</body>
</html>