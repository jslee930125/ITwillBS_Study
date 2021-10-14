<%@page import="com.itwillbs.board.BoardBean"%>
<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/board/updateForm.jsp</h1>
   
   <h2> 글정보 수정하기 </h2>
   
   <%
     // 전달된 정보 (num,pageNum) 파라미터를 저장
     int num = Integer.parseInt(request.getParameter("num"));
     String pageNum = request.getParameter("pageNum");
     
     // 기존의 글정보를 DB에서 가져와서 화면에 출력(비밀번호 출력 X)
     BoardDAO bdao = new BoardDAO();
     
     BoardBean bb = bdao.getBoard(num);
   %>
   
   
   <fieldset>
     <form action="updatePro.jsp?pageNum=<%=pageNum %>" method="post">
       <input type="hidden" name="num" value="<%=num%>">
      	글쓴이 : <input type="text" name="name" value="<%=bb.getName()%>"><br>
      	비밀번호 : <input type="password" name="pass" placeholder="비밀번호를 입력하세요."><br>
      	제목 : <input type="text" name="subject" value="<%=bb.getSubject()%>"><br>
      	내용 : <br>
      	<textarea rows="5" cols="20" name="content" ><%=bb.getContent() %></textarea>
      	<hr>
		<input type="submit" value="수정하기">     
     </form>
   </fieldset>
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>