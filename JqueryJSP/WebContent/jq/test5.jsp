<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Jquery 라이브러리 추가 -->
<script src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(function(){
	  // html() / text() - 출력된 요소의 값을 가져오는 동작
	  
	  // 해당요소의 해당하는 값 1개를 가져오기 
	  var htValue = $('h2').html();
	  alert(htValue);
	  // 해당요소의 해당하는 값을 모두 가져오기
	  var txValue = $('h2').text();
	  alert(txValue);
	  
	  
	  // h2 태그에 값을 변경
	  $('h2').html('Hello~');
	  $('h2').text('Jquery!');
	  
	  
	  // div 태그에 값을 변경 ( '<h3>html() 함수 호출</h3>',
	  //		  '<h3>text() 함수 호출</h3>')
	  
	 // $('div').html('<h3>html() 함수 호출</h3>');
	 // => 전달된 값을 요소를 적용해서 처리 (태그로 표현가능)
	 // $('div').text('<h3>text() 함수 호출</h3>');
	 // => 전달된 값을 새로운 택스트로 변경 (태그로 표현 X)
	 
	 // div의 값을  [ 기존값 **인덱스** ] 형태로 변경후 출력
// 	 $('div').html(function(idx,ohtml){
// 		 return ohtml+"**"+idx+"**";		 
// 	 });
	 
	 $('div').text(function(idx,ohtml){
		 return ohtml+"**"+idx+"**";		 
	 });
	  
  });
</script>

</head>
<body>
  <h1>WebContent/jq/test5.jsp</h1>
  
  <h2>head-0</h2>
  <h2>head-1</h2>
  <h2>head-2</h2>
  
  <hr>
  <div>00</div>
  <div>11</div>
  <div>22</div>
  
  
  
  
  
  
  
</body>
</html>