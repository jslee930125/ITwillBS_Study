<%@page import="com.itwillbs.admin.goods.db.GoodsDTO"%>
<%@page import="com.itwillbs.basket.db.BasketDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/basket/goods_basket_list.jsp</h1>
	
	<%
	
	  // request.setAttribute("totalList", totalList);
	  // Vector totalList = (Vector)request.getAttribute("totalList");
	  // List basketList = (List)totalList.get(0);
	  // List goodsList = (List)totalList.get(1);
	  // 다운캐스팅하는데 메모리자원이 필요, 메모리 자원이 많이 필요한 이중 리스트 작업을 뷰 페이지까지 끌고 올 필요는 없다.
		
	  // request.setAttribute("basketList", totalList.get(0));
      // request.setAttribute("goodsList", totalList.get(1));
      	List<BasketDTO> basketList = (List)request.getAttribute("basketList");
      	List<GoodsDTO> goodsList = (List)request.getAttribute("goodsList");
      	// 이 두개는 같은 for문 돌아도 된다.
	
	%>

	<h2><%=session.getAttribute("id")%>님의 장바구니
	</h2>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이미지</td>
			<td>상품명</td>
			<td>사이즈</td>
			<td>컬러</td>
			<td>구매수량</td>
			<td>가격</td>
			<td>취소</td>
		</tr>
		<% for(int i=0; i < basketList.size() ; i++){ 
			BasketDTO bkdto = basketList.get(i);
			GoodsDTO gdto = goodsList.get(i);
		%>
		<tr>
			<td><%=bkdto.getB_num() %></td>
			<td><img src="./upload/<%=gdto.getImage().split(",")[0] %>"
				     width="50" height="50"
			></td>
			<td><%=gdto.getName() %></td>
			<td><%=bkdto.getB_g_size() %></td>
			<td><%=bkdto.getB_g_color() %></td>
			<td><%=bkdto.getB_g_amount() %></td>
			<td><%=gdto.getPrice() %></td>
			<td><a href="./BasketDelete.ba?b_num=<%=bkdto.getB_num()%>">취소</a></td>
		</tr>
		<%} %>
	</table>
	
	<h3><a href="./OrderStart.or">[구매하기]</a></h3>
	<h3><a href="./GoodsList.go">[계속 쇼핑하기]</a></h3>
</body>
</html>