<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
   // 영역객체를 생성(데이터-속성을 생성)
   pageContext.setAttribute("pc", "페이지 영역에 저장된 값!!!!");
   request.setAttribute("rq", "request 영역 정보 저정!!!");
   session.setAttribute("se", "session 영역 정보 저장!!!");
   application.setAttribute("ap", "application 영역정보 저장!!!");
  
  %>
  <h1>WebContent/jsp2/scopePro.jsp</h1>
  <%
    String id = request.getParameter("id");
  %>
    아이디 : <%=id%><br>
  
  <h2> 영역객체 정보 출력 </h2>
  pageContext 객체 정보 (pc속성값을 출력): <%=pageContext.getAttribute("pc") %><br>
  request 객체 정보: <%=request.getAttribute("rq") %> <br>
  session 객체 정보: <%=session.getAttribute("se") %> <br>
  application 객체 정보: <%=application.getAttribute("ap") %><br>
  
  <h2> 페이지 이동(+ 데이터) </h2>
  
  <h3>1) a태그 이동 (파라미터,session,application 정보 사용 O) </h3>
   
   <a href="scopeProAction.jsp?id=<%=id%>&pw=1234"> scopeProAction.jsp 페이지 이동 </a>
  
  <h3>2) javascript사용 이동 (파라미터,session,application 정보 사용 O) </h3>
   
   <script type="text/javascript">
      //alert("자바스크립트 사용 페이지 이동");
      //location.href='scopeProAction.jsp?id=<%=id%>&pw=1234'; 
   </script>  
  
  <h3>3) jsp사용 이동 (파라미터,session,application 정보 사용 O)</h3>
  <%
    //response.sendRedirect("scopeProAction.jsp?id="+id+"&pw=1234");  
  %>
  
  <!-- p222~ 액션태그 -->
  <h3>4) 액션태그사용 이동</h3>
  <!-- 
     forward 방식 이동(포워딩) : 페이지 이동시 request,response객체 정보를 저장후 이동
             * 페이지 이동시 주소의 변경 X, 화면의 변경 O
             pro.jsp  -> proAction.jsp
          주소 :   pro.jsp 
          화면 :   proAction.jsp 
   -->
  <jsp:forward page='scopeProAction.jsp'>
       <jsp:param value="0000" name="pw"/>
  </jsp:forward>
  
  <%
  //143~145
//     RequestDispatcher dis =
//       request.getRequestDispatcher("scopeProAction.jsp");
//     dis.forward(request, response);
  %>
  
  
  
  
  
  
  
  
  
</body>
</html>