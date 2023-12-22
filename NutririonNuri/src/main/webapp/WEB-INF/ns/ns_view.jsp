<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영양제 정보</title>
    <link rel=stylesheet href="<c:url value='/css/css.css' />" type="text/css">
    <style>
    	.title, .info{
        	font-weight: bold;
        }
    </style>
</head>
<body>
	<span width="20%" height="164px" name="top">
        	<a href="<c:url value='/' />" target="_top">
		        <img src="<c:url value='/images/영양누리1.png' />" width="150" height="150"/>
		    </a>
        </span>
    <div class="board_wrap">
        <div class="page_title">
            <strong>영양제 정보</strong>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">${ns.name}</div>
                <div class="info">
                    <dl>
                        <dt>제조사</dt>
                        <dd>${ns.manufacturer}</dd>
                    </dl>
                    <dl>
                        <dt>별점</dt>
                        <dd>${ns.rate}</dd>
                    </dl>
                    <!-- <dl>
                        <dt>조회</dt>
                        <dd>33(db)</dd>
                    </dl> -->
                </div>
                <div class="cont">
                    <strong>효과</strong>
                    <div>${ns.effect}</div>
                </div>
                <div class="cont">
                    <strong>성분정보</strong>
                    <div>${ns.ingredient}</div>
                </div>
                <div class="cont">
                    <strong>주의사항</strong>
                    <div>${ns.precaution}</div>
                </div>
                
            </div>
            <!-- <div class="bt_wrap">
                <a href="<c:url value='/ns/list' />" class="on">목록</a>
            </div> -->
        </div>
    </div>
</body>
</html>