<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="boardModifyForm">

<input type="hidden" name="seq" id="seq" value="${seq }"><%-- 히든을 통해 데이터를 넘기는 방법 히든으로 boardModify로 데이터가 넘어간다. --%>
<input type="hidden" name="pg" id="pg" value="${pg }">
<h3>글수정</h3>
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
	 <td align="center" width="70">제목</td>
	 <td><input type="text" name="subject" id="subject" size="55">
	 <div id="subjectDiv"></div>
	 </td>
	</tr>
	<tr>
	 <td align="center">내용</td>
	 <td><textarea rows="15" cols="60" name="content" id="content" style="resize:none;"></textarea>
	 <div id="contentDiv"></div>
	 </td>
	</tr>
	<tr>
	 <td colspan="2" align="center">
	 <input type="button" id="boardModifyBtn" value="글수정">
 	  <input type="reset" value="다시작성">
	 </td>
	 </tr>

</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springProject/board/getBoardView',
		data : 'seq='+$('#seq').val(),
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$('#subject').val(data.boardDTO.subject);
			$('#content').text(data.boardDTO.content);
		},
		error: function(err){
			console.log(err);
		}
	});
});

$('#boardModifyBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val() ==''){
		$('#subjectDiv').text('제목을 입력하세요');
        $('#subjectDiv').css('color', 'red');
        $('#subjectDiv').css('font-size', '8pt');
        $('#subjectDiv').css('font-weight', 'bold');
        
	}else if($('#content').val() ==''){
		$('#contentDiv').text('내용을 입력하세요');
        $('#contentDiv').css('color', 'red');
        $('#contentDiv').css('font-size', '8pt');
        $('#contentDiv').css('font-weight', 'bold');
        
	}else{
		
		$.ajax({
			type : 'post',
			url : '/springProject/board/boardModify',
			data : $('#boardModifyForm').serialize(),
			success : function(){
				alert("글수정 완료");
				location.href = '/springProject/board/boardList?pg='+$('#pg').val();
			},
			error: function(err){
				console.log(err);
			}
		});
		
	}
});	
</script>


</body>
</html>