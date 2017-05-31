<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/resource/css/webuploader.css">
<body>
<div class="container-fluid">
    <div class="panel panel-primary  text-center wd">
        <div class="panel-heading"><h4 class="text">论证报告信息添加</h4></div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">名称:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="repName" name="repName" class="form-control" placeholder="名称"/>
                    </div>
                    <label class="col-sm-2 control-label">成果类别:</label>

                    <div class="col-sm-3 ">
                        <select class="form-control" id="repRank" placeholder="成果类别">
                            <option value="国家部委专业论证报告、调研报告、咨询报告">国家部委征求的专业论证报告、调研报告、咨询报告</option>
                            <option value="省委、省政府专业论证报告、调研报告、咨询报告">省委、省政府征求的专业论证报告、调研报告、咨询报告</option>
                            <option value="市委、市政府专业论证报告、调研报告、咨询报告">市委、市政府征求的专业论证报告、调研报告、咨询报告</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">采用单位:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="repOrg" class="form-control" placeholder="采用单位"/>
                    </div>
                    <label class="col-sm-2 control-label">作者排名:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="repTeacherOrder" class="form-control" placeholder="作者排名"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">采用时间:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="repDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="采用时间"/>
                    </div>


                </div>



                <div id="uploader" class="wu-example">
                    <!--用来存放文件信息-->
                    <div id="thelist" class="uploader-list"></div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 " id="picker">
                        选中文件
                    </label>

                    <div class="col-sm-2 col-sm-offset-2">
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
            var repName = $("#repName").val();
            var repRank = $("#repRank").val();
            var repOrg = $("#repOrg").val();
            var repTeacherOrder = $("#repTeacherOrder").val();
            var repDate = $("#repDate").val();



            var data = {
                "files": jsonText,
                "repName": repName,
                "repRank": repRank,
                "repOrg": repOrg,
                "repTeacherOrder": repTeacherOrder,
                "repDate": repDate,
                "fkTeacherCode": teacherCode
            };

            $.post( common.basePath+"/report/insert", data, function (result) {
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