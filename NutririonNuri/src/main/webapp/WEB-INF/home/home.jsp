<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>영양누리 홈페이지</title>
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
    <!-- 
    <style>
			a:link {
				color: #EB81A7;
				text-decoration: none;
			}
			a:visited {
				color: #FBADB9;
			}
			a:hover {
				color: pink;
			}
			div {
				border: 7px solid;
				width: 1300px;
				height: 750px;
				background-color: white;
			}
			p {
				font-size: 40px;
			}
			img {
				width: 200px;
				height: 280px;
			}
		</style> -->
</head>
<body>
    <div>
    	<!--  
    	<iframe src="./top.jsp" width="20%" height="164px" name="top" frameborder="0" scrolling="no"></iframe>
    	<iframe src="./search.jsp" width="60%" height="164px" name="top" frameborder="0" scrolling="no"></iframe>
        <iframe src="./login.jsp" width="19%" height="164px" name="login" frameborder="0" scrolling="no"></iframe>
    	-->
        
        <span width="20%" height="164px" name="top">
        	<a href="index.jsp" target="_top">
		        <img src="<c:url value='/images/영양누리1.png' />" width="150" height="150"/>
		    </a>
        </span>
        <span width="60%" height="164px" name="top">
        	<header>
	            <div class="search_wrap">
	                <form name="search" action="./ns/search_list.jsp">
	                    <select name="searchOption">
	                        <option value="total">통합검색</option>
	                        <option value="name">이름</option>
	                        <option value="effect">효능</option>
	                        <option value="ingredient">성분</option>
	                        <option value="company">제조사</option>
	                    </select>
	                    <input type="text" name="keyword" placeholder="영양제 검색">            
	                    <input type="submit" value="검색">
	                </form>
	            </div>
	        </header>
        </span>
        <span>
        	<form name="loginForm" method="get" action="<c:url value='/user/login' />">
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
        </span>
    </div>

    <div>
	    <!--
	    <iframe src="./ranking.jsp" width="79%" height="800px" name="left" frameborder="0" scrolling="yes"></iframe>
        <iframe src="./menu.jsp" width="20%" height="800px" name="right" frameborder="0" scrolling="no"></iframe> 
	     -->
	     <span width="79%" height="800px" name="left">
	     	<center>
				<font size="5">
					<div>
						<p align="center">영양제 랭킹</p>
						<table border="0" cellspacing="0" cellpadding="10" width="1300"
							height="200" align="center">
							<tr>
								<td>1위 - SAT</td>
								<td><img src="<c:url value='/images/1.PNG'/>"></img></td>
								<td>2위 - 트리플 스트렝스 오메가3 피쉬오일(오메가3 1040mg)</td>
								<td><img src="<c:url value='/images/2.PNG'/>"></img></td>
								<td align="center">3위 - 칼슘 마그네슘 말레이트</td>
								<td><img src="<c:url value='/images/3.PNG' />"></img></td>
							</tr>
							<tr>
								<td>4위 - 락토비프 프로바이오틱스 300억</td>
								<td><img src="<c:url value='/images/4.PNG' />"></img></td>
								<td>5위 - 트리플 스트렝스 오메가3 피쉬오일(오메가3 1055mg)</td>
								<td><img src="<c:url value='/images/5.PNG' />"></img></td>
								<td>6위 - 비타민C 1000</td>
								<td><img src="<c:url value='/images/6.PNG' />"></img></td>
							</tr>
						</table>
					</div>
		
				</font>
			</center>
	     </span>
	     <span width="20%" height="800px" name="right">
	     	<br/><br/><br/><br/>

		    <div align="left" width="50%" height="350px">
		        <br/><br/><br/>
		        <font size="5">
		            <a href="<c:url value='/user/update' />" target="_top">• 회원정보 관리</a><br><br>
		            <a href="<c:url value='/review/list' />" target="_top">• 게시판</a> <br><br> 
		        </font>
		    </div>
	     </span>
    </div>

    <div>
    	<!--
    	<iframe src="./bottom.jsp" width="100%" height="25px" name="bottom" frameborder="0" scrolling="no"></iframe>  
    	-->
        <p><font size="2">영양누리(대표:천지창조) Call:010-1234-4567 E-mail:db0207@naver.com</font></p>
    </div>
</body>
</html>
