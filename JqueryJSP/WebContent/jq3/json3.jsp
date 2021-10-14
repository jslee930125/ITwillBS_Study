<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// DB에서 정보를 가져오기
	//  모든 회원 정보를 가져오기 동작 구현
	// 1. 드라이버 로드
	Class.forName("com.mysql.jdbc.Driver");
	// 2. 디비 연결
	Connection con =
	DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "1234");
	
	// 3. sql 작성 & pstmt 객체 
    String sql ="select * from itwill_member";
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	// 4. sql 실행
	ResultSet rs = pstmt.executeQuery();
	
	// 5. 데이터 처리 
	// JSON으로 변경
	
	JSONArray memberList = new JSONArray();
	while(rs.next()){
		// 배열한칸에 객체 1개씩
		JSONObject member = new JSONObject();
		member.put("id", rs.getString("id"));
		member.put("pass",rs.getString("pass"));
		member.put("name", rs.getString("name"));
		member.put("age", rs.getInt("age"));
		member.put("gender", rs.getString("gender"));
		member.put("email",rs.getString("email"));
		member.put("reg_date", rs.getTimestamp("reg_date")+"");
		
		memberList.add(member);		
	}

	// 화면에 출력
%>
    <%=memberList %>




