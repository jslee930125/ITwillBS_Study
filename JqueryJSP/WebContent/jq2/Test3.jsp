<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
  $(function(){
	  //textarea에 키보드 입력시 글자수를 카운트 해서 출력
	  $('textarea').keyup(function() {
	  	 //alert("111");
	  	 var tmp = $(this).val();
	  	 //alert(tmp.length);
	  	 // h3 태그에 값을 수정
	  	 $('h3').html(200-tmp.length);
	  	 
	  	 // 입력된 글자수가 200자 보다 크면은 글자수의 색상을 red 변경
	  	 // 200자 보다 적은경우 그대로 black 색으로 유지
	  	 
	  	 var result = 200-tmp.length;
	  	 
	  	 if(result >= 0){
	  		 // 200자 보다 적음
	  		 $('h3').css('color','black');	  		 
	  	 }else{
	  		 $('h3').css('color','red');	  		    
	  	 }
	  	 
	  });// keyup
	  
	  // 유효성체크
	 $('#fr').submit(function(){
		 
		 if($('#id').val() == ""){
			 alert('아이디 입력하시오!');
			 $('#id').focus();
			 // document.myfm.id.focus();  (자바스크립트)
			 return false;
		 }
		 
	 }); 
	  
	  
	  
	  
  });//ready
</script>

</head>
<body>
   <h1>WebContent/jq2/Test3.jsp</h1>
   
   <form action="" name="myfm" id="fr">
             아이디 : <input type="text" name="id" id="id"><br>
	   <h2> 글자수 200자 제한 입력 </h2>
	   <h3>200</h3> 
	   <textarea rows="5" cols="70"></textarea>
	   <input type="submit" value="전송">
   </form>
   
   
   
   
   
   
   
   

</body>
</html>