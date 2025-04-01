<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">  <!-- 부트스트랩 사용하려면 사용루트 넣어줘야함 --> 
<script src="/webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<button type="button" class="btn btn-info" onclick="test1();">fadeOut</button>
	<button type="button" class="btn btn-outline-success" onclick="test2();">fadeIn</button>
	
	<img id="img1" src="/img/img02.jpg">    <!-- static이 기본 -->
	
	<script type="text/javascript">
		function test1() {
			$("#img1").fadeOut(2000);
		}
		
		function test2() {
			$("#img1").fadeIn(2000);
		}
	</script>
	
	
</body>
</html>