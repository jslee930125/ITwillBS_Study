<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
	  // 이벤트 : 페이지에서 방문자가 행하는 모든 행동
	  // bind() : 이벤트 등록 함수
	  // $(요소).bind(이벤트1,이벤트2,....이벤트n,실행코드);
	  
	  $("#btn2").bind('click',function(){
		  alert('클릭 이벤트 발생(Jquery)');
	  });
	  
	  $('#btn2').click(function(){
		  alert('클릭 이벤트 발생(click)');
	  });
	  
	  // h2 태그 선택시(클릭)
	  $('h2').click(function(){
		  // + 기호 추가 (text(),html())
		  //alert("11");
		  //$('h2').text("+");
// // 		  $('h2').html(function(idx,ohtml){
// // 			  return ohtml+"+";
// // 		  });
		  $(this).html(function(idx,ohtml){
			  return ohtml+"+";
		  });
		  
	  });
	  
	  
	 /*  에러   
	 $(this).click(function(){
		  // + 기호 추가 (text(),html())
		  $(this).html(function(idx,ohtml){
			  return ohtml+"+";
		  });
		  
	  }); */
	  
	
	$('img').attr('border',5);
	  
// 	$('img').mouseover(function(){
// 		//alert("11");
// 		$(this).attr('src','2.jpg');
// 	});  
// 	$('img').mouseout(function(){
// 		$(this).attr('src','1.jpg');
// 	})  
	
	// 체이닝기법
	$('img').mouseover(function(){
		$(this).attr('src','2.jpg');
	}).mouseout(function(){
		$(this).attr('src','1.jpg');
	});
	
	  
	  
	  
  });

</script>

</head>
<body>
   <h1>WebContent/jq2/Test1.jsp</h1>
   
   <input type="button" value="클릭 이벤트" onclick=" alert('클릭js');">
   <input type="button" id="btn2" value="클릭 이벤트2" >
   
   <hr>
   <h1> h2태그 클릭 시 마다 "+" 기호를 추가 </h1>
   <h2> head-0 </h2>
   <h2> head-1 </h2>
   <h2> head-2 </h2>
   
   <hr>
   
   <h1> img에 마우스 올렸을때 2번 그림, 내렸을때 1번 그림 </h1>
   
   <img src="1.jpg">
   <img src="2.jpg">
   
   
   
   
   
   
   
   
   
</body>
</html>