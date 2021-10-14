<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Jquery 라이브러리 추가 -->
<script src="../js/jquery-3.6.0.min.js"></script>
<!-- Jquery 사용  -->
<script type="text/javascript">
   $(document).ready(function(){
	   alert("제이쿼리 실행1! ");
   });
   
   $(function(){
	   alert("제이쿼리 실행2! ");
   });
   
   jQuery(document).ready(function(){
	   alert("제이쿼리 실행3! ");
   });
   
   jQuery(function(){
	   alert("제이쿼리 실행4! ");
   });
   
   
   
   
</script>

<!-- <script type="text/javascript">
  alert("test");

</script> -->

</head>
<body>
    <h1>WebContent/jq/test1.jsp</h1>
    
    
    
    
    
    
    
    
    
    
    
    
    
</body>
</html>