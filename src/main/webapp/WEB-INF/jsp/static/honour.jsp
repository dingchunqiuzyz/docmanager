<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="/resource/css/webuploader.css">
<body>
<div class="container-fluid">
    <div class="panel panel-primary  text-center wd">
        <div class="panel-heading"><h4 class="text">成果转化信息添加</h4></div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">名称:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="hoName" name="hoName" class="form-control" placeholder="名称"/>
                    </div>
                    <label class="col-sm-2 control-label">级别:</label>

                    <div class="col-sm-3 ">
                        <select class="form-control" id="hoRank" placeholder="项目类型">
                            <option value="科技成果转让">科技成果转让</option>
                            <option value="科技成果推广使用">科技成果推广使用</option>
                            <option value="技术开发、技术推广">技术开发、技术推广</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">起始时间:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="hoStartDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="起始时间"/>
                    </div>
                    <label class="col-sm-2 control-label">结束时间:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="hoEndDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="结束时间"/>
                    </div>

                </div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">项目来源:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="hoOrg" class="form-control" placeholder="项目来源"/>
                    </div>
                    <label class="col-sm-2 control-label">作者排名:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="hoTeacherOrder" class="form-control" placeholder="作者排名"/>
                    </div>
                </div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">学校获得转化金额:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="hoMoney" class="form-control" placeholder="学校获得转化金额"/>
                    </div>

                </div>

                <div id="uploader" class="wu-example">
                    <!--用来存放文件信息-->
                    <div id="thelist" class="uploader-list"></div>
                </div>
                <div class="form-group ">
                    <label class="col-sm-2 col-sm-offset-2" id="picker">
                        选中文件
                    </label>

                    <div class="col-sm-2 ">
                        <button id="ctlBtn" class="btn btn-primary col-sm-offset-1" type="button">开始上传</button>
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
            var hoName = $("#hoName").val();
            var hoRank = $("#hoRank").val();
            var hoStartDate = $("#hoStartDate").val();
            var hoEndDate = $("#hoEndDate").val();
            var hoOrg = $("#hoOrg").val();
            var hoTeacherOrder = $("#hoTeacherOrder").val();
            var hoMoney = $("#hoMoney").val();


            var data = {
                "files": jsonText,
                "hoName": hoName,
                "hoRank": hoRank,
                "hoStartDate": hoStartDate,
                "hoEndDate": hoEndDate,
                "hoOrg": hoOrg,
                "hoTeacherOrder": hoTeacherOrder,
                "fkTeacherCode": teacherCode,
                "hoMoney": hoMoney
            };

            $.post("/honour/insert", data, function (result) {
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