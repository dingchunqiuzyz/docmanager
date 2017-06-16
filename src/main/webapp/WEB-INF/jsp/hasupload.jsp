<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/resource/css/webuploader.css">
<body>
<%@include file="/WEB-INF/jsp/commonNav.jsp"%>
<!-- 已经上传的文件检索-->
<div class="container-fluid">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title text-center">已经上传的文件</h3>
        </div>
        <div class="panel-body">
            <form class="form-inline col-sm-offset-1" id="userForm" action="${pageContext.request.contextPath}/search/hasUpload" method="post">
                <div class="row ">
                    <input type="hidden" id="pageNum" name="pageNum" value="${info.pageNum}"/>

                    <div class="input-group">
                        <input type="text" class="form-control" id="teacherName" name="teacherName" <c:if test="${sessionScope.teacher!=null}"> readonly="readonly" value="${sessionScope.teacher.teacherName}" </c:if>  <c:if test="${sessionScope.teacher==null}">  value="${cache.teacherName}"</c:if> placeholder="教师姓名">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" value="">
                                重新选
                            </button>
                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
                            </ul>
                        </div>
                        <!-- /btn-group -->
                    </div>
                    <input class="form-control" type="text" placeholder="教工号"  id="fkTeacherCode" name="fkTeacherCode"  <c:if test="${sessionScope.teacher!=null}"> value="${sessionScope.teacher.teacherCode}" </c:if>  <c:if test="${sessionScope.teacher==null}">value="${cache.fkTeacherCode}"</c:if>  readonly="readonly">
                    <input class="form-control " type="text" name="fileName" value="${cache.fileName}"
                           placeholder="文件名称">
                    <select class="form-control" name="fileType" id="fileType">
                        <option value="">全部</option>
                        <option value="学术论文">学术论文</option>
                        <option value="项目">科研项目</option>
                        <option value="著作">著作书籍</option>
                        <option value="专利">专利</option>
                        <option value="获奖">成果获奖</option>
                        <option value="成果转化">成果转化</option>
                        <option value="论证报告">论证报告</option>
                    </select>
                    <button class="btn bg-primary  glyphicon glyphicon-zoom-in " id="btnSearch" type="submit" value="">
                        搜索
                    </button>

                </div>


            </form>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-md-3 col-3 text-center">文件名称</th>
                    <th>作者</th>
                    <th>教工号</th>
                    <th class="col-md-3 col-3 text-center">主题</th>
                    <th>时间</th>
                    <th>类别</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${info.list}" var="f" varStatus="vs">
                    <tr>
                        <td class="col-md-3 col-3 text-left">${f.fileName}</td>
                        <td>${f.teacherName}</td>
                        <td>${f.fkTeacherCode}</td>
                        <td class="col-md-3 col-3 text-left">${f.projectName}</td>
                        <td><fmt:formatDate value="${f.fileDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${f.fileType}</td>
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
                            <li><a href="javascript:;" onclick="mysearch.judgePage(1)">
                                <div class="text-primary">首页</div>
                            </a></li>
                            <c:forEach items="${info.navigatepageNums}" var="pageNum">
                                <li class="${info.pageNum==pageNum?'active':''}"><a href="javascript:;"
                                                                                    onclick="mysearch.judgePage('${pageNum}')">${pageNum} </a>
                                </li>
                            </c:forEach>
                            <li><a href="javascript:;" onclick="mysearch.judgePage(${info.lastPage})">
                                <div class="text-primary">尾页</div>
                            </a></li>
                        </ul>
                    </nav>
                </c:if>
            </div>
        </div>
    </div>

</div>


<!--文档上传开始 -->

<div class="container-fluid">
    <div class="panel panel-primary  text-center ">

        <div class="panel-body">
            <ul id="upload" class="nav nav-tabs" role="tablist" >
                <li role="presentation" class="active"><a href="#home" id="homeTab" data-toggle="tab">学术论文类</a></li>
                <li role="presentation"><a href="#yemian" data-toggle="tab" id="project">科研项目类</a></li>
                <li role="presentation"><a href="#yemian"  data-toggle="tab" id="work">著作书籍</a></li>
                <li role="presentation"><a href="#yemian" data-toggle="tab" id="patents">专利类</a></li>
                <li role="presentation"><a href="#yemian" data-toggle="tab" id="prizes">成果获奖类</a></li>
                <li role="presentation"><a href="#yemian" data-toggle="tab" id="honour">成果转化类</a></li>
                <li role="presentation"><a href="#yemian" data-toggle="tab" id="report">论证报告</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="panel panel-primary  text-center ">
                        <div class="panel-heading"><h5 class="text">学术论文信息添加</h5></div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label">题目:</label>

                                    <div class="col-sm-3 ">
                                        <input type="text" id="magName" class="form-control" placeholder="请输入题目"/>
                                    </div>
                                    <label class="col-sm-1 control-label">成果类别:</label>

                                    <div class="col-sm-3 ">
                                        <select class="form-control" id="magLevel" placeholder="请输入成果类别">
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
                                    <label class="col-sm-1 control-label">作者排名:</label>

                                    <div class="col-sm-3 ">
                                        <input type="number" class="form-control" min="1" id="magTeacherOrder"
                                               placeholder="作者排名"/>
                                    </div>
                                    <label class="col-sm-1 control-label ">发表时间:</label>

                                    <div class="col-sm-3 ">
                                        <input type="text" class="form-control" id="magPubDate"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="发表时间"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label">本校排名:</label>

                                    <div class="col-sm-3 ">
                                        <input type="number" class="form-control" min="1" id="magSchoolOrder"
                                               placeholder="本校排名"/>
                                    </div>
                                    <label class="col-sm-1 control-label ">检索情况:</label>

                                    <div class="col-sm-3 ">
                                        <input type="text" class="form-control" id="magDeac"
                                               placeholder="论文检索情况"/>
                                    </div>
                                </div>

                                <div id="uploader" class="wu-example">
                                    <!--用来存放文件信息-->
                                    <div id="thelist" class="uploader-list"></div>

                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-offset-2" id="picker">
                                        选中文件
                                    </label>

                                    <div class="col-sm-2 ">
                                        <button id="ctlBtn" class="btn btn-primary" type="button">开始上传</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="panel-footer panel-success">
                            <button class="btn btn-success " type="button" id="uploadBtn">确定</button>
                            <button class="btn btn-success " type="reset">重置</button>
                        </div>
                    </div>


                </div>

                <div role="tabpanel" class="tab-pane embed-responsive embed-responsive-16by9" id="yemian">
                    <iframe class="embed-responsive-item"  src="" id="frame" name="frame"></iframe>
                </div>
            </div>
        </div>

    </div>
</div>


</body>

<%@include file="/WEB-INF/jsp/commonjs.jsp" %>
<%--本页面用到的js --%>
<script>
    common.init('${pageContext.request.contextPath}');
</script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap-suggest.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/search.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/webuploader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/upload.js"></script>

<script>
    //重新刷新
    function reflush() {
        $("#btnSearch").trigger("click");
    }
    $(function () {


        function getSelectTeacherCode() {
            var fkTeacherCode = $("#fkTeacherCode").val();
            if (fkTeacherCode == null || fkTeacherCode.length < 2) {
                Alert('请先选中教师编号！否则将不能上传文件');

                return null;
            }
            //教师登录了
            if(${sessionScope.teacher!=null} && fkTeacherCode!='${sessionScope.teacher.teacherCode}'){
                Alert('当前选中的教师编号与登录者不一致请重新选择');

                return null;
            }

                return fkTeacherCode;
        }


        //让下拉框选中
        $("#fileType").val('${cache.fileType}');

        function changeIFrameURL(url) {
            window.frames["frame"].location.href = url;
        }

        $("#project").click(function () {
            //跳转界面
            var code = getSelectTeacherCode();
            if (code != null) {
                var url = common.basePath+"/uploadpage/" + code + "/project";
                changeIFrameURL(url);
            }
        });
        //显示著作类
        $("#work").click(function(){
            var code = getSelectTeacherCode();
            if (code != null) {
                var url = common.basePath+"/uploadpage/" + code + "/work";
                changeIFrameURL(url);
            }
        });

        //patents 显示专利上传
        $("#patents").click(function(){
            var code = getSelectTeacherCode();
            if (code != null) {
                var url = common.basePath+"/uploadpage/" + code + "/patent";
                changeIFrameURL(url);
            }
        });

        //prizes
        $("#prizes").click(function(){
            var code = getSelectTeacherCode();
            if (code != null) {
                var url = common.basePath+"/uploadpage/" + code + "/prize";
                changeIFrameURL(url);
            }
        });
        //honour

        $("#honour").click(function(){
            var code = getSelectTeacherCode();
            if (code != null) {
                var url = common.basePath+"/uploadpage/" + code + "/honour";
                changeIFrameURL(url);
            }
        });

        $("#report").click(function(){
            var code = getSelectTeacherCode();
            if (code != null) {
                var url = common.basePath+"/uploadpage/" + code + "/report";
                changeIFrameURL(url);
            }
        });
        //保存操作
        $("#uploadBtn").click(function () {

            //判断有没有选中教师
            var fkTeacherCode = $("#fkTeacherCode").val();
            if (fkTeacherCode == null || fkTeacherCode.length < 5) {
                Alert('请先选中教师编号！否则将不能上传文件');
                return;
            }

            //判断文件是否上传成功

            if (filesupload == null || filesupload.length < 1) {
                Alert('请上传文件！');
                return;
            }

            var jsonText = JSON.stringify(filesupload);
            var magName = $("#magName").val();
            var magLevel = $("#magLevel").val();
            var magTeacherOrder = $("#magTeacherOrder").val();
            var magPubDate = $("#magPubDate").val();
            var magSchoolOrder = $("#magSchoolOrder").val();
            var magDeac = $("#magDeac").val();
            var data = {
                "files": jsonText,
                "magName": magName,
                "magLevel": magLevel,
                "magTeacherOrder": magTeacherOrder,
                "magPubDate": magPubDate,
                "fkTeacherCode": fkTeacherCode,
                "magSchoolOrder":magSchoolOrder,
                "magDeac":magDeac
            };

            $.post(common.basePath+"/magazine/insert", data, function (result) {
                //清空对象

                if (result) {
                    if (result.success) {
                        filesupload.length=0;
                        Alert({
                            msg: result.message,
                            onOk: function () {
                                reflush();
                            }
                        });
                    } else {
                        Alert(result.message);
                    }
                }
            });
        });
    });
</script>
</html>