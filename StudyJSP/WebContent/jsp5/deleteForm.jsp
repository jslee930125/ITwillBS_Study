<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/jsp5/deleteForm.jsp</h1>
   <!-- 
       deleteForm.jsp : 삭제할 정보를 입력
       deletePro.jsp : 전달받은 정보를 사용해서 DB에 있는 회원삭제   
    -->
    
    <form action="deletePro.jsp" method="post">
     	삭제할 아이디 : <input type="text" name="delID"><br>
     	삭제할 비밀번호 : <input type="text" name="delPW"><br>
    
    <input type="submit" value="삭제하기">
    </form>
    
   
   
   
   
   
   
   
   
   
   
</body>
</html>