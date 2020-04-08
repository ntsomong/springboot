<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
</head>
<style>
.con {
	width: 1000px;
	margin: 0 auto;
}
.article-list-box>table {
	width: 100%;
	border-collapse: collapse;;
}
.article-list-box>table th, .article-list-box>table td {
	border: 1px solid black;
	padding: 15px;
}
</style>
<body>
	<div style="text-align:center;">
	<h1>게시판 리스트</h1>
	Age is ${age}. <br> articles is --->  ${articles}
	</div>
	
	<div class="con menu-box">
		<a href="/article/list">리스트</a>
		<a href="/article/write">글쓰기</a>
	</div>

	<div class="con article-list-box">
		<table>
			<colgroup>
				<col width="10" />
				<col width="200" />
				<col />
				<col width="400" />
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>날짜</th>
					<th>제목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articles}" var="article">
					<tr>
						<td>${article.id}</td>
						<td>${article.regDate}</td>
						<td><a href="#">${article.title}</a></td>
						<td>${article.body}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>