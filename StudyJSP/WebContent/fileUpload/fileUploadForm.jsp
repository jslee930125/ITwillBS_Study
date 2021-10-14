<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WebContent/fileUpload/fileUploadForm.jsp</h1>
   
   <h2> 파일 업로드 페이지 </h2>
   
   <form action="fileUploadPro.jsp" method="post"
         enctype="multipart/form-data">
     
        이름 : <input type="text" name="name"><br>
        글 제목 : <input type="text" name="subject"><br>
        파일 : <input type="file" name="file"><br>
        
     <input type="submit" value="파일 업로드">   
   
   </form>
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>