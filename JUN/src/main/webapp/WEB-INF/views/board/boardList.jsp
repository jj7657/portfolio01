<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/d183edbda6.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../resources/css/reset.css">
<link rel="stylesheet" href="../../resources/css/headerMenu.css">
<link rel="stylesheet" href="../../resources/css/board.css">
<title>게시판</title>
</head>
<body>
	<div id="wrap">
	<%@ include file="/WEB-INF/views/header.jsp" %>
		<div id="board_wrap">
			<div id="board">
				<h2>게시판</h2>
				<table>
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagevo.board}" var="boardVO">
							<tr>
								<td>${boardVO.bno}</td>
								<td><a href="/web/board/read/${boardVO.bno}">${boardVO.title}</a></td>
								<td>${boardVO.writer}</td>
								<fmt:formatDate var="yyyyMMdd" pattern="yyyy.MM.dd"
									value="${boardVO.regdate}" />
								<fmt:formatDate var="HHmm" pattern="HH:mm"
									value="${boardVO.regdate}" />
								<c:set var="time" value="${time}" />
								<c:choose>
									<c:when test="${time eq yyyyMMdd}">
										<td>${HHmm}</td>
									</c:when>
									<c:when test="${time ne yyyyMMdd}">
										<td>${yyyyMMdd}</td>
									</c:when>
								</c:choose>
								<td>${boardVO.viewcnt}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="5">
								<button>
									<a href="/web/board/write">글쓰기</a>
								</button>
							</td>
						</tr>
					</tfoot>
				</table>
				<div id="paging">
				<c:set value="${pagevo.pageMaker}" var="pageMaker" />
				<c:if test="${pageMaker.prev}">
					<a href="/web/board/list/${pageMaker.startpage-1}" class="fas fa-angle-double-left"></a>
				</c:if>
				<c:forEach var="i" begin="${pageMaker.startpage}" end="${pageMaker.endpage}">
					<a href="/web/board/list/${i}">${i}</a>
				</c:forEach>
				<c:if test="${pageMaker.next}">
					<a href="/web/board/list/${pageMaker.endpage-1}" class="fas fa-angle-double-right"></a>
				</c:if>
				</div>
				<div id="search">
					<input type="text"> <input type="button" value="검색">
				</div> 
			</div>
		</div>
	</div>
</body>
</html>