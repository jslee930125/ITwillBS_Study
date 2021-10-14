<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WebContent/member/updateForm.jsp</h1>

	<h2>회원정보 수정</h2>
	<%
		// 로그인 세션 제어
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("./MemberLogin.me");
		}
		
		// 회원정보 저장(request 영역)
		//request.setAttribute("mdto", mdto);
		
		MemberDTO mdto = (MemberDTO)request.getAttribute("mdto");
		
		// 만약에 성별의 정보가 없으면 기본값 하나를 설정
		if(mdto.getGender() == null){
			mdto.setGender("남자");
		}
		
	%>

	<fieldset>
		<form action="./MemberUpdateProAction.me" method="post">
		       아이디 : <input type="text" name="id" value="<%=mdto.getId()%>" readonly><br>
			 비밀번호 : <input	type="password" name="pass" 
			           placeholder="수정전 비밀번호를 입력하시오."
			 ><br>
		         이름 : <input type="text" name="name" value="<%=mdto.getName()%>"><br>
		         나이 : <input type="text" name="age" value="<%=mdto.getAge()%>"><br>
		         성별 : <input type="radio" name="gender"	value="남자"
		           <%if(mdto.getGender().equals("남자")){ %>
		           		checked
		           <%} %>
		           > 남
		          <input type="radio" name="gender" value="여자" 
		           <%if(mdto.getGender().equals("여자")){ %>
		           		checked
		           <%} %>
		          > 여 <br> 
			이메일 : <input type="text" name="email" value="<%=mdto.getEmail()%>"><br>
			<hr>
			<input type="submit" value="수정하기">
		</form>
	</fieldset>















</body>
</html>