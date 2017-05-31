<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commonhead.jsp" %>
<% %>
<body>

<div class="container">

    <h3 class="text text-center text-primary">
        <img src="${pageContext.request.contextPath}/resource/images/logo.jpg" alt="..." class="img-circle" width="100" height="100">
        <strong>高校文档管理系统登录</strong>
    </h3>
    <div class="panel panel-primary text-center">
        <div class="panel panel-heading">
            <label class="label label-primary">
                <h4> 用户登录</h4>
            </label>
        </div>
        <div class="panel panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">

                    <strong>用户名:</strong>
                    <input type="text" id="loginusername" placeholder="请输入用户名" required>
                </div>
                <div class="form-group">

                    <strong>密&nbsp;&nbsp;&nbsp;码:</strong>
                    <input type="password" id="loginpassword" placeholder="请输入密码" required>
                </div>
                <div class="form-group">

                    <strong>用户类型:</strong>
                    <input type="radio" name="type" value="admin" placeholder="管理员" checked="checked" required> 管理员
                    <input type="radio" name="type"  value="teacher" placeholder="教师"  required> 教师
                </div>

                <div class="form-group">
                    <c:if test="${message!=null}">
                        <div class="alert alert-danger text text-center" role="alert">
                                ${message}
                        </div>
                    </c:if>
                    <input type="button" id="loginBtn" class="btn btn-success" value="登录">
                    <input type="reset" id="registBtn" class="btn btn-danger" value="重置">
                </div>

            </form>
        </div>
    </div>


</div>

<%@include file="/WEB-INF/jsp/commonBottom.jsp" %>
<%@include file="/WEB-INF/jsp/commonjs.jsp" %>

<script>

    $(function () {

        function adminLogin() {
            var username = $("#loginusername").val();
            var password = $("#loginpassword").val();
            if (username == "" || password == "") {
                Alert("账号或者密码不能能为空");
                return;
            } else {

                var user = {
                    "username": username,
                    "password": password
                };

                $.post("${pageContext.request.contextPath}/auth/login", user, function (data) {
                    if (data && data.success) {
                        window.location.href = "${pageContext.request.contextPath}/topage/index";
                    } else {
                        Alert(data.message);
                    }
                });

            }
        }

        function teacherLogin() {
            var username = $("#loginusername").val();
            var password = $("#loginpassword").val();
            if (username == "" || password == "") {
                Alert("账号或者密码不能能为空");
                return;
            } else {

                var user = {
                    "username": username,
                    "password": password
                };

                $.post("${pageContext.request.contextPath}/auth/teacherLogin", user, function (data) {
                    if (data && data.success) {
                        window.location.href = "${pageContext.request.contextPath}/topage/index";
                    } else {
                        Alert(data.message);
                    }
                });

            }
        }
        //登录
        $("#loginBtn").click(function () {
            var type=$('input:radio[name="type"]:checked').val();
            if("admin"==type){
                //admin登录
               adminLogin();
            }else if("teacher"==type){
                teacherLogin();
            }

        });


    });
</script>
</body>
</html>
