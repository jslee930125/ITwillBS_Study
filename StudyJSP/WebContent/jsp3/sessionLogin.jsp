<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/jsp3/sessionLogin.jsp</h1>

	<h2>세션 로그인 페이지</h2>
	<%
		// 1. 로그인 페이지에서 사용자의 정보(id,pw) 입력
		// 2. 로그인 처리 페이지(sessionLoginPro.jsp) 이동
		// 3. 전달된 회원의 정보를 저장 / 본인정보와 비교 (itwill/1234)
		// 4. 로그인 체크 로직
		//  4-1. 아이디 O => 비밀번호 체크 / 아이디 X => 비회원 알림
		//  4-2. 비밀번호 O => 본인(로그인 성공)  /  비밀번호 X => 본인(비밀번호 오류)
		// 5. 로그인 성공시  페이지 이동(sessionMain.jsp)
		// 6. 로그인 성공 여부를 판단
	%>

    <fieldset>
      <form action="sessionLoginPro.jsp" method="post">
        아이디 : <input type="text" name="id"> <br>
        비밀번호 : <input type="password" name="pw"> <br>
        
       <input type="submit" value="로그인">
      </form>    
    </fieldset>








</body>
</html>