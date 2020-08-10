<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3><img alt="" src="../image/mon.jpg" width="50" height="50" onclick="location.href='/springProject/main/index'" 
style="cursor:pointer;">Spring기반의 미니 프로젝트</h3>

<c:if test="${sessionScope.memId == null }">    
	<a href="/springProject/member/writeForm">회원가입</a>&emsp;
	<a href="../member/loginForm">로그인</a>&emsp;
</c:if>

<c:if test="${memId != null }">
	
	<a href="../board/boardWriteForm">글쓰기</a>&emsp;
	<c:if test="${memId == 'admin'}">
	<a href="../imageboard/imageboardWriteForm">이미지등록</a> &emsp;
	</c:if>
</c:if>

<a href="../board/boardList">목록</a>&emsp;
<a href="../imageboard/imageboardList?pg=1">이미지목록</a> &emsp;