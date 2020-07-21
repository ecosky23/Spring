<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
수정할 아이디 입력
<input type="text" name="id" id="id">
<input type="button" id="searchBtn" value="검색"><br>
<div id="resultDiv"></div>
<div id="modifyFormDiv">
<form id="modifyForm">
<table border="1">
 <tr>
   <td>이름</td> 
   <td><input type="text" name="name" id="modifyName"></td>
   <div id="nameDiv"></div>
 </tr>
 <tr>
   <td>아이디</td> 
   <td><input type="text" name="id" id="modifyId"></td>
   <div id="idDiv"></div>
 </tr>
 <tr>
   <td>비밀번호</td>
   <td><input type="text" name="pwd" id="modifyPwd"></td>
   <div id="pwdDiv"></div>
 </tr>
 <tr>
 <td colspan="2"><input type="button" value="수정" id="modifyBtn"></td>
</tr>
</table>
</form>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$('#searchBtn').click(function(){
	$('#resultDiv').empty();
	
	let id = $('#id').val();
	
	if(id ==''){
		$('#resultDiv').text('아이디를 입력하세요').css('font-size','8pt').css('color','red');
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven2/user/searchUser',
			data: 'id='+$('#id').val(),
			dataType: 'json',
			success: function(data){
				if(data.userDTO == null){
					$('#resultDiv').text('찾는 아이디가 없습니다.').css('font-size','8pt').css('color','red');
					return;
				}
				
				
				$('#modifyName').val(data.userDTO.name);
				$('#modifyId').val(data.userDTO.id);
				
				
			}
	
		});
	}
});

$('#modifyBtn').click(function(){
	
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#modifyName').val()==""){
		$('#nameDiv').text('수정 할 아이디를 입력하세요').css('font-size','8pt').css('color','red');
	}else if($('#modifyId').val()==""){
		$('#idDiv').text('수정 할 이름을 입력하세요').css('font-size','8pt').css('color','red');
	}else if($('#modifyPwd').val()==""){
		$('#pwdDiv').text('수정 할 비밀번호를 입력하세요').css('font-size','8pt').css('color','red');
		
	}else{
		
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven2/user/modify',
			data:  $('#modifyForm').serialize(),
			success: function(){
				alert("수정 완료");
			}
		});
	}
});


</script>
</body>
</html>