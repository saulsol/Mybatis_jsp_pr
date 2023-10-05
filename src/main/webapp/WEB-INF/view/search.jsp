
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
                var result ='${result}';
                // 등록된 게시물의 결과
                checkModal(result);

                $("#regBtn").click(function (){
                    location.href="${ctx}/board/register";
                });
            });

        function checkModal(result) {
            if(result === ''){
                return;
            } else{
                // 모달 띄우기
                $("#modal-body").html("알림 : "+result);
            }
            $("#myModal").modal('show');

        }



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
                    <button type="button" class="btn btn-default" onclick=location.href="${ctx}/member/register">회원가입</button>
                </form>
            </c:if>

            <c:if test="${!empty loginSuccess}">
                <form class="form-inline" action="${ctx}/login/logoutProcess" method="post">

                    <label>${loginSuccess.memName}님 방문을 환영합니다.</label>
                    <button type="submit" class="btn btn-default">로그아웃</button>
                </form>
            </c:if>

            <c:if test="${!empty loginSuccess}">
                <form action="${ctx}/board/search?content=${content}" method="post" >
                    <div class="input-group ">
                        <input type="text" class="form-control pull-right" placeholder="검색" value="${content}">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </c:if>

        </div>
        <div class="panel-body">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
                </thead>
                <c:forEach var="board" items="${matchBoardList}">
                    <tr>
                        <td>${board.idx}</td>
                        <td><a href="${ctx}/board/get?idx=${board.idx}">${board.title}</a></td>
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

            <!--패이징 처리 뷰 -->
            <div class="pull-right" >
                <ul class="pagination">
                    <c:if test="${pageMaker.prev}">
                        <li class="paginate_button previous">
                            <a href="${ctx}/board/list?page=${pageMaker.startPage-1}">◀</a>
                        </li>
                    </c:if>


                    <c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        <c:if test="${pageMaker.pageInfo.page!=pageNum}">
                            <li><a href="${ctx}/board/search?page=${pageNum}&content=${content}">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageMaker.pageInfo.page==pageNum}">
                            <li><a href="${ctx}/board/search?page=${pageNum}&content=${content}">${pageNum}</a></li>
                        </c:if>
                    </c:forEach>


                    <c:if test="${pageMaker.next}">
                        <li class="paginate_button next">
                            <a href="${ctx}/board/list?page=${pageMaker.endPage+1}">▶</a>
                        </li>
                    </c:if>
                </ul>
            </div>




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
<div class="panel-footer">유저 게시판</div>

</body>
</html>