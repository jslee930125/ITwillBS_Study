<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$('#checkJson').click(function(){
			var member = { 
					id: "itwill", 
					name: "jung", 
					pass:"1234", 
					email:"itwill@itwill@com"
					};
			
			$.ajax({
				type :"post",
				url : '${contextPath}/test/info',
				contentType: "application/json",
				data : JSON.stringify(member),
				success : function(data){
					alert("성공");
					console.log(data);
				}
			});
		});	
		
		
	});

	</script>

</head>
<body>

	<h1>JsonTEST.JSP</h1>
	
	<input id="checkJson" type="button" value="정보 전달하기!">
	


</body>
</html>