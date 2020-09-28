<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/d183edbda6.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/headerMenu.css">
<link rel="stylesheet" href="../resources/css/boardWrite.css">
<script src="../resources/js/headerMenu.js"></script>
<script src="../resources/js/boardWrite.js"></script>
<title>글쓰기</title>
</head>
<body>
	<div id="wrap">
	<%@ include file="/WEB-INF/views/header.jsp" %>
		<div id="board_wrap">
			<div id="board">
				<h2>글쓰기</h2>
				<form id="form" action="/web/board/write" method="post">
					<table>
						<tr>
							<td>제목</td>
							<td><input id="titleinput" name="title" type="text"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<button type="button" onclick="document.execCommand('bold')">
									<b>B</b>
								</button>
								<button type="button" onclick="document.execCommand('Italic')">
									<i class="italic">i</i>
								</button>
								<button type="button"
									onclick="document.execCommand('Underline')">
									<u>U</u>
								</button>
								<button type="button"
									onclick="document.execCommand('StrikeThrough')">
									<strike>T</strike>
								</button>
								<button type="button"
									onclick="document.execCommand('justifyleft')">
									<i class="fas fa-align-left"></i>
								</button>
								<button type="button"
									onclick="document.execCommand('justifycenter')">
									<i class="fas fa-align-center"></i>
								</button>
								<button type="button"
									onclick="document.execCommand('justifyright')">
									<i class="fas fa-align-right"></i>
								</button> <br> <input type="button" value="에디터로 보기"
								onclick="convertToEditor()" /> <input type="button"
								value="HTML로 보기" onclick="convertToHTML()" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<div class="editorDIV" contenteditable="true"></div>
								<div class="editorHTMLDIV"></div> <input type="hidden"
								id="content" name="content">
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="글쓰기"> <input
								type="button" value="취소" onclick="history.back()"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>