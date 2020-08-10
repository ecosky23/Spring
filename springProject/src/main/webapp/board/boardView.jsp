<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="boardViewForm">
<input type="hidden" name="seq" id="seq" value="${seq }">
 <input type="hidden" name="pg" value="${pg }">
 
<h2>게시판</h2>
 <table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows" width="600" style="table-layout:fixed;" >
  <tr>
   <td colspan="3"><h3><span id="subjectSpan"></span></h3></td>
  </tr>
  
  <tr>
  		<td width="100">글번호 : <span id="seqSpan"></span></td>
		<td width="200">작성자 : <span id="idSpan"></span></td>
		<td width="100">조회수 : <span id="hitSpan"></span></td>	
  </tr>
 
  <tr>
   <td colspan="3" style="white-space: pre-wrap; word-break: break-all; overflow: auto;"
		valign=top height="200"><span id="contentSpan"></span>
		</td>
  </tr><%-- valign은 정렬방향 나오게 하는 것 --%>
 
 </table>
 </form>
 <input type="button" value="목록" onclick="location.href='boardList?pg=${pg}'"><%--pg값을 넘겨주면서 1페에지가 아니라 원래있던 페이지로 돌아간다. --%>
 <input type="button" value="답글 " onclick="mode(3)">

<span id="boardViewSpan">
<input type="button" value="글수정" onclick="mode(1)">
<input type="button" value="글삭제" onclick="mode(2)">
</span>

<script type="text/javascript">
function mode(num){
	if(num==1){//글수정
		document.boardViewForm.method = 'post';
		document.boardViewForm.action = 'boardModifyForm';
		document.boardViewForm.submit();
		
	}else if(num==2){//글삭제
		document.boardViewForm.method = 'post';
		document.boardViewForm.action = 'boardDelete';
		document.boardViewForm.submit();
		
	}else if(num==3){//답글
		document.boardViewForm.method = 'post';
		document.boardViewForm.action = 'boardReplyForm';
		document.boardViewForm.submit();
		
	}
}
</script>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springProject/board/getBoardView',
		data : 'seq='+$('#seq').val(),
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$('#subjectSpan').text(data.boardDTO.subject);
			$('#seqSpan').text(data.boardDTO.seq);
			$('#idSpan').text(data.boardDTO.id);
			$('#hitSpan').text(data.boardDTO.hit);
			$('#contentSpan').text(data.boardDTO.content);
			
			if(data.memId==data.boardDTO.id)
				$('#boardViewSpan').show();
			else
				$('#boardViewSpan').hide();
		},
		error: function(err){
			console.log(err);
		}
	});
});
</script>
