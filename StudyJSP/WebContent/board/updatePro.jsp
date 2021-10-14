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
   <h1>WebContent/board/updatePro.jsp</h1>
   <%
     // 한글처리
     request.setCharacterEncoding("UTF-8");
     
     // 전달되는 데이터 저장
     // get - pageNum (주소) => 변수
     String pageNum = request.getParameter("pageNum");
     // post - num,name,pass,subject,content (from) => 자바빈 액션태그 
   %>
    <jsp:useBean id="bb" class="com.itwillbs.board.BoardBean"/>
    <jsp:setProperty property="*" name="bb"/>
   <%
    //bb.setNum(Integer.parseInt(request.getParameter("num")));
    //System.out.println("수정될 정보 : "+bb);
   
    // BoardDAO 객체생성 
    BoardDAO bDAO = new BoardDAO();
    // DB정보를 수정 - updateBoard(bb);
    int check = bDAO.updateBoard(bb); 
    
    // 수정된 결과에 따른 페이지 이동 (-1, 0, 1)
    
    if(check == 1){
    	%>
    	 <script type="text/javascript">
    	    alert("글 정보 수정완료!");
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