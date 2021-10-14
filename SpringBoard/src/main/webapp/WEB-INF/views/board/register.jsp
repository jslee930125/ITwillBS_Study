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
					<h3 class="box-title">게시판 글쓰기</h3>
				</div>
				<!-- /.box-header -->
				
			<!-- form  시작 -->
				
			<form role="form" action="" method="post">
              <div class="box-body">
              
                <div class="form-group">
                  <label for="exampleInputEmail1">제목</label>
                  <input type="text" name="title" 
                  class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세요....">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputPassword1">글쓴이</label>
                  <input type="text" name="writer" 
                  class="form-control" id="exampleInputPassword1" placeholder="글쓴이를 입력하세요....">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputPassword1">내용</label>
                  <textarea class="form-control" name="content" 
                  rows="3" placeholder="내용을 입력하세요...." ></textarea> 
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">글쓰기</button>
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

    
<%@ include file="../include/footer.jsp" %>    
    
    
    
    
    