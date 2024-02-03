<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 오류 페이지 정의  -->
<%@ page errorPage="diary_error.jsp" %>

<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 --%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Diary</title>

	<link rel="stylesheet" href="css/diarylist.css" type="text/css" media="screen" />

<%-- CDN - Content Delivery Network

    <script src=" http://code.jquery.com/jquery-3.3.1.min.js"></script>
--%> 
    <script src=" js/jquery.js"></script>
    
	<script type="text/javascript" src="js/diary_list.js"></script>


</head>

<body>
	<div align=center>
	<H2>일기장</H2>
	<HR>

	<!-- 계좌이체 목록 조회폼 -->
	<form name="form1" id="form1" method="post" action="">
		<input type="hidden" id = "id" name="id" value="">
	
		<table id=table1 border=1>
			<thead>
				<tr>
					<td colspan=9 >
	    				<input type="button" align="left" value="제목" >
	    				<input type="text" id="searchTitleName" name="searchTitleName" align="left">
	    				<!-- keyup 이벤트 사용에 따른 엔터키 방지용 보이지 않는 input text -->
	    				<input type="text" style="display:none">
	    				<input type="button" id="add" align=right value="추가">
	    				<input type="button" id="list" align=right value="조회">
	    				
					</td>
				</tr>
				<tr>
					<th>순서</th>
					<th>제목</th>
					<th>작성일자</th>
				</tr>
			</thead>
			
			<tbody id=ajaxTable>
			</tbody>
			
		</table>
	</form>
	
	</div>
</body>

</html>