<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>영양누리 회원가입</title>
    <meta charset="UTF-8">
    
    <style>
        div {
            border: 5px solid;
            width: 800px;
            height: 600px;
        }
        input[type="button"] {
        	padding: 5px;
            background-color: black;
            color: white;
        }
        input[type="reset"]{
        	padding: 5px;
            background-color: gray;
            color: white;
        }
    </style>
    <script>
    function userCreate() {
    	if (joinForm.member_id.value == "") {
    		alert("사용자 ID를 입력하십시오.");
    		joinForm.member_id.focus();
    		return false;
    	} 
    	if (joinForm.member_pw.value == "") {
    		alert("비밀번호를 입력하십시오.");
    		joinForm.member_pw.focus();
    		return false;
    	}
    	if (joinForm.member_pw.value != joinForm.member_pw_check.value) {
    		alert("비밀번호가 일치하지 않습니다.");
    		joinForm.member_name.focus();
    		return false;
    	}
    	if (joinForm.member_name.value == "") {
    		alert("이름을 입력하십시오.");
    		joinForm.member_name.focus();
    		return false;
    	}
    	joinForm.submit();
    }
    
    </script>
</head>

<body>
    <br>
    <center>
        <div>
            <table border="0" cellspacing="10" cellpadding="10" width="800" height="600" align="center">
                <form name="joinForm" method="post" action="<c:url value='/user/register' />" target="_self" >
                    <tr>
                        <td align="center"><h3>회원가입</h3></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td align="center">아이디</td>
                        <td>
                            <input type="text" size="13" name="member_id" placeholder="아이디 입력" autofocus required>&nbsp;&nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td align="center">비밀번호</td>
                        <td><input type="password" size="14" name="member_pw" placeholder="비밀번호" required>&nbsp;&nbsp;&nbsp;
                            비밀번호 확인&nbsp;&nbsp;<input type="password" size="14" name="member_pw_check" placeholder="비밀번호 확인" required></td>
                    </tr>
                    <tr>
                        <td align="center">이름</td>
                        <td><input type="text" size="14" name="member_name" placeholder="이름을 입력해 주세요" required></td>
                    </tr>
                    <tr>
                        <td align="center">성별</td>
                        <td><input type="radio" name="gender" value="M">남자<input type="radio" name="gender" value="F">여자</td>
                    </tr>
                    <tr>
                        <td align="center">전화번호</td>
                        <td><input type="text" size="14" name="member_phone" placeholder="전화번호를 입력해 주세요" required></td>
                    </tr>
                    <tr>
                        <td align="center">이메일</td>
                        <td><input type="text" size="9" name="mail1">@ 
                        <select name="mail2">
                            <option>naver.com</option>
                            <option>gmail.com</option>
                            <option>hanmail.net</option>
                            <option>daum.net</option>
                            <option>nate.com</option>
                            <option>직접입력</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="button" value="가입하기" onClick="userCreate()">
                            <input type="reset" value="재입력">
                        </td>
                    </tr>
                </form>
            </table>
        </div>
    </center>
</body>
</html>