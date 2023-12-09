<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영양제 정보</title>
    <link rel="stylesheet" href="./css/css.css">
</head>
<body>
    <div class="board_wrap">
        <!--jsp수정시 title part는 하나로 빼도 될 듯-->
        <div class="page_title">
            <strong>영양제 정보</strong>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">영양제 이름</div>
                <div class="info">
                    <dl>
                        <dt>제조사</dt>
                        <dd>ㅇㅇ제약(db)</dd>
                    </dl>
                    <dl>
                        <dt>별점</dt>
                        <dd>4.5(db)</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>33(db)</dd>
                    </dl>
                </div>
                <div class="cont">
                    <strong>효과</strong>
                    <div>본문</div>
                </div>
                <div class="cont">
                    <strong>성분정보</strong>
                    <div>성분1, 성분2, 성분3 ...</div>
                </div>
                
            </div>
            <div class="bt_wrap">
                <!-- jsp작성시 이전 페이지로 돌아가는 코드로 수정 필요 -->
                <a href="./search_list.jsp" class="on">목록</a>
            </div>
        </div>
    </div>
</body>
</html>