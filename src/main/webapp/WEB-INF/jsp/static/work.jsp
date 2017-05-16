<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp" %>
<link rel="stylesheet" type="text/css"
      href="/resource/css/webuploader.css">
<body>
<div class="container-fluid">
    <div class="panel panel-primary  text-center ">
        <div class="panel-heading"><h4 class="text">著作/书籍信息添加</h4></div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">著作名称:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="workName"  class="form-control" placeholder="请输入著作名"/>
                    </div>
                    <label class="col-sm-2 control-label">出版社:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="workPublish"  class="form-control" placeholder="请输入出版社"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">ISBN编号:</label>

                    <div class="col-sm-3 ">
                        <input type="text" id="workIsbn"  class="form-control" placeholder="请输入ISBN编号"/>
                    </div>
                    <label class="col-sm-2 control-label">出版时间:</label>

                    <div class="col-sm-3 ">
                        <input type="text" class="form-control" id="workDate"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="出版时间"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">作者排名:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="workTeacherOrder" class="form-control" placeholder="作者排名"/>
                    </div>
                    <label class="col-sm-2 control-label">字数（万字）:</label>

                    <div class="col-sm-3 ">
                        <input type="number" id="workCharNumber" class="form-control" placeholder="字数（万字）"/>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-sm-2 control-label">类型:</label>

                    <div class="col-sm-3 ">
                        <select class="form-control" id="workType" placeholder="类型">
                            <option value="学术专著">学术专著</option>
                            <option value="译著">译著</option>
                            <option value="学术书籍">学术书籍</option>
                            <option value="科普读物论文集">科普读物论文集</option>
                            <option value="论文集">论文集</option>
                        </select>
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
            var workName = $("#workName").val();
            var workPublish = $("#workPublish").val();
            var workIsbn = $("#workIsbn").val();
            var workDate = $("#workDate").val();
            var workTeacherOrder = $("#workTeacherOrder").val();
            var workCharNumber = $("#workCharNumber").val();
            var workType = $("#workType").val();


            var data = {
                "files": jsonText,
                "workName": workName,
                "workPublish": workPublish,
                "workIsbn": workIsbn,
                "workDate": workDate,
                "workTeacherOrder": workTeacherOrder,
                "fkTeacherCode": teacherCode,

                "workCharNumber": workCharNumber,
                "workType": workType

            };

            $.post("/work/insert", data, function (result) {
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