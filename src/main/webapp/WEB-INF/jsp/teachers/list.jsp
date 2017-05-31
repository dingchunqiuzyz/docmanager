
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp"%>

<body>
<%@include file="/WEB-INF/jsp/commonNav.jsp"%>
<div class="container-fluid">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title text-center">教师信息管理</h3>
        </div>
        <div class="panel-body">
            <form class="form-inline col-sm-offset-2" id="userForm" action="${pageContext.request.contextPath}/teachers/list" method="post">
                <input type="hidden" id="pageNum" name="pageNum" value="${info.pageNum}"/>
                <input class="form-control" type="text" name="teacherName" value="${teachers.teacherName}" placeholder="姓名">
                <input class="form-control" type="text" name="realName" value="${teacherCode.teacherCode}" placeholder="教工号">
                <button class="btn bg-primary glyphicon glyphicon-zoom-in" id="btnSearch" type="submit">搜索</button>
                <button class="btn btn-primary glyphicon glyphicon-plus form-control" id="btnAdd" type="button">添加</button>
            </form>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>教工号</th>
                    <th>学院</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${info.list}" var="t" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${t.teacherName}</td>
                        <td>${t.teacherCode}</td>
                        <td>${t.college}</td>
                        <td><a class="btn btn-link glyphicon glyphicon-pencil" href="javascript:;" onclick="teachers.query('${t.teacherId}')">修改</a>|<a
                                class="btn btn-link glyphicon glyphicon-ban-circle" href="javascript:;" onclick="teachers.delete('${t.teacherId}')">删除</a></td>
                    </tr>
                </c:forEach>

                <c:if test="${info.size==0}">
                    <tr>
                        <td colspan="6" class="text text-center text-danger">没有搜索到结果</td>

                    </tr>

                </c:if>

                </tbody>
            </table>
            <div class="panel-footer">
                <c:if test="${info.size>0}">
                    <nav>
                        <ul class="pagination pull-right">
                            <li><a href="javascript:;" onclick="teachers.judgePage(1)">
                                <div class="text-primary">首页</div>
                            </a></li>
                            <c:forEach items="${info.navigatepageNums}" var="pageNum">
                                <li ${info.pageNum==pageNum?'class="active"':''}><a href="javascript:;" onclick="teachers.judgePage(${pageNum})">${pageNum} </a></li>
                            </c:forEach>
                            <li><a href="javascript:;" onclick="teachers.judgePage(${info.lastPage})">
                                <div class="text-primary">尾页</div>
                            </a></li>
                        </ul>
                    </nav>
                </c:if>
            </div>
        </div>

    </div>
    <!--表格结束 -->

    <!-- 用户信息界面-->
    <div class="modal fade" id="teacherModel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">

                    <div class="panel panel-success  text-center wd">
                        <div class="panel-heading"><h3 class="text">教师信息</h3></div>
                        <input type="hidden" id="teacherId" />
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" id="form">

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">教师姓名:</label>
                                    <div class="col-sm-8 ">
                                        <input type="text" id="teacherName" class="form-control" placeholder="请输入姓名" required/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">所在学院:</label>
                                    <div class="col-sm-8 ">
                                        <select id="college" class="form-control" placeholder="请选择学院" required>

                                            <option value="">请选择</option>
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">教工号:</label>
                                    <div class="col-sm-8 ">
                                        <input type="number" id="teacherCode" class="form-control" placeholder="请输入教工号" required/>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-sm-3 control-label">密码:</label>
                                    <div class="col-sm-8 ">
                                        <input type="password" id="password" class="form-control" placeholder="请输入密码" required/>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="panel-footer panel-success">
                            <button class="btn btn-success " type="button" id="editBtn">确定</button>
                            <button class="btn btn-success " type="button" id="closeBtn">关闭</button>
                        </div>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!-- 用户信息界面结束-->

</div>
</body>
<%@include file="/WEB-INF/jsp/commonBottom.jsp" %>
<%@include file="/WEB-INF/jsp/commonjs.jsp"%>
<%--本页面用到的js --%>
<script>
    common.init('${pageContext.request.contextPath}');
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/teacher.js"></script>
</html>