<%@page import="com.itwillbs.board.BoardDAO"%>
<%@page import="com.itwillbs.board.BoardBean"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WebContent/board/fWritePro.jsp</h1>

	<%
		// 파일 업로드 
		String realPath = request.getRealPath("/upload");
	    int maxSize = 10 * 1024 * 1024; //10MB
	    
	    MultipartRequest multi 
	    	= new MultipartRequest(
	    		      request,
	    		      realPath,
	    		      maxSize,
	    		      "UTF-8",
	    		      new DefaultFileRenamePolicy()
	    		);
		

		// 글의 정보를 객체에 저장(BoardBean)
		// - 파일은 파일의 이름만 저장
		BoardBean bb = new BoardBean();
		
		bb.setName(multi.getParameter("name"));
		bb.setPass(multi.getParameter("pass"));
		bb.setSubject(multi.getParameter("subject"));
		bb.setFile(multi.getFilesystemName("file"));
		bb.setContent(multi.getParameter("content"));
		// bb.setIp(multi.getRemoteAddr());(x)
		bb.setIp(request.getRemoteAddr());

		// BoardDAO 객체 생성 글 저장
		BoardDAO bDAO = new BoardDAO();
		// insertBoard()
		bDAO.insertBoard(bb);

		// 리스트 페이지로 이동
		response.sendRedirect("list.jsp");

		//+ 파일 다운로드 (content.jsp)
	%>












</body>
</html>