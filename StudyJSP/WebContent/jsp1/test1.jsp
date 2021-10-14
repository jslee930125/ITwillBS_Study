<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>WebContent/jsp1/test1.jsp</h1>
  
  <h2> JSP는 java와 html 코드를 한번에 사용 </h2>
  
  <!-- html 주석 : 브라우저에 아무런 영향 X -->
  <%-- JSP 주석 : 브라우저에 영향가능성이 있음 (내부적으로 무시)--%>
  <%
    // java 주석
    /* java주석 (여러줄) */
  %>
  <h2> 자바개념 정리 </h2>
  <%
    // java 코드 사용
    
    // 배열생성 -> "JAVA" "JSP" "HTML" "JAVASCRIT" 정보 저장
    // => 정보 출력(콘솔창에 출력)
    String[] arr = new String[4];
    arr[0] = "JAVA";
    arr[1] = "JSP";
    arr[2] = "HTML";
    arr[3] = "JAVASCRIT";
    
    for(int i=0;i<arr.length;i++){
    	System.out.println(arr[i]);
    }
    
    String[] arr2 = {"JAVA", "JSP", "HTML", "JAVASCRIT"};
    
    String[] arr3 = new String[]{"JAVA", "JSP", "HTML", "JAVASCRIT"};
    
    //String[] arr4[];
    // int arr[3];(x)
    
    for(int i=0;i<arr.length;i++){
    	// java코드 사용해서 html 화면에 출력
    	// out.print( html 코드 );
    	out.println("<h2>"+arr[i]+"</h2>");
    }
    
    for(int i=0;i<arr.length;i++){
  %>
      HTML코드 : <%=arr[i] %><br>    	
  <% 
     }
    // %태그로 만들어진 코드는 연결되어있음
  %>
  
  
  
  <hr>
  <table border="1">
   <tr>
     <td>번호</td>
     <td>이름</td>
   </tr>
   <%
   for(int i=0;i<arr.length;i++){
   %>
	   <tr>
	     <td><%=i+1 %></td>
	     <td><%=arr[i] %></td>
	   </tr>
   <% 
   }
   %>
 
  </table>
  
  
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>