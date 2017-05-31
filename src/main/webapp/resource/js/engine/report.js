var report = {
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
            return common.basePath+"/report/" + uuid + "/detail";
        },
        editURL: function () {
            return common.basePath+"/report/update";
        },
        deleteURL: function (uuid) {
            return common.basePath+"/report/" + uuid + "/delete";
        }

    },
    //
    query: function (uuid) {

        $.get(report.URL.queryById(uuid), {}, function (data) {

            if (data && data.success) {
                // 弹出模态框并且赋值
                $("#repUuid").val(data.data['repUuid']);
                $("#repName").val(data.data['repName']);
                $("#repRank").val(data.data['repRank']);
                $("#repDate").val(data.data['repDate']);
                $("#repTeacherOrder").val(data.data['repTeacherOrder']);
                $("#repOrg").val(data.data['repOrg']);
                $("#fkTeacherCode").val(data.data['fkTeacherCode']);

                $("#modal").modal({//显示弹出层
                    backdrop: 'static',//不可后退
                    keyboard: false//进制键盘事件
                }).show();
            } else {
                Alert('查询信息失败！');
            }
        });
    },
    //编辑
    edit: function () {
        var jsonText = null;
        if (filesupload.length > 0)
            jsonText = JSON.stringify(filesupload);


        var repUuid = $("#repUuid").val();
        var fkTeacherCode = $("#fkTeacherCode").val();
        var repName = $("#repName").val();
        var repRank = $("#repRank").val();
        var repDate = $("#repDate").val();
        var repTeacherOrder = $("#repTeacherOrder").val();

        var repOrg = $("#repOrg").val();

        var data = {
            "files": jsonText,
            "repName": repName,
            "repRank": repRank,
            "repDate": repDate,
            "repTeacherOrder": repTeacherOrder,
            "repOrg": repOrg,
            "fkTeacherCode": fkTeacherCode,
            "repUuid":repUuid
        };

        $.post(report.URL.editURL(), data, function (result) {
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
                    $.post(report.URL.deleteURL(uuid), {}, function (data) {
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

    $("#reportUpdateBtn").click(function () {
        report.edit();
    });

/////////点击确定按钮/////////////

});