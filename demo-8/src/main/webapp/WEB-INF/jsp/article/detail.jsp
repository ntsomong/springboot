<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${article.id}번 게시물 " />

<%@ include file="../part/head.jspf" %>

	<div class="con table-box form form-type-1">
		<table>
			<colgroup>
				<col width="100" />
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td>${article.title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${article.bodyForPrint}</td>
				</tr>
				<tr>
					<th>비고</th>
					<td>
						<a href="./modify?id=${article.id}"><input type="button" value="수정" /></a> 
						<a href="./doDelete?id=${article.id}" onclick="if ( confirm('정말로 삭제하시겠습니까?') == false ) return false;">
							<input type="button" value="삭제" /></a>
					</td>
				</tr>
				
			</tbody>
		</table>
	</div>

<%@ include file="../part/foot.jspf" %>