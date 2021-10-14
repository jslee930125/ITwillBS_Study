<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/fileUpload/fileUploadPro.jsp</h1>
   <%
     // 1. 파일업로드
     // - 라이브러리 설치 cos.jar
     // - WebContent/upload폴더 (가상경로) 생성
     // - 업로드 파일 크기 제한 (10MB)
     
     int maxSize = 100 * 1024 * 1024;
   
     String realPath = request.getRealPath("/upload");
     //String realPath = "D:/fileup";
     System.out.println("realPath : "+realPath);
     
     // - 파일 업로드
     MultipartRequest multi = 
                      new MultipartRequest(
                    		  request,
                    		  realPath,
                    		  maxSize,
                    		  "UTF-8",
                    		  new DefaultFileRenamePolicy()
                    		  );
     // - 파일 업로드 완료
     System.out.println("파일 업로드 완료---------------------");

     // 2. 나머지 데이터처리
     
//      String name = request.getParameter("name");
//      String subject = request.getParameter("subject");
//      String file = request.getParameter("file");

     String name = multi.getParameter("name");
     String subject = multi.getParameter("subject");
    
     //String file = multi.getParameter("file");(x)
     String file = multi.getFilesystemName("file");
     String O_file = multi.getOriginalFileName("file");
   
   %>
   
   <h2>이름 : <%=name %></h2>
   <h2>제목 : <%=subject %></h2>
   <h2>파일명(서버에 저장된 이름) : <%=file %></h2>
   <h2>파일명(실제 파일 이름) : <%=O_file %></h2>
   
   
   <hr>
   <hr>
   
     <!-- 다운로드 
         : 브라우저에  파일의 파서가 포함 되어 있는 경우 다운로드형태 X
                     바로 실행되는 형태로 처리, 파서가 없는경우 다운로드 형태로 처리
       -->
    <h2>
         파일명(서버에 저장된 이름) :
       <a href="../upload/<%=file%>"><%=file %></a>
    </h2>
    
    <h2>
         다운로드 :
       <a href="filedown.jsp?file_name=<%=file%>"><%=file %></a>
    </h2>
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>