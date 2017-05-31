<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="/resource/css/webuploader.css">
<body>
<%@include file="/WEB-INF/jsp/commonNav.jsp" %>
<div class="container-fluid">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title text-center">学院信息管理</h3>
        </div>
        <div class="panel-body">
            <div class="col-sm-1">
                <button class="btn btn-primary  " id="collegeAddBtn" type="button">
                    添加
                </button>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>学院名称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${colleges}" var="c" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${c.collegeName}</td>
                        <td><a
                                class="btn btn-link glyphicon glyphicon-ban-circle" href="javascript:;"
                                onclick="college.delete('${c.collegeId}')">删除</a></td>
                    </tr>
                </c:forEach>

                <c:if test="${empty colleges}">
                    <tr>
                        <td colspan="2" class="text text-center text-danger">没有搜索到结果</td>

                    </tr>

                </c:if>

                </tbody>
            </table>

        </div>

    </div>
    <!--表格结束 -->

    <!-- 用户信息界面-->
    <div class="modal bs-example-modal-lg fade" id="collegeModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">

                    <div class="panel panel-primary  text-center ">
                        <div class="panel-heading"><h5 class="text">学院信息添加</h5></div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" id="form">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">名称:</label>

                                    <div class="col-sm-10 ">
                                        <input type="text" id="collegeName" name="collegeName" class="form-control"
                                               placeholder="请输入学院名称"/>
                                    </div>

                                </div>

                            </form>
                        </div>
                        <div class="panel-footer panel-success">
                            <button class="btn btn-success " type="button" id="collegeUpdateBtn">确定</button>
                            <button class="btn btn-success " type="button" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<!-- 用户信息界面结束-->


</body>

<%@include file="/WEB-INF/jsp/commonjs.jsp" %>
<%@include file="/WEB-INF/jsp/commonBottom.jsp" %>

<%--本页面用到的js --%>
<script>
    common.init('${pageContext.request.contextPath}');
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/college.js"></script>
</html>