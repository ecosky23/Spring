$(document).ready(function(){
	
	$('#signUp').click(function(){
		
		$('#nameDiv').empty();//입력하면 한번 지우고 시작
		$('#idDiv').empty();//입력하면 한번 지우고 시작
		$('#pwDiv').empty();//입력하면 한번 지우고 시작
		$('#repwDiv').empty();//입력하면 한번 지우고 시작
		
		let name = $('#name').val();
		let id2 = $('#id2').val();
		let pwd2 = $('#pwd2').val();
		let repwd2 = $('#repwd2').val();
		let idDuplicationCheck = $('#idDuplicationCheck').val();
		
		
		if(name==""){ 
			$('#nameDiv').text("이름을 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#name').focus();
		}else if(id2==""){
			$('#idDiv').text("id를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#id2').focus();
		}else if(pwd2==""){
			$('#pwDiv').text("비밀번호를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#pwd2').focus();
		}else if(pwd2!=repwd2){
			$('#repwDiv').text("비밀번호가 같지 않습니다.").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#repwd2').focus();
		}else if(id2 != idDuplicationCheck){
			$('#div2').text("아이디 중복체크를 해주세요.").css('font-weight','bold').css('color','red').css('font-size','8pt');
		}else{
			$('form[name=writeForm]').submit();//form의 네임의 writeForm을 보내준다.
		}
	});
});




	$('#loginBtn').click(function(){
		$('div[class=idDiv]').empty();
		$('div[class=pwdDiv]').empty();
		let id = $('input[class=id]').val();
		let pwd = $('input[class=pwd]').val();
		if(id=="") $('div[class=idDiv]').text("아이디를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');//alert("아이디를 입력하세요");
		else if(pwd=="") $('div[class=pwdDiv]').text("비밀번호를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
		else {
			$.ajax({
				type: 'post',
				url:'/springProject/member/login',
				data: {'id' : $('#id').val(),
						'pwd' : $('#pwd').val()},
						dataType: 'text',
						success : function(data){
							if(data=='success'){
								location.href='/springProject/main/index';
							}else if(data=='fail'){
								$('#div').text('로그인 실패').css('color','red').css('font-size','10pt').css('font-weight','bold');
								
							}
						},
						error : function(e){
							console.log(e);
						}
			});
		}
			
	});




	
$('#id2').focusout(function(){//포커스가 빠져 나올때
	$('#idDiv').empty();
	let id = $('#id2').val();
	if(id == ''){
		$('#idDiv').text("id를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
		$('#id2').focus();
	}else{
		$.ajax({
			type: 'post',
			url: '/springProject/member/checkId',
			data: 'id='+id,
			dataType: 'text',
			success: function(data){
				if(data == 'exist'){
					$('#idDiv').text('사용 불가능')
					$('#idDiv').css('color','magenta')
					$('#idDiv').css('font-size','8pt')
					$('#idDiv').css('font-weight','bold')
					
				}else if(data=='non_exist'){
					$('#check').val($('#id').val());
					
					$('#idDiv').text('사용 가능')
					$('#idDiv').css('color','blue')
					$('#idDiv').css('font-size','8pt')
					$('#idDiv').css('font-weight','bold')
				}
			},
			error: function(e){
				console.log(e);
			}
		});
	}
});	
	

//우편번호
$('#checkPost').click(function(){
	window.open("/springProject/member/checkPost", "", "width=600 height=500 scrollbars=yes");
});

$('#checkPostBtn').click(function(){
	$.ajax({
		type: 'post',
		url: '/springProject/member/getZipecodeList',
		data: $('#checkPostForm').serialize(),
		
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#postTable tr:gt(2)').remove();
			
			$.each(data.list, function(index, items){
				let address = items.sido+' '
								+ items.sigungu+' '
								+ items.yubmyundong+' '
								+ items.ri+' '
								+ items.roadname+' '
								+ items.buildingname;
							
							address = address.replace(/null/g, '');
							
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.zipcode
					})).append($('<td/>',{
						colspan: '3'
						}).append($('<a/>',{
							href: '#',
							id: 'addressA',
							text: address
						}))
					).appendTo($('#postTable'));    
				});//each
				
				//a태그를 클릭했을 때
				$('a').click(function(){
					$('#zipcode', opener.document).val($(this).parent().prev().text());
					$('#addr1', opener.document).val($(this).text());
					$('#addr2', opener.document).focus();
					window.close();
				});
				
				
			
		},
		error: function(e){
			console.log(e);
		}
	});
});

function checkPostClose(zipcode, address) {// checkPost에서 zipcode와 address를  불러온다.

	
	opener.document.getElementById("zipcode").value = zipcode;// id값을 통해서 값을 넣어준다 
	opener.document.getElementById("addr1").value = address;// writeForm의 주소창에 가져온 주소를 넣어준다

	window.close();
	opener.document.getElementById("addr2").focus();
}


//회원정보수정
$('#modifyBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();
	
    if($('#name').val() == '') {
        $('#nameDiv').text('이름을 입력하세요')
        $('#nameDiv').css('color', 'red')
        $('#nameDiv').css('font-size', '8pt')
        $('#nameDiv').css('font-weight', 'bold')
        $('#name').focus();
        
    } else if($('#pwd').val() == '') {
    	$('#pwdDiv').text('비밀번호를 입력하세요')
        $('#pwdDiv').css('color', 'red')
        $('#pwdDiv').css('font-size', '8pt')
        $('#pwdDiv').css('font-weight', 'bold')
        $('#pwd').focus();
        
    } else if($('#pwd').val() != $('#repwd').val()){
    	$('#repwdDiv').text('비밀번호가 일치하지 않습니다')
        $('#repwdDiv').css('color', 'red')
        $('#repwdDiv').css('font-size', '8pt')
        $('#repwdDiv').css('font-weight', 'bold')
        $('#repwd').focus();
        
    }else{
    	$.ajax({
    		type: 'post',
    		url: '/springProject/member/modify',
    		data: $('#modifyForm').serialize(),
    		success: function(){
    			alert('회원 정보 수정 완료');
    			location.href='/springProject/main/index';
    		},
    		error: function(err){
    			console.log(err);
    		}
    	});
    } 
 });


