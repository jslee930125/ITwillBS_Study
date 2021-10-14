<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 ul{
   list-style: none;
 }

</style>


<script src="../js/jquery-3.6.0.js"></script>
<script src="../js/jquery.innerfade.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
	  
	  //$('#news').innerfade('animationtype','slide');
	  $('#news').innerfade({
		  animationtype : 'fade',
		  speed : 'slow',
		  type : 'random'
	  });
	  
  });
</script>


</head>
<body>
  <ul id="news"> 
       <li>
          <img src="ggbg.gif">
       </li>
       <li>
       	  <img src="km.jpg">
       </li>
       <li>
       	  <img src="rt_arch.jpg">
       </li>
       <li>
       	  <img src="tuev.jpg">
       </li>
        <li>
       	  <img src="whizzkids.gif">
       </li>
  </ul>
 

</body>
</html>