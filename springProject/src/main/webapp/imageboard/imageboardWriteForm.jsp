<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="imageboardWriteForm" id="imageboardWriteForm" method="post" enctype="multipart/form-data" action="/springProject/imageboard/imageboardWrite">
<!--파일을 올리기 위해서는 cos.jar짜르 파일을 lib에 넣어줘야 한다. method="post" enctype="multipart/form-data"이방식은 이미지나 파일을 서버로 전송할때
주로 사용 도니다. 무조건 post방식으로 multpart 형식으로 파일을 올리고 내리겠다  -->
<!-- 실제 저장 경로 D:\java_se\java_ee\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\miniProject\storage 
파일을 올리는 순간 여기에 저장된다.
가상폴더에는 저장되지 않는다.-->
	<table border="3" cellspacing="0" cellpadding="5">
		<tr>
			<th width="100">상품코드</th>
			<td><input type="text" name="imageId" id="imageId" value="img_">
			<div id="imageIdDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>상품명</th>
			<td><input type="text" name="imageName" id="imageName" placeholder="상품명 입력" size="35">
			<div id="imageNameDiv"></div>
			</td>
		</tr>

		<tr>
			<th>단가</th>
			<td><input type="number" name="imagePrice" id="imagePrice" placeholder="단가 입력">
			<div id="imagePriceDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>갯수</th>
			<td><input type="number" name="imageQty" id="imageQty" placeholder="갯수 입력">
			<div id="imageQtyDiv"></div>
			</td>
		</tr>

		<tr>
			<th>내용</th>
			<td><textarea name="imageContent" placeholder="내용입력" id="imageContent" cols="50" rows="15"></textarea>
			<div id="imageContentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan=2>
			<input type="file" name="img" id="image1" size="50">
			<div id="image1Div"></div>
			</td><!-- 파일업로드를 위해서는 타입을 file로 둬야 한다. -->
		</tr>
		
		<tr>
			<td colspan=2 align="center">
				<input type="button" value="이미지 등록" id="imageboardWriteBtn">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$('#imageboardWriteBtn').click(function(){
	$('#imageIdDiv').empty();
	$('#imageNameDiv').empty();
	$('#imagePriceDiv').empty();
	$('#imageQtyDiv').empty();
	$('#imageContentDiv').empty();
	$('#image1Div').empty();
	
	if($('#imageId').val()=='img_' || $('#imageId').val()==''){
		$('#imageIdDiv').text('상품코드를 입력하세요');
		$('#imageIdDiv').css('color','red');
		$('#imageIdDiv').css('font-size','8pt');
		$('#imageIdDiv').css('font-weight','bold');
		
	}else if($('#imageName').val()==''){
		$('#imageNameDiv').text('상품명을 입력하세요');
		$('#imageNameDiv').css('color','red');
		$('#imageNameDiv').css('font-size','8pt');
		$('#imageNameDiv').css('font-weight','bold');
	
	}else if($('#imagePrice').val()==''){
		$('#imagePriceDiv').text('단가를 입력하세요');
		$('#imagePriceDiv').css('color','red');
		$('#imagePriceDiv').css('font-size','8pt');
		$('#imagePriceDiv').css('font-weight','bold');
		
	}else if($('#imageQty').val() == '' ){
		$('#imageQtyDiv').text('개수를 입력하세요');
		$('#imageQtyDiv').css('color','red');
		$('#imageQtyDiv').css('font-size','8pt');
		$('#imageQtyDiv').css('font-weight','bold');
		
	}else if($('#imageContent').val() == ''){
		$('#imageContentDiv').text('내용을 입력하세요');
		$('#imageContentDiv').css('color','red');
		$('#imageContentDiv').css('font-size','8pt');
		$('#imageContentDiv').css('font-weight','bold');
	}else{
		document.imageboardWriteForm.submit();
		
	}
	
	
	
});

</script>

</body>

</html>