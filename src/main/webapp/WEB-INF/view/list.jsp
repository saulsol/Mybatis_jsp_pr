
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(
            function () {
                $("#regBtn").click(function (){
                   location.href="${ctx}/board/register";
                });

            });

    </script>


</head>
<body>
    <div class="container">
        <h2>게시판</h2>
        <div class="panel panel-default">
            <div class="panel-heading">
                <c:if test="${empty loginSuccess}">
                <form class="form-inline" action="${ctx}/login/loginProcess" method="post">
                    <div class="form-group">
                        <label for="memId">ID:</label>
                        <input type="text" class="form-control" name="memId" id="memId">
                    </div>
                    <div class="form-group">
                        <label for="pwd">비밀번호:</label>
                        <input type="password" class="form-control" name="memPwd" id="pwd">
                    </div>

                    <button type="submit" class="btn btn-default">로그인</button>
                </form>
                </c:if>

                <c:if test="${!empty loginSuccess}">
                    <form class="form-inline" action="${ctx}/login/logoutProcess" method="post">

                        <label>${loginSuccess.memName}님 방문을 환영합니다.</label>
                        <button type="submit" class="btn btn-default">로그아웃</button>
                    </form>
                </c:if>

            </div>
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
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.inDate}"/></td>
                            <td>${board.count}</td>
                        </tr>
                    </c:forEach>

                    <c:if test="${!empty loginSuccess}">
                        <tr>
                            <td colspan="5">
                                <button id="regBtn" class="btn btn-sm btn-primary pull-right">글쓰기</button>
                            </td>
                        </tr>
                    </c:if>

                </table>



            </div>

        </div>
    </div>
    <div class="panel-footer">유저 게시판</div>

</body>
</html>