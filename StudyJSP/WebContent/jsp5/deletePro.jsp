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
    <h1>WebContent/jsp5/deletePro.jsp</h1>
    <%
     // 한글처리
     request.setCharacterEncoding("UTF-8");
     // 전달된 파라미터값 저장 (delID,delPW)
     String delID = request.getParameter("delID");
     String delPW = request.getParameter("delPW");
     
     // DB에 연결해서 해당 회원정보를 확인후 삭제
     
     final String DRIVER = "com.mysql.jdbc.Driver";
     final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
     final String DBID = "root";
     final String DBPW = "1234";
     
     // 1) 드라이버 로드
     Class.forName(DRIVER);
     System.out.println(" 드라이버 로드 성공! ");
     // 2) 디비연결
     Connection con 
        = DriverManager.getConnection(DBURL, DBID, DBPW);
     System.out.println(" 디비 연결 성공! "+con);
     
     // 3) sql 생성 & pstmt 객체
     // select구문(삭제하려는 사람의 정보가 맞는지 확인후 삭제)
     String sql ="select pass from itwill_member where id=?";
     PreparedStatement pstmt = con.prepareStatement(sql);
     
     // ?
     pstmt.setString(1, delID);
     
     // 4) sql 실행
	 ResultSet rs = pstmt.executeQuery();
     
     // 5) 데이터 처리
     if(rs.next()){
    	 //회원이다.
    	 // 본인여부 판단-비밀번호 맞는지 체크
    	 if(delPW.equals(rs.getString("pass"))){
    		 // 회원이면서 비밀번호 동일 => 본인 => 수정/삭제
    	     // 3) sql 생성 & pstmt 객체
			sql = "delete from itwill_member where id=?";
    	    pstmt = con.prepareStatement(sql);
    	    
    	    pstmt.setString(1, delID);
    	    
    	    // 4) sql 실행
           int result = pstmt.executeUpdate();
    	    // sql 구문이 영향을 준 row수를 리턴함
    	    // -> '0'일때 : sql구문에 영향이 X / 실행오류 / DDL구문
            
    	    System.out.println("회원 탈퇴 성공! "+result);    				 
    				 
    	 }else{
    		// 회원이지만, 비밀번호 오류
    		System.out.println("비밀번호 오류 입니다!");
    		System.out.println("아이디 또는 비밀번호 오류 입니다!");
    	 }    	 
    	 
     }else{
    	 //비회원이다.
    	 System.out.println("비회원 입니다!");
     }


     
    
    %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
</body>
</html>