<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/board/reWritePro.jsp</h1>
  
  <%
    // 한글처리 
    request.setCharacterEncoding("UTF-8");
    // 전달된 파라미터를 저장 => 액션태그사용 자바빈 객체를 활용
   %>
   <jsp:useBean id="bb" class="com.itwillbs.board.BoardBean"/>
   <jsp:setProperty property="*" name="bb" />    		
   <% 
    // IP주소 추가 저장
    bb.setIp(request.getRemoteAddr());
   
    // DAO 객체 생성 -> 답글 작성메서드 실행  reInsertBoard(bb);
    BoardDAO bDAO = new BoardDAO();
    bDAO.reInsertBoard(bb);
    
    // 리스트로 페이지이동
    response.sendRedirect("list.jsp");
  
  %>
  
  
  
  
  
  
  
  
  
  

</body>
</html>