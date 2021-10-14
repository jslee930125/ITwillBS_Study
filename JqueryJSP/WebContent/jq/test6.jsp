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
		// 요소의 앞,뒤에 요소를 추가
		// append() - 뒤쪽에 추가 , prepend() - 앞쪽에 추가
		
		$('body').append('추가하기!');
		$('body').prepend("앞 추가하기!");
		
		
		$('div').append(function(index){
			return index;
		});
		
		//$('tr').append('<tr><td>홍길동</td><td>010-1234-4564</td></tr>');
		$('table#tel').append('<tr><td>홍길동</td><td>010-1234-4564</td></tr>');
		
		// 배열
		var data =[
			{name:'홍길동',region:'부산'},
			{name:'김길동',region:'제주'},
			{name:'박길동',region:'서울'}			
		];
		
		console.log(data[0]);
		$('#region').append("<tr><td>"+data[0].name+"</td><td>"+data[0].region+"</td></tr>");
		
		// each() : 선택한 여러개의 요소를 각각 순차적으로 접근할때 사용하는 메서드
		// $(요소선택자).each(function(){});
		// $.each(요소선택자,function(){});
		
		// 배열의 모든 요소를 table에 추가 
		$.each(data,function(idx,item){
			//alert("!!");
			//alert(idx+" // "+item);
			$('table').append(function(){
				return "<tr><td>"+item.name+"</td><td>"+item.region+"</td></tr>";
			});
		});
		
		
	  // 배열의 값 (이름,지역)를 div안에 추가
// 	  $(data).each(function(index,item){
// 		  $('div').append(item.name+"//"+item.region);		  
// 	  });
	  
	  $('div').append(function(index){
		   var item = data[index];
		  return item.name+"//"+item.region;
	  });
	  
	  
		
		
		

	});	
</script>

</head>
<body>  
    <h1>WebContent/jq/test6.jsp</h1>
    
    1<br>
    2<br>
    3<br>
    <hr>
    
    <div> 제목 </div>
    <div> 제목 </div>
    <div> 제목 </div>
    
    <hr>
    <table border="1" id="tel">
      <tr>
        <td>이름</td>
        <td>전화번호</td>
      </tr>
    </table>
    
    <hr>
    <table border="1" id="region">
      <tr>
        <td>이름</td>
        <td>지역</td>
      </tr>
    </table>
    
    
    
    
    
    
    
    
    
    
</body>
</html>