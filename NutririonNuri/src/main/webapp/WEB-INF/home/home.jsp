<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
// 현재 요청의 세션을 가져옵니다.
HttpSession session2 = request.getSession();

// 현재 로그인되어있는 사용자 아이디
String sessionId = session2.getId();
String curUserId = (String)session.getAttribute("curUserId"); 

//현재 로그인되어있는 사용자 이름
String userName = (String)session.getAttribute("curUserName");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>영양누리 홈페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/css.css'/>">
    <script>
	function login() {
		if (loginForm.id.value == "") {
			alert("사용자 ID를 입력하십시오.");
			loginForm.id.focus();
			return false;
		} 
		if (loginForm.pwd.value == "") {
			alert("비밀번호를 입력하십시오.");
			loginForm.pwd.focus();
			return false;
		}		
		loginForm.submit();
	}
	
	function userCreate(targetUri) {
		loginForm.action = targetUri;
		loginForm.method="GET";
		loginForm.submit();
	}
	</script>
</head>
<body>
    <div name='header'>
    	<!--  
    	<iframe src="./top.jsp" width="20%" height="164px" name="top" frameborder="0" scrolling="no"></iframe>
    	<iframe src="./search.jsp" width="60%" height="164px" name="top" frameborder="0" scrolling="no"></iframe>
        <iframe src="./login.jsp" width="19%" height="164px" name="login" frameborder="0" scrolling="no"></iframe>
    	-->
       	<span>
        	<a href="<c:url value='/home'/>" target="_top">
		        <img class="logo" src="<c:url value='/images/영양누리1.png' />" width="150" height="150"/>
		    </a>
        </span>
        <span>
        	<center>
        	<div class="search_wrap"">
                <form name="search" method="POST" action="<c:url value='/ns/list' />">
                    <select name="searchOption">
                        <option value="total">통합검색</option>
                        <option value="name">이름</option>
                        <option value="effect">효능</option>
                        <option value="ingredient">성분</option>
                        <option value="manufacturer">제조사</option>
                    </select>
                    <input type="text" name="keyword" placeholder="영양제 검색">            
                    <input type="submit" value="검색">
                </form>
            </div>
            </center>
        </span>
        <br>
        <br>
    </div>

    <div name='body'>
	    <!--
	    <iframe src="./ranking.jsp" width="79%" height="800px" name="left" frameborder="0" scrolling="yes"></iframe>
        <iframe src="./menu.jsp" width="20%" height="800px" name="right" frameborder="0" scrolling="no"></iframe> 
	     -->
	    <div class='inline' id="content">
			<p align="center">영양제 랭킹</p>
			<table id='ranking'>
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

		<div class='inline' id='menu'>
			<form name="loginForm" method="POST" action="<c:url value='/user/login' />">
		        <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	       		<c:if test="${loginFailed}">
	  	  			<br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
	    		</c:if> 
	    		<br>
		        <fieldset>
	            	<c:if test="${userId == null}">
		                <p> 아이디 &nbsp; <input type="text" name="id" size="12" value=""> &nbsp;
		                    <input type="button" value="로그인" onClick="login()"></p>
		                <p>비밀번호 <input type="password" name="pwd" size="12" value="">&nbsp;
		                	<input type="button" value="회원가입" onClick="userCreate('<c:url value='/user/register'/>')">
		                </p>
	                </c:if>
	                <c:if test="${userId != null}">
	                	${curUserName}님 환영합니다!<br>
	                	<a href="<c:url value='/user/logout' />">
	                		(로그아웃)
	                	</a>
	                </c:if>
		        </fieldset>
		    </form>
		    <br>
		    
		    <c:if test="${curUserId != null}">
	 			<a href="<c:url value='/user/update'>
    		   			<c:param name='userId' value='${userId}'/>
    		   		</c:url>"> • 회원정보 관리</a><br>
    		</c:if> 
		</div>
	</div>
	
	<hr><br>
	
    <div name='tail'>
    	<!--
    	<iframe src="./bottom.jsp" width="100%" height="25px" name="bottom" frameborder="0" scrolling="no"></iframe>  
    	-->	
        영양누리(대표:천지창조) Call:010-1234-4567 E-mail:db0207@naver.com
    </div>
</body>
</html>