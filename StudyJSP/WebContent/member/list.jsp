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
   <h1>WebContent/member/list.jsp</h1>
   
   <h2> 회원 전체 목록 확인 </h2>
   <%
    // 세션제어 (로그인O, admin O)
    String id = (String) session.getAttribute("id");
     
    if(id == null || !id.equals("admin")){
    	response.sendRedirect("loginForm.jsp");
    }
    
    // DB에서 모든 회원정보 출력 (관리자 제외)
   	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root";
	final String DBPW = "1234";    
	
	// 1. 드라이버 로드
	Class.forName(DRIVER);
	// 2. 디비 연결
	Connection con =
	  DriverManager.getConnection(DBURL, DBID, DBPW);
	// 3. sql 작성 & pstmt 객체
	String sql = "select * from itwill_member where id != ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, id); // "admin"
	// 4. sql 실행
	ResultSet rs = pstmt.executeQuery();
	// 5. 데이터 처리
   %>
     <table border="1">
      <tr>
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>나이</td>
        <td>성별</td>
        <td>이메일</td>
        <td>가입일자</td>
      </tr>
      
      <%
       while(rs.next()){
      %>
	      <tr>
	        <td><%=rs.getString("id") %></td>
	        <td><%=rs.getString("pass") %></td>
	        <td><%=rs.getString("name") %></td>
	        <td><%=rs.getInt("age") %></td>
	        <td><%=rs.getString("gender") %></td>
	        <td><%=rs.getString("email") %></td>
	        <td><%=rs.getTimestamp("reg_date") %></td>
	      </tr>
      <%} %>
     
     </table>
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>