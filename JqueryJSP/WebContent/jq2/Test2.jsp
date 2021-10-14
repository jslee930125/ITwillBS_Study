<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(function(){
	  
	  // a링크 클릭시 배경색을 설정
	  $('a').click(function(event){
		  //alert(event);
		  $(this).css('background-color','blue');
		  
		  // 이벤트 처리 X
		  //event.preventDefault(); // 페이지이동(하이퍼링크 X)
		  //console.log(event);
		  
		  //return false;		  
		  return;		  
	  });
	  // $('a').click(false);
		
	  
	  // h2 태그 클릭시 + 기호 추가
	  $('h2').click(function(){
		 $(this).html(function(idx,html){
			 return html+"+";
		 });
		 //return false; (x)
		 $(this).unbind(); // 이벤트 종료
		 
	  });
  });
</script>

</head>
<body>
    <h1><a href="http://www.naver.com">네이버 페이지</a></h1>
    
    <h2> 이벤트 시작/끝 </h2>
    
    
    
    
</body>
</html>