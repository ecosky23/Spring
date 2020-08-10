<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- 비밀벊호 물어보기 -->    
 
 <input type="hidden" id="seq" value="${seq}">
    
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springProject/board/boardDelete',
		data : 'seq='+$('#seq').val(),
		dataType : 'json',
		success : function(data){
			
			location.href = '/springProject/board/boardList';
		},
		error: function(err){
			console.log(err);
		}
	});
});


</script>