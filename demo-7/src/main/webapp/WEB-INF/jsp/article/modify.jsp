<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<style>
.con {
	width: 1000px;
	margin: 0 auto;
}
.article-modify-box>form>table {
	width: 100%;
	border-collapse: collapse;;
}
.article-modify-box>form>table th, .article-modify-box>form>table td {
	border: 1px solid black;
	padding: 15px;
}

.article-modify-box>form>table td input[type="text"],
.article-modify-box>form>table td textarea {
	display: block;
	width: 90%;
}
.article-modify-box>form>table td textarea {
	height: 300px;
}
</style>

<body>
	<div style="text-align:center;">
	<h1>게시글 수정하기</h1>
	</div>
	
	<div class="con menu-box">
		<a href="/article/list">리스트</a> <a href="/article/modify">글쓰기</a>
	</div>

	<script>
	function submitModifyForm(form) {
		form.title.value = form.title.value.trim();
		if (form.title.value.length == 0) {
			alert('제목을 입력해 주세요.');
			form.title.focus();	
			return false;
		}
		form.body.value = form.body.value.trim();
		if (form.body.value.length == 0) {
			alert('내용을 입력해주세요.');
			form.body.focus();
			return false;
		}
		form.submit();
	}
	</script>

	<div class="con article-modify-box">
		<form onsubmit="submitModifyForm(this); return false;" action="/article/doModify" method="POST">
			<input value="${article.id}" name="id" type="hidden" />

			<table>
				<colgroup>
					<col width="100" />
				</colgroup>
				<tbody>
					<tr>
						<th>번호</th>
						<td>${article.id}</td>
					</tr>					
					<tr>
						<th>제목</th>
						<td>
							<input value="${article.title}" autocomplete="off" name="title" autofocus="autofocus" placeholder="제목을 입력하세요." type="text" />
						</td>
					</tr>					
					<tr>
						<th>내용</th>
						<td>
							<textarea name="body" placeholder="내용을 입력하세요.">${article.body}</textarea>
						</td>
					</tr>					
					<tr>
						<th>수정</th>
						<td>
							<input type="submit" value="수정" />
							<!-- <button type="button">취소</button> 	-->
							<input onclick="history.back();" type="button" value="취소" /> 
						</td>
					</tr>					

				</tbody>
			</table>
		</form>
	</div>
</body>
</html>