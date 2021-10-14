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
   <h1>WebContent/board/writePro.jsp</h1>
   
   <%
   // 한글 처리 
   request.setCharacterEncoding("UTF-8");
   
   // 전달된 파라미터값 저장(자바빈 객체-액션태그 사용)
   // com.itwillbs.board.BoardBean 자바빈 객체 생성
   %>
   <!-- 객체 생성 -->
   <jsp:useBean id="bb" class="com.itwillbs.board.BoardBean"/>
   <!-- 전달된 정보 전부를 저장 -->
   <jsp:setProperty property="*" name="bb"/>
   <%=bb %>
   <%
    // bb객체에 ip주소 추가
    bb.setIp(request.getRemoteAddr());   
   %>
   <hr>
   <%=bb %>
   
   <%
    // 디비처리 객체 생성
    BoardDAO bDAO = new BoardDAO();
   
    //글쓰기 메서드 호출
    bDAO.insertBoard(bb);
    // bDAO.getCon();(x)
    
    //글쓰기 이후 글 목록 페이지로 이동(list.jsp);
    response.sendRedirect("list.jsp");
   %>
   
   
   
   
   
   
   
   
   
</body>
</html>