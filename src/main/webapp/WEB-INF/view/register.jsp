
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
      <form action="${ctx}/board/register" method="post">
        <input type="hidden" name="memId" value="${loginSuccess.memId}">
        <div class="form-group">
          <label>제목</label>
          <input type="text" name="title" class="form-control"/>
        </div>
        <div class="form-group">
          <label>내용</label>
          <textarea rows="10"  name="content" class="form-control"></textarea>
        </div>
        <div class="form-group">
          <label>작성자</label>
          <input type="text" readonly="readonly" name="writer" class="form-control" value="${loginSuccess.memName}"/>
        </div>
        <button type="submit" class="btn btn-default btn-sm">등록</button>
        <button type="reset" class="btn btn-default btn-sm">취소</button>
      </form>

    </div>

  </div>
</div>
<div class="panel-footer">유저 게시판</div>

</body>
</html>