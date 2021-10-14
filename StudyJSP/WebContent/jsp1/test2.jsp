<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  alert("안녕");
</script>
</head>
<body>
  <h1>WebContent/jsp1/test2.jsp</h1>
  
  <h2> ** jsp : 내장객체 (p177~)</h2>
  <%
     //var TV = new Object();
  %>
  
  <h3> javax.servlet 패키지 (8개) </h3>
    request : http 요청정보를 저장하는 객체<br>
    response : http 응답정보를 저장하는 객체 <br>
    session : 클라이언트 세션정보를 저장객체<br>
    page : 해당페이지 정보를 저장객체(서블릿객체)<br>
    pageContext : 페이지에 필요한 실행정보 저장 객체(프로젝트안에 있는 페이지)<br>
    out : 응답 페이지를 출력하는 객체<br>
    application : 애플리케이션의 컨텍스트(프로젝트)정보를 저장하는 객체<br>
    config : 페이지에 필요한 서블릿 정보를 저장객체(초기화정보)<br>
      
  <h3> java.lang 패키지(1개) </h3>
    exception : 예외 처리 객체<br>
  
   <hr>
   
   서버 도메인명 : <%=request.getServerName() %><br>
   서버 포트번호  : <%=request.getServerPort() %><br>
  URL : <%=request.getRequestURL() %><br> 
  URI : <%=request.getRequestURI() %><br> 
  프로토콜 : <%=request.getProtocol() %><br>
  클라이언트 호스트명 : <%=request.getRemoteHost() %><br>
  클라이언트 IP주소 : <%=request.getRemoteAddr() %><br>
  
  페이지 요청 방식(전송방식) : <%=request.getMethod() %><br>
  컨텍스트정보(프로젝트정보) : <%=request.getContextPath() %><br>
  물리적 경로 : <%=request.getRealPath("/") %><br>
  
  http 헤더 정보(user-agent): <%=request.getHeader("user-agent") %><br>
  http 헤더 정보(accept-language): <%=request.getHeader("accept-language") %><br>
  http 헤더 정보(host): <%=request.getHeader("host") %><br>
  http 헤더 정보(connection): <%=request.getHeader("connection") %><br>
  
  <hr>
  <%
    // response : 서버 -> 클라이언트 응답정보 저장
    //response.addHeader("Refresh", "3;url=/StudyJSP/jsp1/test2.jsp");
    // response.setHeader("해더속성", 값)
    // response.addCookie("쿠키값");
    // response.setContentType("속성");
    // response.sendRedirect("페이지");  
  %>
  
  <h2>session 객체</h2>
  session ID값 :  <%=session.getId() %><br>
  세션생성시간 : <%=session.getCreationTime() %><br>
  최종접속시간 : <%=session.getLastAccessedTime() %><br>
 세션 유지시간(1800초,30분) : <%=session.getMaxInactiveInterval() %><br>
 <%
   // 세션 유지시간 60분으로 변경
   session.setMaxInactiveInterval(3600); 
 %>
 세션 유지시간(3600초,60분) : <%=session.getMaxInactiveInterval() %><br>
 
 서버 정보 : <%=application.getServerInfo() %><br>
 서버의 물리적경로 : <%=application.getRealPath("/") %><br> 
  
 <%
  out.print("안녕하세요");
  out.print("안녕하세요2");
  out.print("안녕하세요3");
  out.print("안녕하세요4<br>");
 %> 
 버퍼 사이즈 : <%=out.getBufferSize() %><br>
 
 사용후 버퍼 사이즈 : <%=out.getRemaining() %><br> 
  
  
  
  
  
  
    

</body>
</html>