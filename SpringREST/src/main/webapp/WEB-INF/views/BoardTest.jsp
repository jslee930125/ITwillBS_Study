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
		
		$("#btnGET").click(function(){
			
			$.ajax({
				url:"${contextPath}/boards/all",
				type: "get",
				success : function(data){
					// 리스트형태 받아와서 출력 가능 $('body').append(data);
					alert("게시판 글 조회 완료");
					console.log(data);
					
					$.each(data, function(idx,item){
						$('body').append(item.bno+"/" + item.title+"/"+item.content+"/"+item.writer+"<br>")
					});
					
				},
				error: function(){
					alert("에러발생");
				},
				complete:function(){
					alert("ajax 호출 끝");
				}
				
			}); // ajax 호출 끝
			
		}); // 버튼 클릭 1 끝
		
		$('#btnPOST').click(function(){
			
			// form 태그의 데이터 변경(대체)
			var board = {
					bno : "100",
					title : "subject100",
					writer : "ITWILL",
					contents : "안녕하세요"
			};
			
			// REST 컨트롤러로 정보 전달해서 글쓰기
			$.ajax({
				url : "${contextPath}/boards/",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(board),
				success : function(data){
					alert("결과 : " + data);	
				},
				error : function(){
					alert("에러 발생");
				}
			}); // ajax
		}); // 버튼클릭		
		
		$("#btnGET1").click(function(){
			// 100번글 불러오기
			$.ajax({
				type: "GET",
				url : "${contextPath}/boards/100",
				success : function(data){
					alert( " 글 정보 가져오기 성공! ");
					alert(data);
					console.log(data);
					
				} 
				
			});
			
		}); // 버튼클릭
		
		// 정보 수정
		$("#btnPUT").click(function(){
			
			// form 태그의 데이터 변경(대체)
			var board = {
				bno : "100",
				title : "update100",
				writer : "ITWILL",
				contents : "안녕하세요_update"
			};
			
			$.ajax({
				type : "PUT",
				url : "${contextPath}/boards/100",
				contentType: "application/json",
				data : JSON.stringify(board),
				success : function(){
					alert("수정성공");
				},
				error : function(err){
					alert("에러발생"+err);
				}
				
			});
			
			
		}); // 버튼 클릭
		
	});

</script>

</head>
<body>
	<h1>REST 게시판 만들기 (BoardTest.jsp)</h1>
	
	<input id="btnGET" type="button" value="정보 조회하기 ALL (GET-SELECT)"> <br>
	
	<input id="btnPOST" type="button" value="글쓰기(POST-Create)"><br>

	<input id="btnGET1" type="button" value="정보 조회하기 (글 1개)(GET-Create)"><br>
	
	<input id="btnPUT" type="button" value="정보 수정하기 (글 1개)(PUT-update)"><br>
	
	
</body>
</html>