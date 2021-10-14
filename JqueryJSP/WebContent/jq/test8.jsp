<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
  h2{
    color: blue;
  }
  
  .high_0 { background: yellow; }
  .high_1 { background: orange; }
  .high_2 { background: purple; }
  .high_3 { background: pink; }
  .high_4 { background: silver; }
  

</style>


<script src="../js/jquery-3.6.0.min.js"></script>
<!-- Jquery 사용  -->
<script type="text/javascript">
	$(document).ready(function() {
		//addClass(클래스명) : 해당 요소에 클래스명을 설정
		
		// h2태그의 각 요소에 클래스명을 부여
		$('h2').each(function(index){
			//alert(index);
			// this레퍼런스 : 방문자가 사이트에 방문해서 이벤트 요소를 발생 시킬때마다,
			// 익명함수에 있는 실행문이 실행 => 이벤트가 발생한 요소를 가리킴.
			$(this).addClass("high_"+index);
		});
		
	});
</script>

</head>
<body>
	<h1>WebContent/jq/test8.jsp</h1>
	
<!-- 	<h2 class="high_0"> head-0 </h2>
	<h2 class="high_1"> head-1 </h2>
	<h2 class="high_2"> head-2 </h2>
	<h2 class="high_3"> head-3 </h2>
	<h2 class="high_4"> head-4 </h2> -->
	
	<h2> head-0 </h2>
	<h2> head-1 </h2>
	<h2> head-2 </h2>
	<h2> head-3 </h2>
	<h2> head-4 </h2>
	
	

</body>
</html>