<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새 글 작성</title>
    <link rel="stylesheet" href="<c:url value='/css/css.css'/>">
</head>
<body>
    <div class="board_wrap">
        <div class="board_title">
            <strong>리뷰</strong>
        </div>
        <form action="<c:url value='/review/write' />">
            <div class="board_write_wrap">
                <div class="board_write">
                    <div class="title">
                        <dl>
                            <dt>제목</dt>
                            <dd><input id="title" type="text" placeholder="제목 입력"></dd>
                        </dl>
                    </div>
                    <hr>
                    <div class="cont">
                        <textarea id="contents" placeholder="내용 입력"></textarea>
                    </div>
                </div>
                <div class="bt_wrap">
                    <a href="./review_view.jsp" class="on">등록</a>
                    <!--<input type="submit" value="등록">-->
                    <a href="./review_list.jsp">취소</a>
                    <!--<input type="reset" value="취소">-->
                </div>
            </div>
        </form>
    </div>
</body>
</html>