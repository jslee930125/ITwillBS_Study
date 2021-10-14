<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/jsp5/updateForm.jsp</h1>
  <%
    //updateForm.jsp 에서 수정할 정보를 입력(pass)
    //updatePro.jsp 이동후 정보 전달 -> DB정보를 수정
  %>
  
  <form action="updatePro.jsp" method="post">
   <!-- 사용자 ID 입력 -->
     아이디 : <input type="text" name="id"><br> 
     수정할 비밀번호 : <input type="password" name="pass"> <br>
    
    <input type="submit" value="수정하기">
  
  </form>
  
  



</body>
</html>