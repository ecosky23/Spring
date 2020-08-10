<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <style type="text/css">
.viewBtn{
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px; 
	margin-right:-4px;
	border: 1px solid skyblue; 
	background-color: rgba(0,0,0,0);
	color: skyblue; 
	padding: 5px;
	width: 100px; 
	height:30px;
}
.viewBtn:hover{
	color: white;
	background-color: skyblue;
	border-radius: 12px;
}
</style>

<img src="../image/zoom.png" width="20" height="20" onclick="bigImage()" style="cursor:pointer;">
<img src="../image/zoom.png" width="20" height="20" id="bigImage" style="cursor:pointer;"><!-- AJax방식 -->
 


<table border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="3" width="600" style="table-layout:fixed;">
  <tr>
    <td rowspan="4" align="center" width="300" >
      <img src="../storage/${imageboardDTO.image1 }" id="imageView" width="250" height="250">
      
    </td>
    <td style="font-size:30px; font-weight: bold;">상품명 : ${imageboardDTO.imageName }</td>
  </tr>
    
  <tr>
     <td >개당 가격 : 
      <fmt:formatNumber value="${imageboardDTO.imagePrice }" pattern="#,###,###원" />
    </td>
  </tr>
  
  <tr>
    <td >재고수량 : 
      <fmt:formatNumber value="${imageboardDTO.imageQty }" pattern="#,###,###개" />
    </td>
  </tr>
  
  <tr>   
    <td >합계 : 
      <fmt:formatNumber value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }" pattern="#,###,###원" />
    </td>   
  </tr>
  
  <tr>
     <td colspan="2" height="100" valign="top"><pre>${imageboardDTO.imageContent }</pre></td>
  </tr>
</table>
<br>
<input type="button" class="viewBtn" value="목록" onclick="location.href='imageboardList.do?pg=${pg}'">



<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function bigImage(){
	let newWindow = window.open("","","width=500 height=500");
	
	let img = newWindow.document.createElement("img");
	
	img.setAttribute("src","http://localhost:8080/miniProject/storage/${imageboardDTO.image1 }");//<img src="${imageboardDTO.image1 }">지금 만든게 이것이다.
	img.setAttribute("width", "500");//<img src="${imageboardDTO.image1 } width='500'">지금 만든게 이것이다.
	img.setAttribute("height", "500");//<img src="${imageboardDTO.image1 } width='500' height='500' ">지금 만든게 이것이다.
	newWindow.document.body.appendChild(img);
}

$('#bigImage').click(function(){
	
	let url = $('#imageView').attr('src');
	window.open(url,'','width=500 height=500');
});

</script>