
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp"%>
<link rel="stylesheet" type="text/css"
      href="/resource/css/webuploader.css">
<body>
<%@include file="/WEB-INF/jsp/commonNav.jsp"%>
<div class="container-fluid">
  <div class="panel panel-primary">
    <div class="panel-heading">
      <h3 class="panel-title text-center">项目类文档管理</h3>
    </div>
    <div class="panel-body">
      <form class="form-inline col-sm-offset-1" id="userForm" action="/project/manager" method="post">
        <input type="hidden" id="pageNum" name="pageNum" value="${info.size==0?'1':info.pageNum}"/>
        <input class="form-control" type="text" name="proName" value="${proName}" placeholder="项目名称">
        <input class="form-control" type="text" name="teacherName" value="${teacherName}" placeholder="教师姓名">
        <button class="btn bg-primary glyphicon glyphicon-zoom-in" id="btnSearch" type="submit">搜索</button>
      </form>

      <table class="table table-hover">
        <thead>
        <tr>
          <th>序号</th>
          <th>名称</th>
          <th>成果类型</th>
          <th>来源</th>
          <th>经费（万元）</th>
          <th>申请时间</th>
          <th>结题时间</th>
          <th>作者</th>
          <th>作者排名</th>
          <th>作者编号</th>
          <th>作者信息</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${info.list}" var="p" varStatus="vs">
          <tr>
            <td>${vs.count}</td>
            <td>${p.proName}</td>
            <td>${p.proLevel}</td>
            <td>${p.proSource}</td>
            <td>${p.proFunds}</td>
            <td><fmt:formatDate value="${p.proStartDate}" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${p.proEndDate}" pattern="yyyy-MM-dd"/></td>
            <td>${p.teachers.teacherName}</td>
            <td>${p.proTeacherOrder}</td>
            <td>${p.fkTeacherCode}</td>
            <td>${p.teachers.college}</td>
            <td><a class="btn btn-link glyphicon glyphicon-pencil" href="javascript:;" onclick="project.query('${p.proUuid}')">修改</a>|<a
                    class="btn btn-link glyphicon glyphicon-ban-circle" href="javascript:;" onclick="project.delete('${p.proUuid}')">删除</a></td>
          </tr>
        </c:forEach>

        <c:if test="${info.size==0}">
          <tr>
            <td colspan="10" class="text text-center text-danger">没有搜索到结果</td>

          </tr>

        </c:if>

        </tbody>
      </table>
      <div class="panel-footer">
        <c:if test="${info.size>0}">
          <nav>
            <ul class="pagination pull-right">
              <li><a href="javascript:;" onclick="project.judgePage(1)">
                <div class="text-primary">首页</div>
              </a></li>
              <c:forEach items="${info.navigatepageNums}" var="pageNum">
                <li ${info.pageNum==pageNum?'class="active"':''}><a href="javascript:;" onclick="project.judgePage(${pageNum})">${pageNum} </a></li>
              </c:forEach>
              <li><a href="javascript:;" onclick="project.judgePage(${info.lastPage})">
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
  <div class="modal bs-example-modal-lg fade" id="modal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-body">

          <div class="panel panel-primary  text-center ">
            <div class="panel-heading"><h5 class="text">科研项目信息修改</h5></div>
            <div class="panel-body">
              <input type="hidden" id="proUuid" />
              <input type="hidden" id="fkTeacherCode" />
              <form class="form-horizontal" role="form">
                <div class="form-group">
                  <label class="col-sm-2 control-label">项目名称:</label>

                  <div class="col-sm-4 ">
                    <input type="text" id="proName" name="proName" class="form-control" placeholder="请输入项目名"/>
                  </div>
                  <label class="col-sm-2 control-label">项目类型:</label>

                  <div class="col-sm-4 ">
                    <select class="form-control" id="proLevel" placeholder="项目类型">
                      <option value="国家级科技成果一等奖">国家级科技成果一等奖</option>
                      <option value="国家级科技成果二等奖">国家级科技成果二等奖</option>
                      <option value="省部级政府奖项一等奖">省部级政府奖项一等奖</option>
                      <option value="省部级政府奖项二等奖">省部级政府奖项二等奖</option>
                      <option value="省部级政府奖项三等奖">省部级政府奖项三等奖</option>
                      <option value="副省级政府奖项一等奖">副省级政府奖项一等奖</option>
                      <option value="副省级政府奖项二等奖">副省级政府奖项二等奖</option>
                      <option value="副省级政府奖项三等奖">副省级政府奖项三等奖</option>
                      <option value="市厅级政府奖项一等奖">市厅级政府奖项一等奖</option>
                      <option value="市厅级政府奖项二等奖">市厅级政府奖项二等奖</option>
                      <option value="市厅级政府奖项三等奖">市厅级政府奖项三等奖</option>
                    </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">项目来源:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="proSource"
                           placeholder="项目来源"/>
                  </div>

                  <label class="col-sm-2 control-label">项目经费(万元):</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="proFunds"
                           placeholder="项目经费(万元)"/>
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-sm-2 control-label">申报时间:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="proStartDate"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="发表时间"/>
                  </div>

                  <label class="col-sm-2 control-label">结题时间:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="proEndDate"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="发表时间"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">作者排名:</label>

                  <div class="col-sm-4 ">
                    <input type="number" id="proTeacherOrder" class="form-control" placeholder="作者排名"/>
                  </div>
                </div>

                <div id="uploader" class="wu-example">
                  <!--用来存放文件信息-->
                  <div id="thelist" class="uploader-list"></div>
                </div>
                <div class="form-group">
                  <label class="col-sm-4 col-sm-offset-2" id="picker">
                    选中文件
                  </label>

                  <div class="col-sm-2 ">
                    <button id="ctlBtn" class="btn btn-primary" type="button">开始上传</button>
                  </div>
                </div>

              </form>
            </div>
            <div class="panel-footer panel-success">
              <button class="btn btn-success " type="button" id="projectUpdateBtn">确定</button>
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

<%@include file="/WEB-INF/jsp/commonjs.jsp"%>
<%@include file="/WEB-INF/jsp/commonBottom.jsp" %>

<%--本页面用到的js --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="/resource/js/webuploader.js"></script>
<script type="text/javascript" src="/resource/js/engine/upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/project.js"></script>
</html>