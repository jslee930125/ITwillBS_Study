<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/jsp1/testPro3.jsp</h1>
  <%
    // 한글데이터 처리 
    request.setCharacterEncoding("UTF-8");
    // 전달정보 저장(파라미터 저장)
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
//     String hobby1 = request.getParameter("hobby");
//     String hobby2 = request.getParameter("hobby");
//     String hobby3 = request.getParameter("hobby");
    

    //String[] arr = new String[3];
    //String[] arr = {"1","2","3"};
    // request.getParameterValues("파라미터명");
    // => String[]리턴 하는 메서드
    String[] hobArr = request.getParameterValues("hobby");
    String subject = request.getParameter("subject");
  %>
  
  이름 : <%=name %><br>
  성별 : <%=gender %><br>
<%--   취미 : <%=hobby1 %><br>
  취미 : <%=hobby2 %><br>
  취미 : <%=hobby3 %><br> --%>
  
 <%--  취미 : <%=hobArr[0] %><br>
  취미 : <%=hobArr[1] %><br>
  취미 : <%=hobArr[2] %><br>  --%>
  
  <%
   if(hobArr != null){
    // hobArr 배열의 크기만큼 해당요소 출력
    for(int i=0;i<hobArr.length;i++){
    	%>
    	  취미 : <%=hobArr[i] %><br> 
    	<%
     }
   }
  %>
  
  제목 : <%=subject %><br>

  
  
  
  
  
  
  
  
  
  
  


</body>
</html>