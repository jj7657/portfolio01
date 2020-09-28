<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script src="https://kit.fontawesome.com/d183edbda6.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/headerMenu.css">
<script src="resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
if("${msg}"!=""){
	alert("${msg}")
}
</script>
</head>
<body>
	<div id="wrap">
	<%@ include file="/WEB-INF/views/header.jsp" %>
		<div id="page">
			시작화면 <br> <br> <br>
			<c:set value="${login.username}" var="name"></c:set>
			<c:if test="${name ne null}">
				${login.username}님 환영합니다
			</c:if>
			
			<form action="/web/reply/read/1">
				<input type="text" name="test" value="1">
				<input type="submit" value="test">
			</form>
			<input id="post" type="button" value="post">
			<div id="reply">
			</div>
			<script type="text/javascript">
				$("input[type='submit']").click(function(e) {
						e.preventDefault();
						$.getJSON("/web/reply/read/1",function(data){
							console.log(" "+data)
							var str = "";
							$(data.list).each(function(){
								str+="<ul><li>"+this.replyer+"</li><li>"+this.replytext+"</li></ul>"
							})
							$("#reply").append(str);
						})
				})
				
				$("#post").click(function(e) {
					e.preventDefault();
					$.post('/web/reply/create/1', null, function() {
					    console.log("보냄")
					}, 'json');
				})
			</script>
			
			
		</div>
	</div>
</body>
</html>