<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default bgcolor " role="navigation">
  <div class="container-fluid">
    <!-- 页面变窄时显示-->
    <div class="navbar-header text-center text-primary">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">标记</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/topage/index"><img src="${pageContext.request.contextPath}/resource/images/logo.jpg" alt="..." class="img-circle" width="40" height="40"></a>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/topage/index">学院科研文档管系统</a>

    </div>
    <!-- 真正的导航链接-->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.request.contextPath}/search/list">文件检索</a></li>
        <li><a href="${pageContext.request.contextPath}/topage/hasupload">文件上传</a></li>
        <!-- 管理员账户才显示-->
        <c:if test="${sessionScope.users!=null}">
        <li><a href="${pageContext.request.contextPath}/users/list">系统用户管理</a></li>

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">基础数据管理 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${pageContext.request.contextPath}/college/list">学院信息管理</a></li>
            <li><a href="${pageContext.request.contextPath}/teachers/list">教师信息管理</a></li>
            <li><a href="${pageContext.request.contextPath}/teachers/toPage/import">教师信息批量导入</a></li>
          </ul>
        </li>
        </c:if>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">文件管理 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="${pageContext.request.contextPath}/magazine/manager">学术论文类管理</a></li>
            <li><a href="${pageContext.request.contextPath}/project/manager">科研项目类管理</a></li>
            <li><a href="${pageContext.request.contextPath}/work/manager">著作书籍类管理</a></li>
            <li><a href="${pageContext.request.contextPath}/patent/manager">专利类管理</a></li>
            <li><a href="${pageContext.request.contextPath}/prize/manager">成果获奖类管理</a></li>
            <li><a href="${pageContext.request.contextPath}/honour/manager">成果转化类管理</a></li>
            <li><a href="${pageContext.request.contextPath}/report/manager">论证报告类管理</a></li>
          </ul>
        </li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li><a href="javascript:;" id="updateBtn">个人信息修改</a></li>
        <li><a href="${pageContext.request.contextPath}/auth/logout">退出登录</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- 用户信息修改-->
<div class="modal fade" id="loginUser">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
        <div class="panel panel-success  text-center ">
          <div class="panel-heading"><h3 class="text">账户信息</h3></div>
          <div class="panel-body">
            <form class="form-horizontal" role="form">
              <div class="form-group">
                <label class="col-sm-3 control-label">账号:</label>
                <div class="col-sm-8 ">
                  <input type="text" id="loginUsername" readonly="readonly" class="form-control" placeholder="请输入账号" required/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">密码:</label>
                <div class="col-sm-8 ">
                  <input type="password" id="loginPassword" class="form-control" placeholder="请输入密码" required/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">姓名:</label>
                <div class="col-sm-8 ">
                  <input type="text" id="loginRealName" class="form-control" placeholder="请输入姓名" required/>
                </div>
              </div>
            </form>

          </div>
          <div class="panel-footer panel-success">
            <button class="btn btn-success" type="button" id="loginUpdateBtn">确定</button>
            <button class="btn btn-success" type="button" data-dismiss="modal">关闭</button>
          </div>
        </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<div class="modal fade" id="loginteacherModel">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">

        <div class="panel panel-success  text-center wd">
          <div class="panel-heading"><h3 class="text">教师信息</h3></div>
          <input type="hidden" id="loginTeacherId" />
          <div class="panel-body">
            <form class="form-horizontal" role="form" id="form">

              <div class="form-group">
                <label class="col-sm-3 control-label">教师姓名:</label>
                <div class="col-sm-8 ">
                  <input type="text" id="loginTeacherName" class="form-control" placeholder="请输入姓名" required/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">所在学院:</label>
                <div class="col-sm-8 ">
                  <select id="loginCollege" class="form-control" placeholder="请选择学院" required>

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label">教工号:</label>
                <div class="col-sm-8 ">
                  <input type="number" id="loginTeacherCode" readonly="readonly" class="form-control" placeholder="请输入教工号" required/>
                </div>
              </div>


              <div class="form-group">
                <label class="col-sm-3 control-label">密码:</label>
                <div class="col-sm-8 ">
                  <input type="password" id="loginTeacherPassword" class="form-control" placeholder="请输入密码" required/>
                </div>
              </div>

            </form>
          </div>
          <div class="panel-footer panel-success">
            <button class="btn btn-success " type="button" id="loginTeacherEditBtn">确定</button>
            <button class="btn btn-success " type="button"  data-dismiss="modal">关闭</button>
          </div>
        </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
  $(function(){

      function updateLoginTeacherInfo() {
          $.get(common.basePath+"/college/queryAll", function(result){
              //学院下拉框
              var selectNode=$("#loginCollege");
              if(result&&result.success) {
                  //查询成功
                  var data = result.data;
                  //为option 添加子节点
                  //先删除所有子节点
                  selectNode.empty();

                  selectNode.append("<option value=\"\">请选择...</option>");
                  $.each(data, function (key, value) {

                      selectNode.append("<option value=" + value.collegeName + ">" + value.collegeName + "</option>");
                  });
                  $("#loginCollege").val('${sessionScope.teacher.college}');
              }
          });

          $("#loginTeacherId").val('${sessionScope.teacher.teacherId}');
          $("#loginTeacherName").val('${sessionScope.teacher.teacherName}');
          $("#loginTeacherCode").val('${sessionScope.teacher.teacherCode}');
          $("#loginCollege").val('${sessionScope.teacher.college}');
          $("#loginTeacherPassword").val('${sessionScope.teacher.password}');

          $("#loginteacherModel").modal({
              backdrop: 'static',//不可后退
              keyboard: false//进制键盘事件
          }).show();


      }

      $("#loginTeacherEditBtn").click(function () {


          var teacherId= $("#loginTeacherId").val();
          var teacherName=$("#loginTeacherName").val();
          var teacherCode= $("#loginTeacherCode").val();
          var college= $("#loginCollege").val();
          var password= $("#loginTeacherPassword").val();

          var teacher={
              "teacherId":teacherId,
              "teacherName":teacherName,
              "teacherCode":teacherCode,
              "college":college,
              "password":password
          };
          $.post(common.basePath+"/teachers/edit",teacher,function(data){
              if(data&&data.success){
                  // 编辑成功：隐藏显示框，刷新界面
                  Alert({
                      msg: data.message,
                      onOk: function(){
                          window.location.reload();
                      }

                  });

              }else{//显示错误信息
                  Alert(data['message']);
              }
          });
      });

    $("#updateBtn").click(function(){
      ////管理员修改
        if(${sessionScope.users!=null}){
            $("#loginUsername").val('${sessionScope.users.username}');
            $("#loginPassword").val('${sessionScope.users.password}');
            $("#loginRealName").val('${sessionScope.users.realName}');

            $("#loginUser").modal({
                backdrop: 'static',//不可后退
                keyboard: false//进制键盘事件
            }).show();
        }
        ///////教师修改
        if(${sessionScope.teacher!=null}){
            updateLoginTeacherInfo();
        }

    });

    $("#loginUpdateBtn").click(function(){
      //修改
      var username=$("#loginUsername").val();
      var password=$("#loginPassword").val();
      var realName=$("#loginRealName").val();
      var user={
        "userId":'${sessionScope.users.userId}',
        "username":username,
        "password":password,
        "realName":realName,
        "userType":'${sessionScope.users.userType}'
      };

      $.post(common.basePath+"/users/update",user,function(data){
        if(data&&data.success){
          // 编辑成功：隐藏显示框，刷新界面
          $("#loginUser").modal('hide');
          Alert({
            msg:data.message,
            onOk:function(){
              window.location.reload();
            }
          });

          //刷新界面
        }else{//显示错误信息
          Alert(data['message']);
        }
      });

    });

    //关闭窗口
    $("#loginCloseBtn").click(function(){
      $("#loginUser").modal('hide');
    });

  });
</script>