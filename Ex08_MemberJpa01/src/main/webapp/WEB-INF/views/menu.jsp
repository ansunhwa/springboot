<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration: nene;
		color: black;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>Member JPA #01</h1>
	
	<a href="insert?username=user1">데이터 추가</a> <br><br>  <!-- ?username=내가 정한 이름으로 들어감 -->
	<a href="select?id=1">상세 조회</a> <br><br>   <!-- id가 1번인 걸 상세조회 할거임 -->
	<a href="selectAll">전체 조회</a> <br><br>
	<a href="delete?id=952">데이터 삭제</a> <br><br>   <!-- ?id=삭제하고 싶은id번호952 -->
	<a href="update?id=1&username="더조은">데이터 수정</a> <br><br>
</body>
</html>