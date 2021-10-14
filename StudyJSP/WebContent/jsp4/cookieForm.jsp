<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>WebContent/jsp4/cookieForm.jsp</h1>
 <%
   // 메세지 출력 ("안녕하세요 쿠키연습!"/"Hello, Cookie Test!")
   // cookiePro.jsp로 언어 정보를 전달 (라디오버튼)
   // 생성된 쿠키정보에 따른 출력
   // 9. 출력을 위한 언어정보 저장변수
   String lang = "kor";
   // 6. 생성된 쿠키값에 따라서 출력되는 메세지 변경
   // 7. 쿠키값을 request에서 가져오기
   Cookie[] cookies = request.getCookies();
 
   // 8. 쿠키 배열의 값을 모두 비교후 원하는 정보 사용
   if(cookies != null){
	   for(int i=0;i<cookies.length;i++){
		   if(cookies[i].getName().equals("lang")){
			   out.print(cookies[i].getValue());
			   lang = cookies[i].getValue();
		   }
	   }
   }
   // 10. 결과 출력
   if(lang.equals("kor")){
	   out.print(" 안녕하세요, 쿠키연습!");
   }else{
	   out.print(" Hello, Cookie Test!");
   }
   
   
   // 1.쿠키 값을 생성하기위한 데이터 전달
 %>
   <form action="cookiePro.jsp" method="post">
      <input type="radio" name="language" value="kor"
             <%if(lang.equals("kor")){ %>
             checked="checked"
             <%} %>
             > 한국어 
      <input type="radio" name="language" value="eng"
             <%if(lang.equals("eng")){ %> checked="checked" <%} %> > 영어 
      <input type="submit" value="언어설정하기"> 
   </form>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</body>
</html>