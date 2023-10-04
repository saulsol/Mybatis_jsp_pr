
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
                        <td><input type="text" class="form-control" name="idx" value="${read.idx}" readonly/></td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" class="form-control" name="title" value="${read.title}" readonly/></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea rows="10" class="form-control" name="content" readonly> ${read.content} </textarea></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" class="form-control" name="writer" readonly value="${read.writer}" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <button class="btn btn-sm btn-primary" onclick=location.href="${ctx}/board/reply?idx=${read.idx}">답글</button>
                            <button class="btn btn-sm btn-success" onclick=location.href="${ctx}/board/modify?idx=${read.idx}">수정</button>
                            <button class="btn btn-sm btn-info" onclick=location.href="${ctx}/board/list">목록</button>
                        </td>
                    </tr>

                </table>

            </div>
        <div class="panel-body">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
                </thead>
                <c:forEach var="comment" items="${commentList}">
                    <tr>
                        <td>${comment.commentId}</td>
                        <td>${comment.title}</td>
                        <td>${comment.content}</td>
                        <td>${comment.memName}</td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${comment.inDate}"/></td>

                    </tr>
                </c:forEach>

                <c:if test="${empty commentList}">
                    <tr>
                        <td colspan="4">
                            답글이 없습니다.
                        </td>
                    </tr>
                </c:if>

            </table>

            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Modal Header</h4>
                        </div>
                        <div class="modal-body" id="modal-body">
                            <p>Some text in the modal.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            <!-- Modal end -->


        </div>


            </div>
    </div>
</div>
<div class="panel-footer">유저 게시판</div>

</body>
</html>