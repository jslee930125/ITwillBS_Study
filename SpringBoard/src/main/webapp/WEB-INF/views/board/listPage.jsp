<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

<%@ include file="../include/header.jsp" %>


   <h1>WEB-INF/views/board/listPage.jsp</h1>
   <!-- 글번호,제목,글쓴이,날짜,조회수 -->
   <h2>result : ${result }</h2>
   <%-- ${boardList } --%>
   
	  <table class="table table-bordered">
	       <tbody>
	         <tr>
	           <th style="width: 10px">BNO</th>
	           <th>TITLE</th>
	           <th>WRITER</th>
	           <th>REGDATE</th>
	           <th style="width: 40px">View</th>
	         </tr>
	         
	         <c:forEach var="vo" items="${boardList }">
	            <tr>
		           <td style="width: 10px">${vo.bno }</td>
		           <td>
		           		<a href="/board/read?bno=${vo.bno }">${vo.title }</a>
		           </td>
		           
		           <td>${vo.writer }</td>
		           <td>
		              <fmt:formatDate pattern="yy-MM-dd" value="${vo.regdate }"/>		 
		           </td>
		           <td style="width: 40px">
		              <span class="badge bg-light-blue">${vo.viewcnt}</span>
		           </td>
		         </tr>
	         </c:forEach>
	         
	       </tbody>
	   </table>
	   
	   <div class="text-center">
	      <ul class="pagination">
	         <!-- 이전 -->
	         <c:if test="${pm.prev }">
	           <li> 
	           	 <a href="listPage?pageStart=${pm.startPage-1 }"> &laquo; </a> 
	           </li>
	         </c:if>
	         
	         <!-- 페이지 번호 -->
	         <c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="idx">
	            <li ${pm.cri.pageStart == idx? 'class = active':'' }>
	            	<a href="listPage?pageStart=${idx }">${idx }</a>
	            </li>
	         </c:forEach>
	         
	         <!-- 다음 -->
	         <c:if test="${pm.next }">
	             <li> 
	               <a href="listPage?pageStart=${pm.endPage+1 }"> &raquo;</a> 
	              </li>
	         </c:if>
	         
	         	
	      </ul>	     
	   </div>
	
	
	   
	<script type="text/javascript">
        // 페이지 실행 정보(result)가 있는지 없는지에 따라서 확인메세지 
        //alert('result :'+'${result}');
        // java -> js 페이지 이동
        
        // 전달된 데이터를 저장 (el표현식의 값)
        var result = '${result}';
        //alert(result);
        // 비교후 메세지 출력
        if(result == 'success'){
        	alert(" 글쓰기 정상처리 완료! ");
        }
        
	</script>   

              
 <%@ include file="../include/footer.jsp" %>             
              
              