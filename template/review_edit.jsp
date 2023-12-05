<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 게시판</title>
    <link rel="stylesheet" href="./css/css.css">
    <style>
        select, input {
            padding: 10px;
            box-sizing: border-box;
            border: 0px;
            outline: none;
        }
        .search_wrap{
            float: right;
            height: max-content;
            width: 300px;
            border: 1px solid black;
            background: white;
        }
        input[type="text"] {
            width: 60%;
        }
        input[type="submit"]{
            float: right;
            background-color: black;
            color: white;
        }
    </style>
</head>
<body>
    <div class="board_wrap">
        <div class="page_title">
            <strong>리뷰</strong>
            <div class="search_wrap">
                <form name="search">
                    <input type="text" name="keyword" placeholder="게시글 검색">            
                    <input type="submit" value="검색">
                </form>
            </div>
        </div>
        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                    <div class="num">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="date">작성일</div>
                    <div class="count">조회</div>
                </div>

                <!--해당 블럭을 기준으로 jsp로 db에서 데이터 적용할 수 있도록 코드 수정-->
                <div>
                    <div class="num">1</div>
                    <div class="title"><a href="./review_view.jsp">제목</a></div>
                    <div class="writer">작성자</div>
                    <div class="date">작성일</div>
                    <div class="count">1</div>
                </div>
                <div>
                    <div class="num">2</div>
                    <div class="title"><a href="./review_view.jsp">db에서 불러오는 코드 필요</a></div>
                    <div class="writer">작성자</div>
                    <div class="date">작성일</div>
                    <div class="count">조회</div>
                </div>
            </div>
            <div class="board_page">
                <!--jsp 사용하여 상황에 맞게 작동하도록 수정-->
                <a href="#" class="bt first"><<</a>
                <a href="#" class="bt prev"><</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="num">4</a>
                <a href="#" class="num">5</a>
                <a href="#" class="bt next">></a>
                <a href="#" class="bt last">>></a>
            </div>
            <div class="bt_wrap">
                <!--해당 버튼(링크) 클릭시 db에 등록하고 등록된 게시글을 보여줌-->
                <a href="./review_write.jsp" class="on">등록</a>
                <!--<a href="#">수정</a>-->
            </div>
        </div>
    </div>
</body>
</html> 