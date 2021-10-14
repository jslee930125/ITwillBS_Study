<%@page import="java.awt.color.CMMException"%>
<%@page import="com.itwillbs.board.BoardBean"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>WebContent/board/list.jsp</h1>

	<%
		// 테이블에 저장된 글의 총 개수 확인
		// BoardDAO 객체 생성
		BoardDAO bDAO = new BoardDAO();
		// 글의 총개수를 계산하는 메서드 생성
		int cnt = bDAO.getBoardCount();
		
		////////////////////////////////////////////////////////
		// 페이징 처리
		
		// 한 페이지에 출력할 글의 개수
		int pageSize = 5;
		// 현 페이지의 위치정보
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		// 시작행번호 계산  1...11...21...31...
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		
		// 끝행번호 계산  10...20....30...40....
		int endRow = currentPage * pageSize;
		
		////////////////////////////////////////////////////////
		
		ArrayList boardList = null;
		// 저장된 모든 글의 정보를 가져오는 메서드 생성
		if(cnt > 0){ // cnt != 0
		   //boardList = bDAO.getBoardList();
		   boardList = bDAO.getBoardList(startRow,pageSize); 
		   //System.out.println(boardList.toString());
		}	
		
		
	%>

	<h2>게시판 목록 [총 : <%=cnt %>개]</h2>
	
	<h3><a href="writeForm.jsp">글쓰기</a></h3>

    <table border="1">
      <tr>
		<td>번호</td>       
		<td>제목</td>       
		<td>작성자</td>       
		<td>날짜</td>       
		<td>조회수</td>       
		<td>IP</td>       
      </tr>
      <%
      // size() : 가변길이 배열의 요소의 수를 리턴하는 메서드
      for(int i=0;i<boardList.size();i++){
    	   BoardBean bb = (BoardBean) boardList.get(i);
      %>
	      <tr>
			<td><%=bb.getNum() %></td>       
			<td>
			<%
			int wid = 0;
			if(bb.getRe_lev()>0){ // 답글일때
				wid = 10 * bb.getRe_lev();
				%>
			    <img src="level.gif" height="15" width="<%=wid%>">
			    <img src="re.gif">
			<%} %>   
				<a href='content.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>'>
					<%=bb.getSubject() %>
				</a>
			</td>       
			<td><%=bb.getName() %></td>       
			<td><%=bb.getDate() %></td>       
			<td><%=bb.getReadcount() %></td>       
			<td><%=bb.getIp() %></td>       
	      </tr>
      <%
      }
      %>
    
    </table>


    <hr>
    
    <%
     ///////////////////////////////////////////////////////////
     // 페이징처리
     if(cnt > 0){
    	 
    	// 한 페이지에서 보여줄 페이지 번호의 개수 
    	int pageBlock = 3;
    	
    	// 전체 페이지 개수 => 전체 글 / 페이지 크기
    	int pageCount = cnt / pageSize + (cnt % pageSize == 0? 0:1);
    	
    	// 페이지 블럭 시작번호 계산    1~10=> 1, 11~20 => 11, 21~30=>21
    	int startPage =((currentPage-1)/pageBlock)*pageBlock+1;
    	
    	// 페이지 블럭 끝번호 계산
    	int endPage = startPage + pageBlock - 1;
    	
    	if(endPage > pageCount){
    		endPage = pageCount;
    	}
    	
    	
    	// [이전]
    	if(startPage > pageBlock){
    		%>
    		  <a href="list.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a>
    		<%
    	}
    	// [1...10] [11...20] [21...30] ....
    	for(int i=startPage;i<=endPage;i++){
    		%>
    		     <a href="list.jsp?pageNum=<%=i%>">[<%=i %>]</a>
    		<%
    	}    	
    	// [다음]
    	if(endPage < pageCount){
    		%>
    		 <a href="list.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a>    		
    		<%
    	}
    	 
    	 
     }
     ////////////////////////////////////////////////////////////
    %>










</body>
</html>