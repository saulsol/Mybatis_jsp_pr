
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



</head>
<body>
<div class="container">
    <h2>게시판</h2>
    <div class="panel panel-default">
        <div class="panel-heading">BOARD</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tr>
                        <td>번호</td>
                        <td>${read.idx}</td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td>${read.title}</td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea rows="10" class="form-control" readonly> ${read.content} </textarea></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td>${read.writer}</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <button class="btn btn-sm btn-primary">답글</button>
                            <button class="btn btn-sm btn-success">수정</button>
                            <button class="btn btn-sm btn-warning">삭제</button>
                            <button class="btn btn-sm btn-info">목록</button>
                        </td>
                    </tr>

                </table>
            </div>
    </div>
</div>
<div class="panel-footer">유저 게시판</div>

</body>
</html>