
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp"%>
<%@include file="/WEB-INF/jsp/commonNav.jsp"%>
<body>



<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/echarts/echarts.common.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/echarts/macarons.js"></script>
</body>



<div class="container text-center">
    <h1>欢迎使用文档管理系统！<small><a href="https://github.com/zhanyuezhong/docmanager/wiki/%E5%AD%A6%E9%99%A2%E6%96%87%E6%A1%A3%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E" target="_blank"> 查看使用说明</a></small></h1>

    <div class="row">
        <div class="row">
            <div class="col-lg-6">
                <div id="bar" style="width: 70%;height:70%;"></div>
            </div>
            <div class="col-lg-6">
                <div id="pie" style="width: 70%;height:70%;"></div>
            </div>
        </div>

    </div>

</div>
<%@include file="/WEB-INF/jsp/commonBottom.jsp"%>
<script>
    common.init('${pageContext.request.contextPath}');
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/echarts/mychart.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/dialog.js"></script>


</html>