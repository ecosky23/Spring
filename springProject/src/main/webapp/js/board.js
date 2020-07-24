function checkBoardWriteForm(){    
	if(document.boardWriteForm.subject.value == ""){
        alert("제목을 입력하세요.");
        document.boardWriteForm.subject.focus();
    } else if(document.boardWriteForm.content.value == "") {
    	alert("내용을 입력하세요.");
    	document.boardWriteForm.content.focus();
    } else  {
    	document.boardWriteForm.submit();
    } 
 }
function checkBoardReplyForm(){    
	if(document.boardReplyForm.subject.value == ""){
        alert("제목을 입력하세요.");
        document.boardReplyForm.subject.focus();
    } else if(document.boardReplyForm.content.value == "") {
    	alert("내용을 입력하세요.");
    	document.boardReplyForm.content.focus();
    } else  {
    	document.boardReplyForm.submit();
    } 
}