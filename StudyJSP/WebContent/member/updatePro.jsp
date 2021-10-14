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
	<h1>WebContent/member/updatePro.jsp</h1>

	<%
		// 세션값 제어
		String id = (String) session.getAttribute("id");

		if (id == null) {
			response.sendRedirect("loginForm.jsp");
		}

		// 한글 처리
		request.setCharacterEncoding("utf-8");

		// 전달되는 파라미터값 모두 저장
		// (pass,name,age,gender,email)
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		// 전달받은 정보를 DB에 저장후 페이지 이동
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		
		// 1 드라이버 로드
		Class.forName(DRIVER);
		// 2 디비연결
		Connection con 
		 = DriverManager.getConnection(DBURL, DBID, DBPW);
		// 3 sql 작성 (select) & pstmt 객체 생성
		String sql = "select pass from itwill_member where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// ? 
		pstmt.setString(1, id);
		
		// 4 sql 실행
		ResultSet rs = pstmt.executeQuery();
		// 5 데이터 처리  (update)
		//  본인일때만 수정 => main.jsp 페이지
		//  회원 X, 비밀번호 오류 => 수정X, 뒤로가기
		
		if(rs.next()){
			if(pass.equals(rs.getString("pass"))){
			 // 본인
			 
			 // 3 sql 작성 & pstmt 객체 생성
			 sql = "update itwill_member set name=?,age=?,gender=?,email=? where id=?";
			 pstmt = con.prepareStatement(sql);
			 
			 pstmt.setString(1, name);
			 pstmt.setInt(2, age);
			 pstmt.setString(3, gender);
			 pstmt.setString(4, email);
			 pstmt.setString(5, id);
			 
			 // 4 sql 실행
			 pstmt.executeUpdate();
			 
			 
			 %>
			 <script type="text/javascript">
			     alert(" 회원정보 수정완료! ");
			     location.href='main.jsp';
			 </script>			 
			 <% 			 
			}else{
			  // 회원정보 O, 비밀번호 오류
			  %>
			  <script type="text/javascript">
			     alert("비밀번호 오류 - 수정X");
			     history.back();
			  </script>			  
			  <%
			}			
		}else{
		  // 회원정보가 없음
			 %>
			  <script type="text/javascript">
			     alert("회원정보 오류 - 수정X");
			     history.back();
			  </script>			  
			  <%
		}
		
		
		
	%>














</body>
</html>