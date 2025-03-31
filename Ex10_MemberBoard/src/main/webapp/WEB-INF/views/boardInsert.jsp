<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 글 등록</h1>
	제목 : ${board.title } <Br>
	내용 : ${board.content } <Br>
	작성자 : ${board.member } <br>
	작성자 : ${board.member.getId() }<br>
</body>
</html>