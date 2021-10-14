<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/member/insertPro.jsp</h1>
	<%
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		// 전달정보 저장(파라미터)
		// id,pass,name,age,gender,email
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		// 날짜 정보생성 -> 현 시스템의 시간정보를 저장
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());

		// DB연결 후 회원 가입
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";

		// 1. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println("드라이버 로드 성공!");
		
		// 2. 디비연결
		Connection con 
		  = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println("디비연결 성공!");
		
		// 3. sql(insert) & pstmt 객체 
		String sql = "insert into itwill_member values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		pstmt.setString(3, name);
		pstmt.setInt(4, age);
		pstmt.setString(5, gender);
		pstmt.setString(6, email);
		pstmt.setTimestamp(7, reg_date);
		
		// 4. sql 실행
		pstmt.executeUpdate();
		
		System.out.println("회원가입 성공!");

		// 로그인페이지로 이동(loginForm.jsp)
	%>
	
	<script type="text/javascript">
	   alert(" 회원가입 성공! 로그인페이지로 이동! ");
	   location.href="loginForm.jsp";	
	</script>










</body>
</html>