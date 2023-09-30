
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>게시판</h2>
        <div class="panel panel-default">
            <div class="panel-heading">BOARD</div>
            <div class="panel-body">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <c:forEach var="board" items="${boardList}">
                        <tr>
                            <td>${board.idx}</td>
                            <td>${board.title}</td>
                            <td>${board.content}</td>
                            <td>${board.inDate}</td>
                            <td>${board.count}</td>
                        </tr>
                    </c:forEach>


                </table>



            </div>

        </div>
    </div>
    <div class="panel-footer">유저 게시판</div>

</body>
</html>