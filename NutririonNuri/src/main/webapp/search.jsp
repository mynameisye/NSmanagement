<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>검색창</title>
        <meta charset="UTF-8">
        <style>
            select, input {
                padding: 10px;
                box-sizing: border-box;
                border: 0px;
                outline: none;
            }
            .search_wrap{
                margin: auto;
                height: max-content;
                width: 500px;
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
        <!--필라이즈 사이트처럼 header 부분에 고정하는게 좋을지도-->
        <header>
            <div class="search_wrap">
                <form name="search">
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
    </body>
</html>