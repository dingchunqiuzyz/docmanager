<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="/resource/css/webuploader.css">
<body>
<div class="container-fluid">
    <div class="panel panel-primary  text-center wd">
        <div class="panel-heading"><h4 class="text">科研项目信息添加</h4></div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">项目名称:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="proName" name="proName" class="form-control" placeholder="请输入项目名"/>
                    </div>
                    <label class="col-sm-2 control-label">项目类型:</label>

                    <div class="col-sm-3 ">
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

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="proSource"
                                placeholder="项目来源"/>
                    </div>

                    <label class="col-sm-2 control-label">项目经费(万元):</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="proFunds"
                               placeholder="项目经费(万元)"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">起始时间:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="proStartDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="发表时间"/>
                    </div>

                    <label class="col-sm-2 control-label">结束时间:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="proEndDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="发表时间"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">作者排名:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="proTeacherOrder" class="form-control" placeholder="作者排名"/>
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
            var proName = $("#proName").val();
            var proLevel = $("#proLevel").val();
            var proStartDate = $("#proStartDate").val();
            var proEndDate = $("#proEndDate").val();
            var proTeacherOrder = $("#proTeacherOrder").val();

            var proSource = $("#proSource").val();
            var proFunds = $("#proFunds").val();

            var data = {
                "files": jsonText,
                "proName": proName,
                "proLevel": proLevel,
                "proStartDate": proStartDate,
                "proEndDate": proEndDate,
                "proTeacherOrder": proTeacherOrder,
                "fkTeacherCode": teacherCode,
                "proFunds":proFunds,
                "proSource":proSource
            };

            $.post("/project/insert", data, function (result) {
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