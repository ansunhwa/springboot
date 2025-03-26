<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> --%>
     <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상 세 보 기</h1>
	작성자 : ${ board.writer } <br>
	제목 : ${ board.title } <br>
	내용 : ${ board.content } <br> <br>
	<hr>
	
	<a href="list"><button type="button" class="btn btn-outline-danger"> 목록보기</button></a>

</body>
</html>