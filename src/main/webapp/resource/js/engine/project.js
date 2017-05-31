var project = {
    //跳转页面
    judgePage: function (pageNum) {
        //设定当前页码
        $("#pageNum").val(pageNum);
        //出发搜索按钮的点击事件
        $("#btnSearch").trigger("click");
    },
    //用户相关的url
    URL: {
        queryById: function (uuid) {
            return common.basePath+"/project/" + uuid + "/detail";
        },
        editURL: function () {
            return common.basePath+"/project/update";
        },
        deleteURL: function (uuid) {
            return common.basePath+"/project/" + uuid + "/delete";
        }

    },
    //
    query: function (uuid) {

        $.get(project.URL.queryById(uuid), {}, function (data) {

            if (data && data.success) {
                // 弹出模态框并且赋值
                $("#proUuid").val(data.data['proUuid']);
                $("#fkTeacherCode").val(data.data['fkTeacherCode']);
                $("#proName").val(data.data['proName']);
                $("#proLevel").val(data.data['proLevel']);
                $("#proStartDate").val(data.data['proStartDate']);
                $("#proEndDate").val(data.data['proEndDate']);
                $("#proTeacherOrder").val(data.data['proTeacherOrder']);

                $("#proSource").val(data.data['proSource']);
                $("#proFunds").val(data.data['proFunds']);

                $("#modal").modal({//显示弹出层
                    backdrop: 'static',//不可后退
                    keyboard: false//进制键盘事件
                }).show();
            } else {
                Alert('查询杂志信息失败！');
            }
        });
    },
    //编辑
    edit: function () {
        var jsonText = null;
        if (filesupload.length > 0)
            jsonText = JSON.stringify(filesupload);
        var proUuid = $("#proUuid").val();
        var fkTeacherCode = $("#fkTeacherCode").val();
        var proName = $("#proName").val();
        var proLevel = $("#proLevel").val();
        var proStartDate = $("#proStartDate").val();
        var proEndDate = $("#proEndDate").val();
        var proTeacherOrder = $("#proTeacherOrder").val();

        var proSource=$("#proSource").val();
        var proFunds=$("#proFunds").val();

        var data = {
            "files": jsonText,
            "proName": proName,
            "proLevel": proLevel,
            "proStartDate": proStartDate,
            "proEndDate": proEndDate,
            "proTeacherOrder": proTeacherOrder,
            "fkTeacherCode": fkTeacherCode,
            "proUuid": proUuid,
            "proSource":proSource,
            "proFunds":proFunds
        };

        $.post(project.URL.editURL(), data, function (result) {
            //清空对象
            if (result) {
                if (result.success) {
                    filesupload.length = 0;
                    Alert({
                        msg: result.message,
                        onOk: function () {
                            window.location.reload();
                        }
                    });
                } else {
                    Alert(result.message);
                }
            }
        });

    },
    //删除用户
    delete: function (uuid) {
        if (uuid) {
            Confirm({
                msg: '您确定要删除该文档吗？该操作不可撤回,请慎重操作',
                onOk: function () {
                    $.post(project.URL.deleteURL(uuid), {}, function (data) {
                        if (data) {
                            window.location.reload();
                        }
                    });
                },
                onCancel: function () {
                }

            });
        }
    }


}


$(function () {


/////////点击确定按钮编辑框/////////////

    $("#projectUpdateBtn").click(function () {
        project.edit();
    });

/////////点击确定按钮/////////////

});