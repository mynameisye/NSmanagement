<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
</head>

<body>       
    <form name="loginForm" method="get" action="index.jsp" target="login">
        <br>
        <fieldset>
            <font size="3">
                <p> 아이디 &nbsp; <input type="text" name="id" size="12" value=""> &nbsp;
                    <input type="submit" value="로그인"></p>
                <p>비밀번호 <input type="password" name="pwd" size="12" value="">&nbsp;
                    <a href="member.jsp" target="_top">회원 가입</a> </p>
            </font>
        </fieldset>
    </form>
</body>
</html>
