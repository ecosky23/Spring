$(document).ready(function(){
	$('#singUp').click(function(){
		
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
	
	
		let name = $('#name').val();
		let id = $('#id').val();
		let pwd = $('#pwd').val();
		
		if(name ==''){
			$('#nameDiv').text("이름을 입력하세요").css('color','red').css('font-size','8pt');
		}else if( id == ''){
			$('#idDiv').text("아이디을 입력하세요").css('color','red').css('font-size','8pt');
		}else if( pwd == '' ){
			$('#pwdDiv').text("비밀번호를 입력하세요").css('color','red').css('font-size','8pt');
		}else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven2/user/write',
				data: $('#writeForm').serialize(),
				
				success: function(data){
					alert('회원가입을 축하합니다.');
				},
				error: function(err){
				console.log(err);
			}
			});
		}
		
		
		
	});
});

$('#id').focusout(function(){
	$('#idDiv').empty();
	
	if($('#id').val()==''){
		$('#idDiv').text('필수 정보 입니다');
		$('#idDiv').css('font-size', '8pt');
		$('#idDiv').css('color', 'magenta');
		
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven2/user/checkId',
			data: 'id='+$('#id').val(),
			dataType: 'text',
			success: function(data){
				//alert(data);
			
			if(data =='사용 가능'){
			
				$('#idDiv').text(data);
				$('#idDiv').css('font-size','8pt');
				$('#idDiv').css('color','blue');
				
				}else{
				
				$('#idDiv').text(data);
				$('#idDiv').css('font-size','8pt');
				$('#idDiv').css('color','red');
				
				}
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});