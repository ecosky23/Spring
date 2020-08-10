<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
window.onload=function(){//이창이 떴을때 자동으로 실행
	alert("게시글 수정완료");
	location.href="/miniProject/board/boardList.do?pg=${pg}";
}
</script>
