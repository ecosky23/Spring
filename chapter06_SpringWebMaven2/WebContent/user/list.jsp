<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table id="table" border="1" >
 <tr>
  <th width="100">이름</th>
  <th width="100">아이디</th>
  <th width="100">비밀번호</th>
 </tr>


</table>
<form id="search">
<div class="search">
	<select name="searchOption" id="searchOption">
		<option value="">선택
		<option value="name">이름
		<option value="id">아이디
	</select>
	<input type="text" id="searchText" name="searchText">
	<button id="searchBtn">검색</button>
</div>
<div id="searchDiv"></div>
</form>



<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven2/user/getUserList',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				
				//alert(items.name+","+items.id+","+items.pwd);
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.pwd
				})).appendTo($('#table'));
			});
		}
	});
}); */


$('#searchBtn').click(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven2/user/searchUserList',
		data: $('#search').serialize(),
		dataType: 'json',
		success: function(data){
			if(data != null){
			//alert(JSON.stringify(data));
			$.each(data.list, function(index, items){
				
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.pwd
				})).appendTo($('#table'));
				
			});
			
			}else{
				$('#searchDiv').text('찾는 아이디가 없습니다.').css('font-size','8pt').css('color','red');
				return;
			}
		}
	});
});

</script>
</body>
</html>