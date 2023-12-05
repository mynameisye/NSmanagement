<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰글</title>
    <link rel="stylesheet" href="./css/css.css">
</head>
<body>
    <div class="board_wrap">
        <!--jsp수정시 title part는 하나로 빼도 될 듯-->
        <div class="page_title">
            <strong>리뷰</strong>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                    제목
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>1(db?)</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>홍길동(db)</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>today(db)</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>33(db)</dd>
                    </dl>
                </div>
                <div class="cont">
                    작성된 내용
                    <br/>
                    <br/>
                </div>
            </div>
            <div class="bt_wrap">
                <a href="./review_list.jsp" class="on">목록</a>
                <a href="./review_edit.jsp">수정</a>
            </div>
        </div>
    </div>
</body>
</html>