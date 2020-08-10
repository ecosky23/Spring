<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.productImage{
		width:50px;
		height:50px;
}
	#currentPaging {
	color: red; 
	text-decoration: underline;
	cursor:pointer;
	}
	#paging {
	color: black; 
	text-decoration: none;
	cursor:pointer;
	
	}
</style>
<form name="imageboardList" method="" action="/miniProject/imageboard/imageboardDelete.do">
<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
    	<tr>
			<th width='100' align=center>
			<input type="checkbox" id="all" class="checkAll" onclick="checkAll()"/>번호</th>
			<th width='100' align=center>이미지</th>
			<th width='300' align=center>상품명</th>
			<th width='100' align=center>단가</th>
			<th width='100' align=center>개수</th>
			<th width='100' align=center>합계</th>
		</tr>
    
    
<c:if test="${list != null}"><!-- 만약 넘어온 list값이 null이 아니면 if문을 실행해라 -->
<c:forEach var="imageboardDTO" items="${list}"><!-- list의 값을 imageboardDTO에 넣어서 게시판에 뿌려주기 -->
	<tr>
		<td align="center">
		<input type="checkbox" name="check" class="check" id="check" value="${imageboardDTO.seq }">${imageboardDTO.seq }</td>
		<!-- value에 값이 있어야 값이 체크 될때 값도 같이 넘어가게 된다. 그래서 고유의 값인 seq를 넣어준다. -->
		
		<td align="center">
		 <a href="/miniProject/imageboard/imageboardView.do?seq=${imageboardDTO.seq}&pg=${pg}">
		<img class="productImage" src="../storage/${imageboardDTO.image1 }"></td>
		</a>
		<!-- 경로가 ../storage/인 이유는 파일업로드 할경우 실제 저장되는 경로가 storage이기 때문에 저폴더에서 이미지를 가져온다. -->
		<td align="center">${imageboardDTO.imageName }</td>
		<td align="center">
		<fmt:formatNumber value="${imageboardDTO.imagePrice }" pattern="#,###원"/><!-- 형식 바꿔주는 것 -->
		</td>
		<td align="center">
		<fmt:formatNumber value="${imageboardDTO.imageQty }" pattern="#,###개"/>
		</td>
		<td align="center">
		<fmt:formatNumber value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }" pattern="#,###원"/>
		</td>
	</tr>
</c:forEach>

</c:if>    
</table>
</form>
<div style="border: 1px green solid; width: 900px;">
<c:if test="${sessionScope.memId=='admin'}">
<div style="float: left; border: 1px blue solid; width= 100px">
<input type="button" value="선택삭제" onclick="choiceDelete()">
</div>
</c:if>
<div style="border: 1px red solid; width: 800px; text-align: center; display: inline-block;">${imageboardPaging.pagingHTML }</div>
</div>

<script type="text/javascript">
function imageboardPaging(pg){
    location.href="imageboardList.do?pg="+pg;
}	
function checkAll(){
	
	//alert(document.getElementById("all").checked)
	//alert(document.getElementsByName("check").length) - 3개
	
	let check = document.getElementsByName("check");
	if(document.getElementById("all").checked){
		for(i=0; i<check.length; i++){
			check[i].checked = true;
		}
	}else{
		for(i=0; i<check.length; i++){
			check[i].checked = false;
		}
	}
}


/*function selectAll() {
        let checkAll = document.querySelector(".checkAll");
        let checkRow = document.querySelectorAll(".checkRow");
        if (checkAll.checked) {
          for (var i = 0; i < checkRow.length; i++) {
        	  checkRow[i].checked = true;
          }
        } else {
          for (var i = 0; i < checkRow.length; i++) {
        	  checkRow[i].checked = false;
          }
        }
}*/
/*function choiceDelete(){
	var sw= 0;
	
	var check = document.getElementsByName("check");
	var check2 = 0;
	for(i=0; i<check.length; i++){
		if(check[i].checked){
			check2[i] = 1;
		}
		if(check2 == 0){
			alert("삭제할 사용자를 입력해 주세요");
			return;
		}
		if(check2 == 1){
			alert("삭제 하시겠습니까?");
			//document.imageboardList.submit();
		}
	}
	
}*/
function choiceDelete(){
	
	let check = document.getElementsByName("check");
	let count = 0;
	for(i=0; i<check.length; i++){
		if(check[i].checked) count++;
	}
	
	if(count==0){ 
		alert("삭제할 제품을 선택하세요");
	}else{
		if(confirm("삭제하시겠습니까?")){
			document.imageboardList.submit();
		}
			
	} 
	
	/*var sw = 0;
	var seq = [];
	var check= document.getElementsByClassName("check");
	for(var i=0; i<check.length; i++){
		if(check[i].checked) {
			sw = 1;
			seq.push(check[i].value);
		}
	}
	
	if(sw == 0) alert("삭제할 항목을 선택하세요.");
	else {
		if(confirm("정말로 삭제하시겠습니까?")) location.href="/miniProject/imageboard/imageboardDelete.do?seq="+seq; //document.imageboardListForm.submit();
		else location.href="/miniProject/imageboard/imageboardList.do?pg=1";
		
	}*/
}
	

</script>
