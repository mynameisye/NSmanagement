<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>검색결과</title>
    <link rel="stylesheet" href="./css/css.css">
    <style>
        select, input {
            padding: 10px;
            box-sizing: border-box;
            border: 0px;
            outline: none;
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
            <strong>검색결과</strong>
        </div>
        <div class="board_list_wrap">
            <div class="search_list">
                <!--해당 블럭을 기준으로 jsp로 db에서 데이터 적용할 수 있도록 jsp작성시 코드 수정-->
                <div>
                    <div class="title"><a href="./ns_view.jsp">제목(db 사용)</a></div>
                    <div class="date">yyyy-mm-dd</div>
                    <br/>
                    <div class="preview">본문내용(간략)</div>
                </div>
                <div>
                    <div class="title"><a href="./ns_view.jsp">제목(db 사용)</a></div>
                    <div class="date">yyyy-mm-dd</div>
                    <br/>
                    <div class="preview">본문내용(간략)</div>
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
        </div>
    </div>
</body>
</html> 