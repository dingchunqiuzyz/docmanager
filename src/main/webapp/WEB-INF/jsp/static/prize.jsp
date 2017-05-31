<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/resource/css/webuploader.css">
<body>
<div class="container-fluid">
    <div class="panel panel-primary  text-center wd">
        <div class="panel-heading"><h4 class="text">成果获奖信息添加</h4></div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">奖项名称:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="priName" name="priName" class="form-control" placeholder="请输入获奖名称"/>
                    </div>
                    <label class="col-sm-2 control-label">奖项级别:</label>

                    <div class="col-sm-3 ">
                        <select class="form-control" id="priRank" placeholder="获奖类型">
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
                    <label class="col-sm-2 control-label">获奖时间:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="priDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="获奖时间"/>
                    </div>

                    <label class="col-sm-2 control-label">颁奖单位:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="priOrg" class="form-control" placeholder="颁奖单位"/>
                    </div>

                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">作者排名:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="priTeacherOrder" class="form-control" placeholder="作者排名"/>
                    </div>
                    <label class="col-sm-2 control-label">本校排名:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="priSchoolOrder" class="form-control" placeholder="本校排名"/>
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
<script>
    common.init('${pageContext.request.contextPath}');
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/webuploader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/upload.js"></script>
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
            var priName = $("#priName").val();
            var priRank = $("#priRank").val();
            var priDate = $("#priDate").val();
            var priSchoolOrder = $("#priSchoolOrder").val();
            var priTeacherOrder = $("#priTeacherOrder").val();
            var priOrg=$("#priOrg").val();

            var data = {
                "files": jsonText,
                "priName": priName,
                "priRank": priRank,
                "priDate": priDate,
                "priSchoolOrder": priSchoolOrder,
                "priTeacherOrder": priTeacherOrder,
                "fkTeacherCode": teacherCode,
                "priOrg":priOrg
            };

            $.post(common.basePath+"/prize/insert", data, function (result) {
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