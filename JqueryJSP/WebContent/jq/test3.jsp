<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		// 요소의 속성을 사용
		//$('h2').css('color','blue');
		
		// 요소의 속성값을 가져오는 기능
		var c = $('h2').css('color');
		alert("c : "+c);
		
		// h2 요소의 글자색 속성값을 red 변경
		$('h2').css('color','red');
		
		// 요소의 설정값을 변경(배열을 사용)
		var col = ['red','orange','yellow','green'];
		
		//$('h2').css('color',col[1]);
		$('h2').css('color',function(index){
			  //alert("index: "+index);
			  return col[index];
		});
		
		// 속성을 여러개 적용 (글자색,배경색 변경)
		$('h2').css({
			color : 'green',
			backgroundColor : 'yellow'
		});
		
		// 속성을 여러개 적용(글자색,배경색) + 배경색을 배열을 사용하여 처리
		$('h2').css({
			color : 'black',
			backgroundColor : function(index){
				return col[index];
			}			
		});
		
		
		
	});
</script>


</head>
<body>

	<h1>WebContent/jq/test3.jsp</h1>
	
	<h2>head-0</h2>
	<h2>head-1</h2>
	<h2>head-2</h2>
	<h2>head-3</h2>
	<h2>head-4</h2>
	<h2>head-5</h2>
	




</body>
</html>