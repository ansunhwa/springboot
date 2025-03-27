<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome : Member  <br><br>
	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p>log in </p>
	</c:if>
	USER ID : ${ pageContext.request.userPrincipal.name}<br><br>
	
	<!-- userPrincipal : 기본적인 모든 정보들이 들어옴 -->
	user info : ${pageContext.request.userPrincipal}<br><br>
	
	<a href="/logout">logout</a>   <!-- 알아서 세션을 끊어줌 -->
</body>
</html>