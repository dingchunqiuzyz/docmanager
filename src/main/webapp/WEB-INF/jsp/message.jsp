
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp"%>

<body>
<%@include file="/WEB-INF/jsp/commonNav.jsp" %>
<div class="container ">
    <div class="panel panel-success  text-center ">
        <div class="panel-heading"><h5 class="text">信息提示</h5></div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-3">
                    <img src="${pageContext.request.contextPath}/resource/images/logo.jpg" alt="..." class="img-circle" width="100" height="100">
                </div>
                <div class="col-lg-6 text-center" style="text-align: center">
                    ${result.message}
                </div>
            </div>
        </div>
        <div class="panel-footer panel-success">
            <button class="btn btn-success " id="know">我知道了</button>
        </div>
    </div>
</div>
</body>

<%@include file="/WEB-INF/jsp/commonBottom.jsp" %>
<%@include file="/WEB-INF/jsp/commonjs.jsp"%>
<script>
    $(function () {
        $("#know").click(function(){
            var url = '${result.data}';
            window.location.href=url;
        });
    });
</script>

</html>