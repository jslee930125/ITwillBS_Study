<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/member/deletePro.jsp</h1>
	<%
		// 로그인 세션 제어
		String id = (String) session.getAttribute("id");

		if (id == null) {
			response.sendRedirect("loginForm.jsp");
		}
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 전달된 파라미터를 저장(id,pass)
		id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// DB이동후 데이터 삭제
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		// 2. 디비연결
		Connection con 
		  = DriverManager.getConnection(DBURL, DBID, DBPW);
		// 3. sql 작성 (select)& pstmt 객체 생성
		String sql = "select pass from itwill_member where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		// 4. sql 실행
		ResultSet rs = pstmt.executeQuery();
		// 5. 데이터처리
		if(rs.next()){
			if(pass.equals(rs.getString("pass"))){
				//본인 
				// 3 
				sql = "delete from itwill_member where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				// 4
				pstmt.executeUpdate();
				System.out.println("회원 삭제 완료");
				
				// 세션정보 삭제 (로그인정보)
				session.invalidate();
				
				// main.jsp페이지로 이동
				%>
				  <script type="text/javascript">
				     alert(" 회원 탈퇴 성공!  ");
				     location.href='main.jsp';
				  </script>			  
				 <%
				
			}else{
				// 비밀번호 오류
				%>
				  <script type="text/javascript">
				     alert("비밀번호 오류 - 삭제X");
				     history.back();
				  </script>			  
				 <%
			}
			
		}else{
			// 비회원
			 %>
			  <script type="text/javascript">
			     alert("회원정보 오류 - 삭제X");
			     history.back();
			  </script>			  
			  <%
		}
		
		
		
		
		
		
	%>












</body>
</html>