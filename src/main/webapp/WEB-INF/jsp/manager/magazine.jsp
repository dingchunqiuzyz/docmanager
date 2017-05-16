
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
      <h3 class="panel-title text-center">学术论文管理</h3>
    </div>
    <div class="panel-body">
      <form class="form-inline col-sm-offset-1" id="userForm" action="/magazine/manager" method="post">
        <input type="hidden" id="pageNum" name="pageNum" value="${info.size==0?'1':info.pageNum}"/>
        <input class="form-control" type="text" name="magName" value="${magName}" placeholder="论文题目">
        <input class="form-control" type="text" name="teacherName" value="${teacherName}" placeholder="教师姓名">
        <button class="btn bg-primary glyphicon glyphicon-zoom-in" id="btnSearch" type="submit">搜索</button>
      </form>

      <table class="table table-hover">
        <thead>
        <tr>
          <th>序号</th>
          <th>论文题目</th>
          <th>成果类别</th>
          <th>发表时间</th>
          <th>作者排名</th>
          <th>校内排名</th>
          <th>检索情况</th>
          <th>作者</th>
          <th>作者编号</th>
          <th>作者信息</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${info.list}" var="m" varStatus="vs">
          <tr>
            <td>${vs.count}</td>
            <td>${m.magName}</td>
            <td>${m.magLevel}</td>
            <td><fmt:formatDate value="${m.magPubDate}" pattern="yyyy-MM-dd"/></td>
            <td>${m.magTeacherOrder}</td>
            <td>${m.magSchoolOrder}</td>
            <td>${m.magDeac}</td>
            <td>${m.teachers.teacherName}</td>

            <td>${m.fkTeacherCode}</td>
            <td>${m.teachers.college}-${m.teachers.major}</td>
            <td><a class="btn btn-link glyphicon glyphicon-pencil" href="javascript:;" onclick="magazine.query('${m.magUuid}')">修改</a>|<a
                    class="btn btn-link glyphicon glyphicon-ban-circle" href="javascript:;" onclick="magazine.delete('${m.magUuid}')">删除</a></td>
          </tr>
        </c:forEach>

        <c:if test="${info.size==0}">
          <tr>
            <td colspan="9" class="text text-center text-danger">没有搜索到结果</td>

          </tr>

        </c:if>

        </tbody>
      </table>
      <div class="panel-footer">
        <c:if test="${info.size>0}">
          <nav>
            <ul class="pagination pull-right">
              <li><a href="javascript:;" onclick="magazine.judgePage(1)">
                <div class="text-primary">首页</div>
              </a></li>
              <c:forEach items="${info.navigatepageNums}" var="pageNum">
                <li ${info.pageNum==pageNum?'class="active"':''}><a href="javascript:;" onclick="magazine.judgePage(${pageNum})">${pageNum} </a></li>
              </c:forEach>
              <li><a href="javascript:;" onclick="magazine.judgePage(${info.lastPage})">
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
            <div class="panel-heading"><h5 class="text">论文信息修改</h5></div>
            <div class="panel-body">
              <form class="form-horizontal" role="form">
                <input type="hidden" id="magUuid" />
                <input type="hidden" id="fkTeacherCode" />
                <div class="form-group">
                  <label class="col-sm-2 control-label">论文题目:</label>

                  <div class="col-sm-4 ">
                    <input type="text" id="magName" class="form-control" placeholder="论文题目"/>
                  </div>
                  <label class="col-sm-2 control-label">成果类型:</label>

                  <div class="col-sm-4 ">
                    <select class="form-control" id="magLevel" placeholder="成果类型">
                      <option value="在《自然》、《科学》、《中国科学》、《中国社会科学》上发表">在《自然》、《科学》、《中国科学》、《中国社会科学》上发表</option>
                      <option value="在《科学通报》上发表，或者被《SCI》、《SSCI》全文索引">在《科学通报》上发表，或者被《SCI》、《SSCI》全文索引</option>
                      <option value="在国家一级学会所属期刊、全国中文重要期刊上发表">在国家一级学会所属期刊、全国中文重要期刊上发表</option>
                      <option value="重要报刊上发表学术理论文章">重要报刊上发表学术理论文章</option>
                      <option value="被国家权威社科机构全文索引">被国家权威社科机构全文索引</option>
                      <option value="在全国中文核心期刊上发表">在全国中文核心期刊上发表</option>
                      <option value="在国际学术会议论文集上发表">在国际学术会议论文集上发表</option>
                      <option value="在公开出版的一般学术期刊上发表">在公开出版的一般学术期刊上发表</option>
                      <option value="在本校学报（教育科学版）上发表">在本校学报（教育科学版）上发表</option>
                      <option value="重要报刊上发表学术专业文章">重要报刊上发表学术专业文章</option>
                      <option value="批号学术会议发表">批号学术会议发表</option>
                      <option value="省级报纸发表">省级报纸发表</option>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-sm-2 control-label">作者排名:</label>

                  <div class="col-sm-4 ">
                    <input type="number" class="form-control" min="1" id="magTeacherOrder"
                           placeholder="作者排名"/>
                  </div>
                  <label class="col-sm-2 control-label ">发表时间:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="magPubDate"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="发表时间"/>
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-sm-2 control-label">本校排名:</label>

                  <div class="col-sm-4 ">
                    <input type="number" class="form-control" min="1" id="magSchoolOrder"
                           placeholder="作者排名"/>
                  </div>
                  <label class="col-sm-2 control-label ">检索情况:</label>

                  <div class="col-sm-4 ">
                    <input type="text" class="form-control" id="magDeac"
                           placeholder="论文检索情况"/>
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
              <button class="btn btn-success " type="button" id="updateMagazineBtn">确定</button>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/magazine.js"></script>
</html>