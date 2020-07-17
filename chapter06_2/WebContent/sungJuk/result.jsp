<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	
	**** ${sungJukDTO.name} 성적 ****<br>
	총점: ${sungJukDTO.kor + sungJukDTO.eng + sungJukDTO.math }<br>
	평균: ${(sungJukDTO.kor + sungJukDTO.eng + sungJukDTO.math)/3.0 }
</body>
</html>