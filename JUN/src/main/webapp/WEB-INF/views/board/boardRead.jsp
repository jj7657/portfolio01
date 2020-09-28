<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글보기</title>
<script src="https://kit.fontawesome.com/d183edbda6.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../resources/css/reset.css">
<link rel="stylesheet" href="../../resources/css/headerMenu.css">
<link rel="stylesheet" href="../../resources/css/boardRead.css">
<script src="../../resources/js/jquery-3.5.1.js"></script>
<script src="../../resources/js/boardRead.js"></script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/header.jsp"%>
		<div id="read_wrap">
			<div id="readTopBtn">

				<c:if test="${read.next!=0}">
					<button type="button" class="fas fa-angle-up">
						<a href="/web/board/read/${read.next}">이전글</a>
					</button>
				</c:if>
				<c:if test="${read.prev!=0}">
				<button type="button" class="fas fa-angle-down">
					<a href="/web/board/read/${read.prev}">다음글</a>
				</button>
				</c:if>
				<button type="button">
					<a href="/web/board/list/${page}">목록</a>
				</button>
			</div>
			<div id="readContent_wrap">
				<div id="readheader">
					<div id="readTitle">
						<a href="/web/board/list">게시판></a>
						<div>${read.title}</div>
					</div>
					<div id="WriterInfo">
						<div id="profile_area">
							<div id="profileInfo">
								<span>${read.writer}</span>
							</div>
							<div id="readInfo">
								<span><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${read.regdate}" /></span>
							</div>
						</div>
						<div id="readTool">
							<a href="#"><i class="far fa-comment-dots"></i><span>댓글</span></a>
							<a href="/web/board/read/${read.bno}" role="button">URL복사</a>
						</div>
					</div>
				</div>
				<div id="readContentBox">
					<div id="readContent">${read.content}</div>
					<div id="replyBox">
						<div id="replyBox_left">
							<a><i class="far fa-heart"></i><span>좋아요</span></a> <a><i
								class="far fa-comment-dots"></i><span>댓글</span></a>
						</div>
					</div>
					<div id="commentBox">
						<div id="commentOption">
							<h3>댓글</h3>
						</div>
						<div date=${read.bno} id="commentList">
							<ul>
							</ul>
						</div>
						<div id="commentPage">
							<ul>
							</ul>
						</div>
						<c:set value="${login.username}" var="name"></c:set>
						<c:if test="${name ne null}">
							<div id="commentWriter">
								<div id="comment_inbox">
									<p id="comment_inbox_name">${login.username}</p>
									<textarea name="replytext" id="comment_inbox_text" rows="1"
										placeholder="댓글을 남겨보세요"></textarea>
									<div id="comment_inbox_number">
										<strong id="inbox_count">1</strong> <strong id="inbox_total">300</strong>
									</div>
								</div>
								<div id="comment_attach">
									<div id="attach_box">
										<button>
											<i class="fas fa-camera"></i>
										</button>
									</div>
									<div id="register_box">
										<a role="button">등록</a>
									</div>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div id="readButtomBtn">
				<c:set value="${login.username}" var="name" />
				<c:set value="${read.writer}" var="writer" />
				<div>
					<c:if test="${name eq writer}">
						<button>
							<a href="/web/board/delete/${read.bno}">삭제</a>
						</button>
						<button>
							<a href="/web/board/modify/${read.bno}">수정</a>
						</button>
					</c:if>
				</div>
				<div>

					<button>
						<a href="/web/board/list/${page}">목록</a>
					</button>
					<button>
						<a href="#body">▲TOP</a>
					</button>
				</div>

			</div>
			<div id="RelatedContent"></div>
		</div>
	</div>
</body>
</html>