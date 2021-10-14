<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/jsp2/scopeProAction.jsp</h1>
   
    <h2> 파라미터 정보 출력 </h2>
        아이디 : <%=request.getParameter("id") %><br>
     비밀번호 : <%=request.getParameter("pw") %><br><!-- 1234 -->
    <h2> 영역객체 정보 출력 </h2>
	  pageContext 객체 정보 (pc속성값을 출력): <%=pageContext.getAttribute("pc") %><br>
	  request 객체 정보: <%=request.getAttribute("rq") %> <br>
	  session 객체 정보: <%=session.getAttribute("se") %> <br>
	  application 객체 정보: <%=application.getAttribute("ap") %><br>
	   
   
   
   
   
   
   
   
</body>
</html>