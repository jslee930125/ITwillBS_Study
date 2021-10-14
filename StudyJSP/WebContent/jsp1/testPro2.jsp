<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/jsp1/testPro2.jsp</h1>

	<%
		// 한글처리-form태그 정보를 post 방식으로 전달시
		//         한글데이터가 깨짐(인코딩 오류)
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	%>

	이름 :
	<%=name%>, 나이 :
	<%=age%><br>
	<%
		// 사용자의 나이가 20살 이상 -"ㅇㅇㅇ님은 성인입니다."
		//             "   미만 -"ㅇㅇㅇ님은 미성년자입니다."

		// 1.java

		if (age >= 20) {
			out.println(name + "님은 성인 입니다.<br>");
		} else {
			out.println(name + "님은 미성년자 입니다.<br>");
		}
		// 2.java + html
		if (age >= 20) {
			%>
			님은 성인 입니다.<br>
			<%
		} else {
			%>
			님은 미성년자 입니다.<br>
			<%
		}
		
		// 3.표현식
			if (age >= 20) {
			%>
			<%=name %> 님은 성인 입니다.<br>
			<%
		} else {
			%>
			<%=name %> 님은 미성년자 입니다.<br>
			<%
		}
	%>














</body>
</html>