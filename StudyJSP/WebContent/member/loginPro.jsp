<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>WebContent/member/loginPro.jsp</h1>
	<%
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 전달된 정보(id,pass) 저장
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// DB 접근해서 로그인 여부 판단
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";

		// 1. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println("드라이버 로드 성공!");

		// 2. 디비연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println("디비연결 성공!");
		
		// 3. sql 작성 & pstmt 객체 
		String sql ="select pass from itwill_member where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// ?
		pstmt.setString(1, id);
		
		// 4. sql 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. 데이터 처리 
		if(rs.next()){
			if(pass.equals(rs.getString("pass"))){
				// 로그인 성공
				// ID 정보를 세션영역에 저장
				session.setAttribute("id", id);
				
			    response.sendRedirect("main.jsp");
			}else{
				%>
				 <script type="text/javascript">
				    alert("비밀번호 오류!");
				    history.back();
				 </script>
				<%	
			}
			
		}else{
			%>
			 <script type="text/javascript">
			    //alert("회원 정보가 없음!");
			    var result = confirm("비회원입니다. 회원가입 하시겠습니까?");
			    
			    if(result){
			    	location.href="insertForm.jsp";
			    }else{
			    	history.back();
			    }
			    
			 </script>
			<%
		}

		// 회원정보가 없을경우
		// 회원정보가 있지만, 비밀번호가 틀린경우
		// => "메시지 전달", 페이지 뒤로 이동

		// 회원-본인경우
		// => main.jsp 페이지로 이동, 로그인 상태를 유지
		
		//+ ID가 없을경우  "비회원입니다. 회원가입 하시겠습니까?" Y/N
	    //   Y- 회원가입 페이지로 이동, N- 페이지뒤로가기 			
		
	%>













</body>
</html>