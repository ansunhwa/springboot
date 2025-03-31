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
	<h1>Member JPA #02</h1>
	
	<a href="insert">데이터 추가</a> <br><br>  <!-- ?username=내가 정한 이름으로 들어감 -->
	<a href=/selectAll>전체 조회</a> <br><br>  <!-- /넣으면 ""안써도 됨 -->
	<a href=/select?id=2>개별 조회</a> <br><br>   <!-- Long타입 -->
	
	<br><Br><hr>
	
	<a href=/selectByName?name=김파랑>개별 조회 - ByName</a> <br><br>  <!-- String타입 -->
	<a href=/selectByEmail?email=test3@test.com>개별 조회 - ByEmail</a> <br><br>
	
	<a href=/selectByNameLike?name=김>개별 조회 - ByName Like</a> <br><br>
	<a href=/selectByNameLikeNameDesc?name=김>개별 조회 - ByName LikeName Desc</a> <br><br>
	<a href=/selectByNameLikeNameSort?name=김>개별 조회 - ByName LikeName Sort</a> <br><br>
	

</body>
</html>