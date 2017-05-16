
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
      <h3 class="panel-title text-center">成果转化类文档管理</h3>
    </div>
    <div class="panel-body">
      <form class="form-inline col-sm-offset-1" id="userForm" action="/honour/manager" method="post">
        <input type="hidden" id="pageNum" name="pageNum" value="${info.size==0?'1':info.pageNum}"/>
        <input class="form-control" type="text" name="hoName" value="${hoName}" placeholder="名称">
        <input class="form-control" type="text" name="teacherName" value="${teacherName}" placeholder="教师姓名">
        <button class="btn bg-primary glyphicon glyphicon-zoom-in" id="btnSearch" type="submit">搜索</button>
      </form>

      <table class="table table-hover">
        <thead>
        <tr>
          <th>序号</th>
          <th>名称</th>
          <th>类型</th>
          <th>起始日期</th>
          <th>结束日期</th>
          <th>项目来源</th>
          <th>转化金额</th>
          <th>作者</th>
          <th>作者排名</th>
          <th>作者编号</th>
          <th>作者信息</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${info.list}" var="h" varStatus="vs">
          <tr>
            <td>${vs.count}</td>
            <td>${h.hoName}</td>
            <td>${h.hoRank}</td>
            <td><fmt:formatDate value="${h.hoStartDate}" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${h.hoEndDate}" pattern="yyyy-MM-dd"/></td>
            <td>${h.hoOrg}</td>
            <td>${h.hoMoney}</td>
            <td>${h.teachers.teacherName}</td>
            <td>${h.hoTeacherOrder}</td>
            <td>${h.teachers.teacherCode}</td>
            <td>${h.teachers.college}-${h.teachers.major}</td>
            <td><a class="btn btn-link glyphicon glyphicon-pencil" href="javascript:;" onclick="honour.query('${h.hoUuid}')">修改</a>|<a
                    class="btn btn-link glyphicon glyphicon-ban-circle" href="javascript:;" onclick="honour.delete('${h.hoUuid}')">删除</a></td>
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
              <li><a href="javascript:;" onclick="honour.judgePage(1)">
                <div class="text-primary">首页</div>
              </a></li>
              <c:forEach items="${info.navigatepageNums}" var="pageNum">
                <li ${info.pageNum==pageNum?'class="active"':''}><a href="javascript:;" onclick="honour.judgePage(${pageNum})">${pageNum} </a></li>
              </c:forEach>
              <li><a href="javascript:;" onclick="honour.judgePage(${info.lastPage})">
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
            <div class="panel-heading"><h5 class="text">成果转化信息修改</h5></div>
            <div class="panel-body">
              <input type="hidden" id="hoUuid" />
              <input type="hidden" id="fkTeacherCode" />
              <form class="form-horizontal" role="form">
                <div class="form-group">
                  <label class="col-sm-2 control-label">名称:</label>

                  <div class="col-sm-4 ">
                    <input type="text" id="hoName" name="hoName" class="form-control" placeholder="名称"/>
                  </div>
                  <label class="col-sm-2 control-label">级别:</label>

                  <div class="col-sm-4 ">
                    <select class="form-control" id="hoRank" placeholder="项目类型">
                      <option value="科技成果转让">科技成果转让</option>
                      <option value="科技成果推广使用">科技成果推广使用</option>
                      <option value="技术开发、技术推广">技术开发、技术推广</option>
                    </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">起始时间:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="hoStartDate"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="起始时间"/>
                  </div>
                  <label class="col-sm-2 control-label">结束时间:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="hoEndDate"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="结束时间"/>
                  </div>



                </div>
                <div class="form-group">

                  <label class="col-sm-2 control-label">项目来源:</label>

                  <div class="col-sm-4 ">
                    <input type="text" id="hoOrg" class="form-control" placeholder="项目来源"/>
                  </div>
                  <label class="col-sm-2 control-label">作者排名:</label>

                  <div class="col-sm-4 ">
                    <input type="number" id="hoTeacherOrder" class="form-control" placeholder="作者排名"/>
                  </div>
                </div>
                <div class="form-group">

                  <label class="col-sm-2 control-label">学校获得转化金额:</label>

                  <div class="col-sm-4 ">
                    <input type="number" id="hoMoney" class="form-control" placeholder="学校获得转化金额"/>
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
                    <button id="ctlBtn" class="btn btn-primary col-sm-offset-1" type="button">开始上传</button>
                  </div>
                </div>

              </form>
            </div>
            <div class="panel-footer panel-success">
              <button class="btn btn-success " type="button" id="honourUpdateBtn">确定</button>
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

<%--本页面用到的js --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="/resource/js/webuploader.js"></script>
<script type="text/javascript" src="/resource/js/engine/upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/honour.js"></script>
</html>