<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원 가입" />

<%@ include file="../part/head.jspf" %>

<script>
	function submitJoinForm(form) {
		form.loginId.value = form.loginId.value.trim();
		if (form.loginId.value.length == 0) {
			alert('로그인 아이디를 입력해주세요.');
			form.loginId.focus();
			return false;
		}
		if (form.loginId.value.length < 4) {
			alert('로그인 아이디를 4자 이상 입력해주세요.');
			form.loginId.focus();
			return false;
		}
		if (isAlphaNumeric(form.loginId.value) == false) {
			alert('로그인 아이디는 영문자 소문자와 숫자만 사용할 수 있습니다.');
			form.loginId.focus();
			return false;
		}
		form.loginId.value = form.loginId.value.toLowerCase();

		form.loginPw.value = form.loginPw.value.trim();
		if (form.loginPw.value.length == 0) {
			alert('비밀번호를 입력해주세요.');
			form.loginPw.focus();
			return false;
		}
		form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
		if (form.loginPwConfirm.value.length == 0) {
			alert('비밀번호 확인을 입력해주세요.');
			form.loginPwConfirm.focus();
			return false;
		}
		if (form.loginPw.value != form.loginPwConfirm.value) {
			alert('로그인 비밀번호 확인이 일치하지 않습니다.');
			form.loginPwConfirm.focus();
			return false;
		}
		form.name.value = form.name.value.trim();
		if (form.name.value.length == 0) {
			alert('이름을 입력해주세요.');
			form.name.focus();
			return false;
		}
		if (form.name.value.length < 2) {
			alert('이름을 2자 이상 입력해주세요.');
			form.name.focus();
			return false;
		}
		form.submit();
	}
</script>

<div class="member-join-box con">
	<form onsubmit="submitJoinForm(this); return false;"
		action="/member/doJoin" method="POST"
		class="table-box form form-type-1">
		<table>
			<colgroup>
				<col width="100" />
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input maxlength="30" name="loginId" autofocus="autofocus"
						placeholder="로그인 아이디를 입력해주세요." type="text" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input maxlength="30" name="loginPw"
						placeholder="비밀번호를 입력해주세요." type="password" /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input maxlength="30" autocomplete="off"
						name="loginPwConfirm" placeholder="비밀번호 확인을 입력해주세요."
						type="password" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input maxlength="30" name="name"
						placeholder="이름을 입력해주세요." type="text" /></td>
				</tr>
				<tr>
					<th>회원가입</th>
					<td>
						<input type="submit" value="가입" /> 
						<input onclick="history.back();" type="button" value="취소" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<%@ include file="../part/foot.jspf" %>