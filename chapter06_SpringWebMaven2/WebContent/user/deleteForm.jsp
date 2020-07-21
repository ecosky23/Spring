<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
삭제할 아이디 입력 
<input type="text" name="id" id="id">
<input type="button" value="검색" id="deleteBtn"><br>
<div id="menu">

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$('#deleteBtn').click(function(){
	
	$('#menu').empty();
	
	let id = $('#id').val();
	
	if(id == ''){
		$('#menu').text('먼저 아이디를 입력하세요').css('font-size','8pt').css('color','red');
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven2/user/checkId',
			data: 'id='+$('#id').val(),
			dataType: 'text',
			success: function(data){
				if(data == '사용 가능'){
					$('#menu').text('삭제할 아이디가 존재하지 않습니다.').css('font-size','8pt').css('color','red');
				}else{
					if(confirm('삭제할까요?')){
						$.ajax({
							type: 'post',
							url: '/chapter06_SpringWebMaven2/user/delete',
							data: {'id': $('#id').val()},
							success: function(){
								alert('회원정보를 삭제 하였습니다.');
								location.href='/chapter06_SpringWebMaven2/main/index';
							},
							error: function(){
								
							}
						});
					}
					
				}
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