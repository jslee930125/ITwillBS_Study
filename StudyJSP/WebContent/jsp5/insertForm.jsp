<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>WebContent/jsp5/insertForm.jsp</h1>
  <!-- 
     insertForm.jsp 정보입력
     insertPro.jsp 전달 후  전달된 정보를 DB에 저장
   -->
   
   <form action="insertPro.jsp" method="post">
	  아이디 : <input type="text" name="id"><br>
	  비밀번호 : <input type="password" name="pass"><br>
	  이메일 : <input type="text" name="email"><br>
   	  
   	 <input type="submit" value="정보 전달">   
   </form>
   
   
  
  
  
  
  
  
  
  
  
  

</body>
</html>