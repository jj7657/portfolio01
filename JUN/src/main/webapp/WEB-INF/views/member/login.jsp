<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://kit.fontawesome.com/d183edbda6.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
</head>
<body>
	<div id="login" style="margin: 30px auto; width: 20rem;">
		<div class="card align-middle"
			style="width: 20rem; border-radius: 20px;">
			<div class="card-title" style="margin-top: 30px;">
				<h2 class="card-title text-center" style="color: #113366;">
					<a class="fas fa-cat" href="/web/"></a>로그인 폼
				</h2>
			</div>
			<div class="card-body">
				<form class="form-signin" action="/web/member/loginPost" method="POST"
					onSubmit="logincall();return false">
					<h5 class="form-signin-heading">로그인 정보를 입력하세요</h5>
					<label for="inputEmail" class="sr-only">Your ID</label> <input
						type="text" id="uid" class="form-control" name="userid"
						placeholder="Your ID" required autofocus> <BR> <label
						for="inputPassword" class="sr-only">Password</label> <input
						type="password" id="upw" class="form-control" name="userpw"
						placeholder="Password" required><br>
					<button id="btn-Yes" class="btn btn-lg btn-primary btn-block"
						type="submit">로 그 인</button>
				</form>
				아이디가 없으십니까? <a href="/web/member/join">join</a>
			</div>
		</div>
		<div class="modal"></div>
	</div>
	</div>

	<script src="../resources/js/jquery-3.5.1.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>