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
	<form action="login_check" method="post">
		<c:if test="${param.error != null }">
			<p>
				login Error!<br>
				${error_massage}
			</p>
		</c:if>
		ID : <input name="username"> <br>
		PW : <input type="password" name="pwd"> <br>
		<input type="submit" value="로그인">	
	</form>
</body>
</html>








