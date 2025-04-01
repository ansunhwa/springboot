<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectNameList1</title>
</head>
<body>
	<h1>JPQL_nativeQuery</h1>
	
	<c:forEach var="m" items="${members }">
		아이디 : ${m.id } <br>
		이름 : ${m.name } <br>
		이메일 : ${m.email } <br> <hr>
	</c:forEach>

</body>
</html>