<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 오류 페이지 정의  -->
<%@ page errorPage="accounttransfer_error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>다이어리 목록</title>

	<link rel="stylesheet" href="css/diarylist.css" type="text/css" media="screen" />

<%-- CDN - Content Delivery Network

    <script src=" http://code.jquery.com/jquery-3.3.1.min.js"></script>
--%> 
    <script src=" js/jquery.js"></script>
    
    <script type="text/javascript" src="js/diary_view.js"></script>

</head>

<body>
	<div align="center">
	<H2>다이어리 등록</H2>
	<HR>

	<!-- 계좌이체 등록용 -->
	<form name="form1" id="form1" method="post" action="">
		<input type="hidden" id="id" name="id" value=${id}>
		
		
		<table id=table1>
			<tr>
				<th>제목</th>
				<td><input type=text size=8 id=title name="title"  value=""></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><input type=date size=10 id=writeDate name="writeDate"  value=""></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type=text id="content" size=100 id=content name="content"  value=""></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
					<input type="button" id="insert" value="입력" >
					<input type="button" id="update" value="수정" >
					<input type="button" id="delete" value="삭제" >
					<input type="button" id="back" value="돌아가기" >
				</td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>