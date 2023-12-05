<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    </style>
</head>

<body>
    <br>
    <center>
        <div>
            <table border="0" cellspacing="10" cellpadding="10" width="800" height="600" align="center">
                <form method="post" action="member.jsp" target="_self" name="joinForm">
                    <tr>
                        <td align="center"><h3>회원가입</h3></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td align="center">아이디</td>
                        <td>
                            <input type="text" size="13" name="member_id" placeholder="아이디 입력" autofocus required>&nbsp;&nbsp;
                            <input type="button" name="idcheck" onclick="alert('중복되지 않습니다')" value="중복검사">
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
                        <td><input type="radio" name="gender" value="남자">남자<input type="radio" name="gender" value="여자">여자</td>
                    </tr>
                    <tr>
                        <td align="center">주민등록번호</td>
                        <td><input type="text" name="idLeft" maxlength="6" size="6"> - <input type="password" name="idRight" maxlength="7" size="7">&nbsp;&nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td align="center">생년월일</td>
                        <td><input type="text" name="year" maxlength="4" size="4">년
                            <select name="month">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                            </select>월
                            <input type="number" name="day" min="1" max="31">일
                            <input type="radio" name="solar">양력 <input type="radio" name="lunar">음력
                        </td>
                    </tr>
                    <tr>
                        <td align="center">이메일</td>
                        <td><input type="text" size="9" name="mail">@<input type="text" size="9" name="maill" list="mail_list"> </td>
                        <datalist id="mail_list">
                            <option>naver.com</option>
                            <option>gmail.com</option>
                            <option>hanmail.net</option>
                            <option>daum.net</option>
                            <option>natet.com</option>
                            <option>직접입력</option>
                        </datalist>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="가입하기">
                            <input type="reset" value="재입력">
                        </td>
                    </tr>
                </form>
            </table>
        </div>
    </center>
</body>
</html>
