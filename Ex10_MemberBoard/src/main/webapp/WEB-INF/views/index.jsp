<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="enroll" method="post">
		ID : <input name="id"> <br>
		PW : <input name="password" type="password"> <br>
		NAME : <input name="name"> <br>
		<input type="submit" value="회원가입">
	</form>
	<br><br>
	
	<form action="memUpdate" method="post">
		ID : <input name="id"> <br>
		PW : <input name="password" type="password"> <br>
		NAME : <input name="name"> <br>
		<input type="submit" value="회원수정">
	</form>
	<br><br>
	
	<form action="bInsert" method="post">
		TITLE : <input name="title"> <br>
		CONTENT : <input name="content"> <br>
		<input type="submit" value="게시글 작성">
	</form>
	<br><br>
	
	
	
</body>
</html>