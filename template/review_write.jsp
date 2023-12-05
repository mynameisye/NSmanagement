<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새 글 작성</title>
    <link rel="stylesheet" href="./css/css.css">
</head>
<body>
    <div class="board_wrap">
        <div class="page_title">
            <strong>리뷰</strong>
        </div>
        <form>
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
                        <textarea id="article" placeholder="내용 입력"></textarea>
                    </div>
                </div>
                <div class="bt_wrap">
                    <a href="./review_view.jsp" class="on">등록</a>
                    <a href="./review_list.jsp">취소</a>
                </div>
            </div>
        </form>
    </div>
</body>
</html>