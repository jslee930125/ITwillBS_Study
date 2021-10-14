<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		//setInterval("console.log('@@@@')",3);
// 		setInterval(function() {
// 			$('body').append($('img').first());			
// 		}, 2000);
	});
</script>

<script type="text/javascript">
   // setInterval(함수,시간) : 일정 시간마다, 특정 함수를 반복
	var auto = setInterval(function() {
		$('body').append($('img').first());			
	}, 2000);
	
   // clearInterval(객체 정보) : 인터벌 객체정보를 초기화
	clearInterval(auto);

</script>



</head>
<body>

   <img src="1.jpg">
   <img src="2.jpg">
   <img src="3.jpg">






</body>
</html>