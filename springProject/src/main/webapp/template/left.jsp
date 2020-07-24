<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${memId==null }">
	<jsp:include page="../member/loginForm.jsp"></jsp:include>
</c:if>

<c:if test="${memId!=null }">
	<jsp:include page="../member/loginOk.jsp"></jsp:include>
</c:if>

<!-- 로그인 실패 -->
<c:if test="${memId == null && loginFail == 'fail'}"><!-- loginFail안에 변수fail이 들어 있냐 -->
	<jsp:include page="../member/loginFail.jsp"></jsp:include>
</c:if>