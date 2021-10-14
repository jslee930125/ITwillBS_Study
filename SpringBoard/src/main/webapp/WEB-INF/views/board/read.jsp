<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>


<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판 본문페이지</h3>
				</div>
				<!-- /.box-header -->
				
			<!-- form  수정/삭제 처리 -->
			<form role="form" action="" method="post">
			  <!-- 글 번호를 저장 -->			  
			  <input type="hidden" name="bno" value="${vo.bno }" >
			</form>
			
              <div class="box-body">
              
                <div class="form-group">
                  <label for="exampleInputEmail1">제목</label>
                  <input type="text" name="title" 
                  class="form-control" id="exampleInputEmail1" value="${vo.title }" readonly>
                </div>
                
                <div class="form-group">
                  <label for="exampleInputPassword1">글쓴이</label>
                  <input type="text" name="writer" 
                  class="form-control" id="exampleInputPassword1" value="${vo.writer }" readonly>
                </div>
                
                <div class="form-group">
                  <label for="exampleInputPassword1">내용</label>
                  <textarea class="form-control" name="content" 
                  rows="3" readonly >${vo.content }</textarea> 
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-warning">수정하기</button>
                <button type="submit" class="btn btn-danger">삭제하기</button>
                <button type="submit" class="btn btn-primary">목록으로</button>
              </div>
           
			
			<!-- form  끝 -->
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

	 <!-- 제이쿼리 라이브러리 추가는 header.jsp 페이지에서 선언 -->
	 <script type="text/javascript">
	    $(document).ready(function(){
	    	// 버튼 클릭시 이벤트 처리
	    	
	    	// form태그 정보 가져오기
	    	var fr = $("form[role='form']"); //id값 없이 속성값으로 접근
	    	//$("#fr"); //id값이 있을경우
	    	//alert(fr);
	    	console.log(fr);
	    	
	    	// 1) 수정하기
	    	$(".btn-warning").click(function(){
	    		alert("수정 버튼 클릭! ");
	    		// 폼태그의 정보(글번호)를 저장해서 
	    		// 글 수정 페이지로 이동(submit)
	    		// /board/modify
	    		
	    		fr.attr("action","/board/modify");
	    		fr.attr("method","get");
	    		fr.submit();	    		
	    		
	    	});
	    	
	    	// 2) 삭제하기
	    	$(".btn-danger").click(function(){
	    		fr.attr("action","/board/remove");
	    		fr.submit();	    		
	    	});	    	
	    	
	    	// 3) 목록으로
	    	
	    	$(".btn-primary").click(function(){
	    		alert(" 목록으로 버튼 클릭! ");
	    		location.href = "/board/listAll"; 
	    	});	    	
	    	
	    });	    
	 </script>




    
<%@ include file="../include/footer.jsp" %>    
    
    
    
    
    