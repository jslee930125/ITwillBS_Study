<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WebContent/member/updateForm.jsp</h1>

	<h2>회원정보 수정</h2>
	<!-- 
	 로그인 세션 제어
	
     DB에서 정보를 가져와서 화면에 출력	
	  아이디-수정불가, 비밀번호 표시 X
	  그외 나머지 정보는 모두 화면에 표시
	 -->
	<%
		// 로그인 세션 제어
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("loginForm.jsp");
		}

		// 2) DB에 있는 회원정보 모두를 가져오기
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";

		// 1. 드라이버 로드
		Class.forName(DRIVER);
		// 2. 디비연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		// 3. sql 작성 & pstmt 객체
		String sql = "select * from itwill_member where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		// ?
		pstmt.setString(1, id);

		// 4. sql 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. 데이터 처리
		String name="";
		int age=0;
		String gender="";
		String email="";
		
		if(rs.next()){
			//id = rs.getString("id");
			name = rs.getString("name");
			age = rs.getInt("age");
			gender = rs.getString("gender");
			email = rs.getString("email");
		}
		
		// 성별의 정보가 없을경우 기본값 설정
		if(gender == null){
			gender = "남자";
		}
		
		
	%>

	<fieldset>
		<form action="updatePro.jsp" method="post">
		       아이디 : <input type="text" name="id" value="<%=id%>" readonly><br>
			<%-- 아이디 : <input type="text" name="id" value="<%=id%>" disabled><br> --%>
			<!-- 
			     readonly : 수정 X, 읽기 전용 => input태그 사용가능
			     disabled : 사용 X => input태그 사용불가능
			 -->
			
			 비밀번호 : <input	type="password" name="pass" 
			           placeholder="수정전 비밀번호를 입력하시오."
			 ><br>
		         이름 : <input type="text" name="name" value="<%=name%>"><br>
		         나이 : <input type="text" name="age" value="<%=age%>"><br>
		         성별 : <input type="radio" name="gender"	value="남자"
		           <%if(gender.equals("남자")){ %>
		           		checked
		           <%} %>
		           > 남
		          <input type="radio" name="gender" value="여자" 
		           <%if(gender.equals("여자")){ %>
		           		checked
		           <%} %>
		          > 여 <br> 
			이메일 : <input type="text" name="email" value="<%=email%>"><br>
			<hr>
			<input type="submit" value="수정하기">
		</form>
	</fieldset>















</body>
</html>