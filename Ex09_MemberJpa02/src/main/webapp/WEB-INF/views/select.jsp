<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA #02 - Select</h1>
	<c:if test="${member != null }">
	아이디 : ${member.id } <br>
	이름 : ${member.name }  <br>
	날짜 : ${member.email }
	</c:if>
	<c:if test="${member == null }">
		존재하지 않습니다
	</c:if> 
		

</body>
</html>