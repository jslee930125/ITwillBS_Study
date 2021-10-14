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

	<h1>WEB-INF/views/member/update.jsp</h1>

	<h2>회원정보 수정(SpringMVC)</h2>
	
	<fieldset>
      <form action="./update" method="post">
      <!--./ 현재 프로젝트 밑을 의미  -->
        아이디 : <input type="text" name="userid" value=${vo.userid } readonly="readonly"><br>
        <!-- readonly는 데이터는 넘어가서 쓸 수 있지만, disabled는 태그 자체를 무용하게 만들어, 데이터가 넘어가지 않는다.  -->
       	비밀번호 : <input type="password" name="userpw" placeholder="비밀번호를 입력하세요."><br>
        이름 : <input type="text" name="username" value=${vo.username }><br>
        이메일 : <input type="text" name="useremail" value=${vo.useremail }><br>
        <hr>
        <input type="submit" value="수정하기">        
      </form>    
    </fieldset>

</body>
</html>