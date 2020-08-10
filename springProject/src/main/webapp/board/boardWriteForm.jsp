<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>글쓰기</h3>
<form name="boardWriteForm" method="post" action="/springProject/board/boardWrite">
<table border="1" cellspacing="0" cellpadding="3">
 <tr>
  <td width="100" align="center"> 제목 </td>
  <td><input type="text" size="50" name="subject" id="subject" placeholder="제목 입력">
  <div id="subjectDiv"></div>
  </td>
 </tr>
 
 <tr>
  <td width="100" align="center"> 내용 </td>
  <td><textarea name="content" id="content" rows="15" cols="50"  style="resize:none;" placeholder="내용을 입력"></textarea>
  <div id="contentDiv"></div>
  </td>
 </tr>

 <tr> 
  <td colspan="2" align="center">
   <input type="button" id="boardWriteBtn" value="글쓰기">
   <input type="reset" value="다시작성">
  </td>
 </tr>  
</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/board.js?var=1"></script>