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

   <h1>WebContent/board/deletePro.jsp</h1>
   <%
     // 한글처리
     request.setCharacterEncoding("UTF-8");
     // 전달된 파라미터값 저장
     String pageNum = request.getParameter("pageNum");
     
     int num = Integer.parseInt(request.getParameter("num"));
     String pass =  request.getParameter("pass");
     
     // DAO객체 생성 -> 글 삭제 메서드 (deleteBoard())
     BoardDAO bDAO = new BoardDAO();
     int check = bDAO.deleteBoard(num,pass);
     
     // => 0,-1,1 값을 사용하여 페이지이동(JS)  
    if(check == 1){
    	%>
    	 <script type="text/javascript">
    	    alert("글 정보 삭제완료!");
    	    location.href='list.jsp?pageNum=<%=pageNum%>';
    	 </script>    	
    	<%
    }else if(check == 0){
    	%>
    	 <script type="text/javascript">
    	     alert("비밀번호 오류!");
    	     history.back();
    	 </script>    	
    	<%
    }else{ //check == -1
    	%>
	   	 <script type="text/javascript">
	   	     alert("해당 글 없음!");
	   	     history.back();
	   	 </script>    	
   		<%
    }
   %>
   
   
   
   
   
   
   
   

</body>
</html>