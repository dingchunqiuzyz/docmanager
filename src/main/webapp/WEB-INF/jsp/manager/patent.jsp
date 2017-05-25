
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
      <h3 class="panel-title text-center">专利类文档管理</h3>
    </div>
    <div class="panel-body">
      <form class="form-inline col-sm-offset-1" id="userForm" action="/patent/manager" method="post">
        <input type="hidden" id="pageNum" name="pageNum" value="${info.size==0?'1':info.pageNum}"/>
        <input class="form-control" type="text" name="patName" value="${patName}" placeholder="专利名称">
        <c:if test="${sessionScope.teacher!=null}">
          <input class="form-control" type="text" name="teacherName" value="${sessionScope.teacher.teacherName}" readonly="readonly" placeholder="教师姓名">
          <input class="form-control" type="number" name="teacherCode" readonly="readonly" value="${sessionScope.teacher.teacherCode}" placeholder="教工号">
        </c:if>
        <c:if test="${sessionScope.teacher==null}">
          <input class="form-control" type="text" name="teacherName" value="${teacherName}" placeholder="教师姓名">
          <input class="form-control" type="number" name="teacherCode" value="${teacherCode}" placeholder="教工号">
        </c:if>

        <button class="btn bg-primary glyphicon glyphicon-zoom-in" id="btnSearch" type="submit">搜索</button>
      </form>

      <table class="table table-hover">
        <thead>
        <tr>
          <th>序号</th>
          <th>专利名称</th>
          <th>专利类型</th>
          <th>专利代码</th>
          <th>申请日期</th>
          <th>作者</th>
          <th>专利权人</th>
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
            <td>${p.patName}</td>
            <td>${p.patType}</td>
            <td>${p.patCode}</td>
            <td><fmt:formatDate value="${p.patDate}" pattern="yyyy-MM-dd"/></td>
            <td>${p.teachers.teacherName}</td>
            <td>${p.patTeacherName}</td>
            <td>${p.patTeacherOrder}</td>
            <td>${p.fkTeacherCode}</td>
            <td>${p.teachers.college}</td>
            <td><a class="btn btn-link glyphicon glyphicon-pencil" href="javascript:;" onclick="patent.query('${p.patUuid}')">修改</a>|<a
                    class="btn btn-link glyphicon glyphicon-ban-circle" href="javascript:;" onclick="patent.delete('${p.patUuid}')">删除</a></td>
          </tr>
        </c:forEach>

        <c:if test="${info.size==0}">
          <tr>
            <td colspan="11" class="text text-center text-danger">没有搜索到结果</td>

          </tr>

        </c:if>

        </tbody>
      </table>
      <div class="panel-footer">
        <c:if test="${info.size>0}">
          <nav>
            <ul class="pagination pull-right">
              <li><a href="javascript:;" onclick="patent.judgePage(1)">
                <div class="text-primary">首页</div>
              </a></li>
              <c:forEach items="${info.navigatepageNums}" var="pageNum">
                <li ${info.pageNum==pageNum?'class="active"':''}><a href="javascript:;" onclick="patent.judgePage(${pageNum})">${pageNum} </a></li>
              </c:forEach>
              <li><a href="javascript:;" onclick="patent.judgePage(${info.lastPage})">
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
            <div class="panel-heading"><h5 class="text">专利信息修改</h5></div>
            <div class="panel-body">
              <input type="hidden" id="patUuid" />
              <input type="hidden" id="fkTeacherCode" />
              <form class="form-horizontal" role="form">
                <div class="form-group">
                  <label class="col-sm-2 control-label">专利名称:</label>

                  <div class="col-sm-4 ">
                    <input type="text" id="patName" name="patName" class="form-control" placeholder="请输入专利名"/>
                  </div>
                  <label class="col-sm-2 control-label">专利类型:</label>

                  <div class="col-sm-4 ">
                    <select class="form-control" id="patType" placeholder="类型">
                      <option value="发明专利">发明专利</option>
                      <option value="实用新型专利">实用新型专利</option>
                      <option value="外观设计专利">外观设计专利</option>
                      <option value="软件著作权(已发表)">软件著作权(已发表)</option>
                      <option value="软件著作权(未发表)">软件著作权(未发表)</option>
                    </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">通过时间:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="patDate"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="申请通过时间"/>
                  </div>
                  <label class="col-sm-2 control-label">专利代码:</label>

                  <div class="col-sm-4 ">
                    <input type="text" id="patCode" class="form-control" placeholder="专利代码"/>
                  </div>

                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">作者排名:</label>

                  <div class="col-sm-4 ">
                    <input type="number" id="patTeacherOrder" class="form-control" placeholder="作者排名"/>
                  </div>

                  <label class="col-sm-2 control-label">专利权人:</label>

                  <div class="col-sm-4 ">
                    <input type="text" id="patTeacherName" class="form-control" placeholder="专利权人"/>
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
              <button class="btn btn-success " type="button" id="patentUpdateBtn">确定</button>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/patent.js"></script>
</html>