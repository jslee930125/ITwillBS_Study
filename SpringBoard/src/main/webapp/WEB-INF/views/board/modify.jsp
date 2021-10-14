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
					<h3 class="box-title">게시판 수정하기</h3>
				</div>
				<!-- /.box-header -->
				
			<!-- form  시작 -->
				
			<form role="form" action="" method="post">
			  <%-- <input type="hidden" name="bno" value="${uvo.bno }"> --%>
			  
              <div class="box-body">
              
                <div class="form-group">
                  <label for="exampleInputEmail1">글번호</label>
                  <input type="text" name="bno"  readonly
                  class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세요...." value="${uvo.bno }">
                </div>
              
                <div class="form-group">
                  <label for="exampleInputEmail1">제목</label>
                  <input type="text" name="title" 
                  class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세요...." value="${uvo.title }">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputPassword1">글쓴이</label>
                  <input type="text" name="writer" 
                  class="form-control" id="exampleInputPassword1" placeholder="글쓴이를 입력하세요...." value="${uvo.writer }">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputPassword1">내용</label>
                  <textarea class="form-control" name="content" 
                  rows="3" placeholder="내용을 입력하세요...." >${uvo.content }</textarea> 
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-danger">수정하기</button>
                <button type="submit" class="btn btn-primary">취소하기</button>
              </div>
            </form>
			
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

	<!-- 수정하기/취소하기 버튼 클릭 이벤트 -->
	<script>
	   $(document).ready(function(){
		   
		   // 폼태그 정보 가져오기
		   var frObj = $("form[role='form']");
		   
		   //  수정하기 - post 방식으로 이동
		   $(".btn-danger").on("click",function(){
			   frObj.submit();			   
		   });
		   
		   //  취소하기 - listAll 페이지 이동
		   $(".btn-primary").click(function(){
			   location.href="/board/listAll";
		   });
		   
		   
	   });
	
	</script>




<%@ include file="../include/footer.jsp" %>    
    
    
    
    
    