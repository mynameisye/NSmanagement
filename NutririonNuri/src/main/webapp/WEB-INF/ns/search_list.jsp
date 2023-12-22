<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>검색결과</title>
    <link rel=stylesheet href="<c:url value='/css/css.css' />" type="text/css">
    <style>
        .search_list{
        	font-size: 15px;
        }
        .title{
        	font-size: 20px;
        	font-weight: bold;
        }
    </style>
</head>
<body>
	<span width="20%" height="164px" name="top"> <a
		href="<c:url value='/' />" target="_top"> <img
			src="<c:url value='/images/영양누리1.png' />" width="150" height="150" />
	</a>
	</span>
	<div class="board_wrap">
        <div class="board_title">
            <strong>검색결과</strong>
        </div>
        <div class="board_list_wrap" align="center">
            <div class="search_list"><hr>
                <!--해당 블럭을 기준으로 jsp로 db에서 데이터 적용할 수 있도록 jsp작성시 코드 수정-->
				<c:forEach var="ns" items="${nsList}">
					<br>
					<div class="title">
						<a href="<c:url value='/ns/view'>
							<c:param name='nsId' value='${ns.supId}'/></c:url>">
							${ns.name}
						</a>
					</div>
					<br><br>
					<div class="manufacture">제조사 : ${ns.manufacturer}</div><br>
					<div class="rate">평점 : ${ns.rate}</div><br><hr>
				</c:forEach>
			</div>
        </div>
    </div>
</body>
</html> 