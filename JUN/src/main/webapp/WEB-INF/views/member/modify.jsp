<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/d183edbda6.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<script src="../resources/js/jquery-3.5.1.js"></script>
<script src="../resources/js/memModify.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
<script type="text/javascript">
	$
</script>
<title>회원정보 수정</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 text-center">
				<h2 style="margin: 30px 0;">회원정보수정</h2>
				<form action="/web/member/modify" method="post">
					<table class="table table-boardered">
						<tr>
							<th>이름</th>
							<td>${memberVO.username}</td>
						</tr>
						<tr>
							<th>원래 패스워드</th>
							<td><input type="password" class="form-control" name="userpw"
								placeholder="비밀번호는 영문만 넣어주세요"></td>
						</tr>
						<tr>
							<th>변경할 패스워드</th>
							<td><input type="password" class="form-control"
								name="pw" placeholder="비밀번호는 영문만 넣어주세요"></td>
						</tr>

						<tr>
							<th>이메일</th>
							<td><input type="email" class="form-control" name="email"
								value="${memberVO.email}"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" id="update" class="btn btn-primary"
								value="수정"> <input type="reset" class="btn btn-danger"
								value="취소">
								<input type="submit" id="delete" class="btn btn-primary"
								value="회원탈퇴">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>