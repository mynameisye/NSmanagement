<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member</title>
<script>
	function toggleTextbox(textboxId) {
		var textbox = document.getElementById(textboxId);
		var checkbox = document.getElementsByName(textboxId.substring(0,
				textboxId.indexOf('Textbox')))[0];

		if (checkbox.checked) {
			textbox.disabled = false;
		} else {
			textbox.disabled = true;
		}
	}
</script>
<style>
table {
	border-collapse: collapse;
	width: 550px;
	height: 700px;
	margin-left: auto;
	margin-right: auto;
}

table, tr, td {
	border: 0.5px solid;
}

#name {
	text-align: center;
	width: 80px;
	font-weight: bold;
	<!--background-color: #bcbcbc;-->
}

input.imageAlign {
	vertical-align: middle;
}

#bottom {
	text-align: center;
	<!--background-color: #bcbcbc;-->
}
</style>
</head>
<body>
	<form method=POST action=register.jsp>
		<table>
			<tr>
				<td id="name" colspan="2">개인정보 관리</td>
			</tr>
			<tr>
				<td id="name">이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td id="name">아이디</td>
				<td><input type="text" name="id">
				<input type="button" name="idcheck" onclick="idCheck()" value="중복검사"></td>
			</tr>
			<tr>
				<td id="name">패스워드</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td id="name">생일</td>
				<td><input type="date" name="birth">&emsp;
				<input type="radio" name="birth_date" value=0>양력 
				<input type="radio" name="birth_date" value=1>음력 </td>
			</tr>
			<tr>
				<td id="name">성별</td>
				<td><input type="radio" name="gender" value=0>남&emsp;
				<input type="radio" name="gender" value=1>여</td>
			</tr>
			<tr>
				<td id="name">키(cm)</td>
				<td><input type="text" name="height"></td>
			</tr>
			<tr>
				<td id="name">몸무게(kg)</td>
				<td><input type="text" name="weight"></td>
			</tr>
			<tr>
				<td id="name">기저질환</td>
				<td><input type="checkbox" name="disease" value=0>고지혈증 
					<input type="checkbox" name="disease" value=1>고혈압 
					<input type="checkbox" name="disease" value=2>뇌혈관 질환 
					<input type="checkbox" name="disease" value=3>당뇨 
					<input type="checkbox" name="disease" value=4>만성 간 질환 
					<input type="checkbox" name="disease" value=5>만성 신장 질환 
					<input type="checkbox" name="disease" value=6>만성 폐 질환 
					<input type="checkbox" name="disease" value=7>비만 
					<input type="checkbox" name="disease" value=8>심혈관 질환 
					<input type="checkbox" name="disease" value=9>암 
					<input type="checkbox" name="disease" value=10>정신 질환 
					<input type="checkbox" name="disease" value=11 onclick="toggleTextbox('etcTextbox')">기타 
					<input type="text" id="etcTextbox" disabled></td>
			</tr>
			<tr>
				<td id="name">임신과<br>최근 임신</td>
				<td><input type="checkbox" name="pregnant" onclick="toggleTextbox('pregnantTextbox')"><br> 
				임신	기간: <input type="text" id="pregnantTextbox" disabled></td>
			</tr>
			<tr>
				<td id="name">흡연 여부</td>
				<td><input type="checkbox" name="smoke" onclick="toggleTextbox('smokeTextbox')"><br>
				하루 평균	흡연량(단위: 개비): <input type="text" id="smokeTextbox" disabled></td>
			</tr>
			<tr>
				<td id="name">음주 여부</td>
				<td><input type="checkbox" name="alchol" onclick="toggleTextbox('alcoholTextbox')"><br>
				하루	평균 음주량(단위: 잔): <input type="text" id="alcoholTextbox" disabled></td>
			</tr>
			<tr>
				<td id="name">복용 중인 처방약</td>
				<td>약 종류: <input type="text"><br> 
				하루에 먹는 횟수: <input type="text"><br> 
				특이사항: <input type="text"></td>
			</tr>
			<tr>
				<td id="name">복용 중인 영양제</td>
				<td>약 종류: <input type="text"><br> 
				하루에 먹는 횟수: <input type="text"><br> 
				특이사항: <input type="text"></td>
			</tr>
			<tr>
				<td id="name">선호하는 성분</td>
				<td><input type="checkbox" name="favor" value=0>비타민 
					<input type="checkbox" name="favor" value=1>루테인 
					<input type="checkbox" name="favor" value=2>칼슘 
					<input type="checkbox" name="favor" value=3>마그네슘 
					<input type="checkbox" name="favor" value=4>밀크씨슬 
					<input type="checkbox" name="favor" value=5>오메가3 
					<input type="checkbox" name="favor" value=6>유산균 
					<input type="checkbox" name="favor" value=7>철분 
					<input type="checkbox" name="favor" value=8>아연 
					<input type="checkbox" name="favor" value=9>글루타치온 <br>
					<input type="checkbox" name="favor" value=10 onclick="toggleTextbox('etcTextbox')">기타 
					<input type="text" id="etcTextbox" disabled></td>
			</tr>
			<tr>
				<td id="bottom" colspan="2"><input type="submit" value="저장하기">&emsp;
				<input type="reset" value="취소하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>