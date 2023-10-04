<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">



        function doubleCheck(){
            if($("#id").val() == ''){
                alert("아이디를 입력하세요.")
                $("#id").focus;
                return;
            }
            var id = $("#id").val();

            $.ajax({
                url :"<c:url value='${ctx}/member/check'/>",
                type : "POST",
                data : {"id" : id},
                success : dbCheck,             // callback 함수
                error : function() {
                    alert("error");
                }

            });
        }

        function dbCheck(data){
            if(data == "YES"){
                alert("중복된 아이디 입니다.")
                $("#id").focus();
            }else{
                alert("사용가능한 아이디 입니다.");
                $("#id").focus();
            }
        }



    </script>
</head>
<body>
<div class="container">
    <h2>회원가입화면</h2>
    <div class="panel panel-default">

        <div class="panel-body">
            <form id="form1" name="form1" action="${ctx}/member/register" class="form-horizontal" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id">아이디:</label>
                    <div class="col-sm-10">
                        <table>
                            <tr>
                                <td><input type="text" class="form-control" id="id" name="memId" placeholder="아이디를 입력하세요" style="width: 80%"></td>
                                <td><input type="button" onclick="doubleCheck()" value="중복체크" class="btn btn-warning"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pass">비밀번호:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="pass" name="memPwd" placeholder="비밀번호를 입력하세요" style="width: 30%">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">이름:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="memName" placeholder="이름을 입력하세요" style="width: 30%">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="pass">전화번호:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="memPhone" placeholder="전화번호를 입력하세요" style="width: 30%">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="pass">주소:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="addr" name="memAddr" placeholder="주소를 입력해주세요" style="width: 30%">
                    </div>
                </div>


                <div class="panel-footer" style="text-align: center;">

                <c:if test="${sessionScope.loginSuccess==null || sessionScope.loginSuccess==''}">
                <input type="submit" value="등록" class='btn btn-primary' />
                </c:if>
                <c:if test="${sessionScope.loginSuccess!=null && sessionScope.loginSuccess!=''}">
                    <input type="submit" value="등록" class='btn btn-primary'  disabled="disabled"/>
                </c:if>


                </div>
        </form>
    </div>
</div>
</body>
</html>