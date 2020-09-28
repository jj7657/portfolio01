<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="headerWrap">
	<div id="logo">
		<a class="fas fa-cat" href="/web/"></a>
	</div>
	<div id="menu">
		<ul>
			<li><a href="/web/board/list/1">게시판</a></li>
			<li>공공API</li>
			<li>미정</li>
		</ul>
	</div>
	<div id="utillmenu">
		<c:set value="${login.username}" var="name" />
		<c:if test="${name eq null}">
			<div id="nonmemUtill">
				<ul>
					<li><a href="/web/">홈</a></li>
					<li><a href="/web/member/login">로그인</a></li>
					<li><a href="/web/member/join">회원가입</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${name ne null}">
			<div id="memUtill">
				<ul>
					<li><a href="/web/">홈</a></li>
					<li><a href="/web/member/logout">로그아웃</a></li>
					<li><a href="/web/member/modify">회원수정</a></li>
				</ul>
			</div>
		</c:if>
	</div>
</div>
