<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>

<body>
<%@include file="/WEB-INF/jsp/commonNav.jsp" %>


<div class="container ">
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/teachers/batchImport" method="post" enctype="multipart/form-data">
        <div class="panel panel-primary  text-center wd">
            <div class="panel-heading"><h5 class="text">教师信息批量导入</h5></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-3 text-left">
                        <h6>
                            <small>批量导入使用说明：</small>
                        </h6>
                        <h6>
                            <small>1.下载[教师信息批量导入模板.xlsx]</small>
                        </h6>
                        <h6>
                            <small>2.按照格式将教师信息填写到excel中</small>
                        </h6>
                        <h6>
                            <small>3.将excel上传</small>
                        </h6>
                    </div>
                    <div class="col-lg-9">

                        <div class="form-group">
                            <label class="col-sm-3 control-label">导入模板下载:</label>
                            <div class="col-sm-8 ">
                                <a href="${pageContext.request.contextPath}/download/teacherTemplate" class="btn-link">教师信息批量导入模板.xlsx</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">选择文件:</label>
                            <div class="col-sm-8 ">
                                <input type="file" name="file"
                                       accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                                       class="form-control" placeholder="请输入教工号"/>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            <div class="panel-footer panel-success">
                <input type="submit"  class="btn btn-success " value="确定"/>
                <input type="reset" class="btn btn-success " value="重置"/>
            </div>
        </div>
    </form>
</div>
<%@include file="/WEB-INF/jsp/commonjs.jsp" %>
<%--本页面用到的js --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/teacher.js"></script>
</body>
</html>