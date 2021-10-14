<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/jsp4/cookieTest.jsp</h1>
  <%
    // 데이터저장 -> 변수
    // 데이터를 연속적인 공간 -> 배열
    // 여러개의 데이터 저장 -> 클래스/객체
    // => 영구적인 사용 X
    //  => 영구적인 사용을 위한 방법 : 파일을 생성
    
    // 쿠키 : HTTP통신에서 사용자의 응답을 처리하고나서, 서버의 정보를
    //       저장하기위한 정보(사용자의 HDD저장)
   // C:\\Users\ITWILL\AppData\Local
   // \Google\Chrome\\User Data\Default\Cache
   
   // * 쿠키는 브라우저가 종료해도 생존시간이 지정되면 그동안 데이터 삭제 X
   // (HDD에 파일로 저장)
   
   // 세션 : 서버의 정보를 저장, 서버에 저장 , 보안상 중요한데이터
   // 쿠키 : 서버의 정보를 저장, 클라이언트에 저장(HDD) ,일반데이터 
   
   // 쿠키 : 이름,값,유효기간,도메인,경로... 구성됨
   //    - 이름은 알파벳과 숫자구성 (공백,특수문자 사용가능-인코딩필요)
   
   // 쿠키 생성 (서블릿 API사용)
   // Cookie cookie = new Cookie(이름,값);
   // 쿠키정보를 저장(response객체에 저장)
   // response.addCookie(쿠키객체);
   // 쿠키 사용(request 객체에 있는 쿠키 사용)
   // Cookie[] cookies = request.getCookies();
   // => 쿠키의 정보는 객체 배열의 형태로 사용
		   
   // * 객체 배열
   // Cookie[] cookies = new Cookie[3];

   // Cookie c = new Cookie(); X 3 (x)
   // Cookie c1;  (o)
   // Cookie c2;  (o)
   // Cookie c3;  (o)
   // => 객체 배열의 생성 == 객체 레퍼런스 생성
   // c1 = new Cookie();
   // cookies[0] = new Cookie();
   
   
   // 쿠키값 사용
   Cookie[] cookies = request.getCookies();
   
   String cName="";
   String cValue="";
   // 쿠키의 값이 있을때만 비교
   if(cookies != null){
	   // 생성된 쿠키의 값을 출력
	   for(int i=0;i<cookies.length;i++){
		   //쿠키값 이름이 'name'대상을 찾아서 값을 사용
		   if(cookies[i].getName().equals("name")){
			   cName = cookies[i].getName();
			   cValue = cookies[i].getValue();
		   }
	   } 
   }
  
  %>
  
  <h2> 클라이언트 </h2>
  <h3> 쿠키이름 : <%=cName %></h3>
  <h3> 쿠키값 : <%=cValue %></h3>
  
  <input type="button" value="쿠키값 생성"
        onclick="location.href='cookieSet.jsp';">
  
  <input type="button" value="쿠키값 삭제"
        onclick="location.href='cookieDel.jsp';">
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>