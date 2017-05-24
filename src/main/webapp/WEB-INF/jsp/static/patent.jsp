<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="/resource/css/webuploader.css">
<body>
<div class="container-fluid">
    <div class="panel panel-primary  text-center wd">
        <div class="panel-heading"><h4 class="text">专利信息添加</h4></div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">专利名称:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="patName" name="patName" class="form-control" placeholder="请输入专利名"/>
                    </div>
                    <label class="col-sm-2 control-label">专利类型:</label>

                    <div class="col-sm-3 ">
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
                    <label class="col-sm-2 control-label">授权日期:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="patDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="申请通过时间"/>
                    </div>
                    <label class="col-sm-2 control-label">专利代码:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="patCode" class="form-control" placeholder="专利代码"/>
                    </div>

                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">作者排名:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="patTeacherOrder" class="form-control" placeholder="作者排名"/>
                    </div>
                    <label class="col-sm-2 control-label">专利权人:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="patTeacherName" class="form-control" placeholder="专利权人"/>
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
</body>
<%@include file="/WEB-INF/jsp/commonjs.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/webuploader.js"></script>
<script type="text/javascript" src="/resource/js/engine/upload.js"></script>
<script>
    $(function () {

        //上传界面
        $("#uploadBtn").click(function () {
            var teacherCode = '${teacherCode}';
            if (teacherCode == null || teacherCode == "") {
                Alert('教师编号信息丢失,请选中教师编号后,重新点击本选项卡！');
                return;
            }
            if (filesupload == null || filesupload.length < 1) {
                Alert('请上传文件！');
                return;
            }

            var jsonText = JSON.stringify(filesupload);
            var patName = $("#patName").val();
            var patType = $("#patType").val();
            var patDate = $("#patDate").val();
            var patCode = $("#patCode").val();
            var patTeacherName = $("#patTeacherName").val();
            var patTeacherOrder = $("#patTeacherOrder").val();

            var data = {
                "files": jsonText,
                "patName": patName,
                "patType": patType,
                "patDate": patDate,
                "patCode": patCode,
                "patTeacherOrder": patTeacherOrder,
                "fkTeacherCode": teacherCode,
                "patTeacherName":patTeacherName
            };

            $.post("/patent/insert", data, function (result) {
                //清空对象
                if (result) {
                    if (result.success) {
                        filesupload.length = 0;
                        Alert({
                            msg: result.message,
                            onOk: function () {
                                //reflush();
                                //父类刷新
                                window.parent.reflush();
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