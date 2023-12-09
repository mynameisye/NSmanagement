<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <script>
		function login() {
			if (form.userId.value == "") {
				alert("사용자 ID를 입력하십시오.");
				form.userId.focus();
				return false;
			} 
			if (form.password.value == "") {
				alert("비밀번호를 입력하십시오.");
				form.password.focus();
				return false;
			}		
			form.submit();
		}
		
		function userCreate(targetUri) {
			form.action = targetUri;
			form.method="GET";		// register form 요청
			form.submit();
		}
		</script>
		
</head>

<body>       
    <form name="loginForm" method="get" action="index.jsp" target="login">
        <br>
        <fieldset>
            <font size="3">
                <p> 아이디 &nbsp; <input type="text" name="id" size="12" value=""> &nbsp;
                    <input type="submit" value="로그인"></p>
                <p>비밀번호 <input type="password" name="pwd" size="12" value="">&nbsp;
                	<input type="button" value="회원가입" onClick="userCreate('<c:url value='/user/register'/>')">    
                </p>
            </font>
        </fieldset>
    </form>
</body>
</html>
