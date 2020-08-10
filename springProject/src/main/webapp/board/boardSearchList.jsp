<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
	#currentPaging {
	color: red; 
	text-decoration: underline;
	cursor:pointer;
	}
	#paging {
	color: black; 
	text-decoration: none;
	cursor:pointer;
	border: 1px red solid;
	}
</style>
<h3>게시판</h3>
<c:if test="${list != null }">
<table border="1" cellspacing="0" cellpadding="3" frame="hsides" rules="rows">
 <tr>
	<th width="100">글번호</th>
	<th width="200">제목</th>
	<th width="150">작성자</th>
	<th width="100">작성일</th>
	<th width="100">조회수</th>				
 </tr> 

<form name="boardList" mothod="post" action="BoardSearch.do">
 <c:forEach var="boardDTO" items="${list }">
  <tr>					
	<%-- <c:set var="logtime" value="${ft.format(boardDTO.getLogtime()).equals(currentTime)
		? today.format(boardDTO.getLogtime())
		: past.format(boardDTO.getLogtime())}" /> --%>
		
	<td width="100" align="center">${boardDTO.seq }</td>
	<td width="200">
	 <a href="javascript:void(0)" onclick="checkLoginMem('${boardDTO.seq }','${pg }')" 
	    style="cursor:hand; text-decoration: none;">${boardDTO.subject }
	 </a>
	</td>
	<td width="150" align="center">${boardDTO.id }</td>
	
	<td width="100" align="center">
	
	 <c:if test="${today == boardDTO.logtime}">
	  <fmt:formatDate value="${boardDTO.logtime }" pattern="HH:mm:ss"/>
	 </c:if>
     <c:if test="${today != boardDTO.logtime}">
      <fmt:formatDate value="${boardDTO.logtime }" pattern="yyyy.MM.dd"/>
     </c:if>
	</td>
	<td width="100" align="center">${boardDTO.hit }</td>			
  </tr>
 </c:forEach>
</table>
</c:if>
<!-- 여기추가 -->

<div style=" width:650px; text-align: center;">${boardPaging.pagingHTML }</div>
<select name="searchOption" style="width: 50px;">
<option value="제목">제목</option>
<option value="작성자">작성자</option>
</select>&emsp;
<input type="text" name="keyword" size="30">&emsp;
<input type="submit" value="검색"> 
</form>
<script type="text/javascript">
function checkLoginMem(seq, pg){
   if('${memId}'=='') {
	   alert("로그인을 먼저 하세요");
	   location.href="../main/index.do";
   
   }else 
	   location.href="boardView.do?seq="+seq+"&pg="+pg;
}	

function boardPaging(pg){
	location.href="boardList.do?pg="+pg;
}
</script>