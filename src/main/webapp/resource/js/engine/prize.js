var prize = {
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
            return common.basePath+"/prize/" + uuid + "/detail";
        },
        editURL: function () {
            return common.basePath+"/prize/update";
        },
        deleteURL: function (uuid) {
            return common.basePath+"/prize/" + uuid + "/delete";
        }

    },
    //
    query: function (uuid) {

        $.get(prize.URL.queryById(uuid), {}, function (data) {

            if (data && data.success) {
                // 弹出模态框并且赋值
                $("#priUuid").val(data.data['priUuid']);
                $("#priName").val(data.data['priName']);
                $("#priRank").val(data.data['priRank']);
                $("#priDate").val(data.data['priDate']);
                $("#priTeacherOrder").val(data.data['priTeacherOrder']);
                $("#priOrg").val(data.data['priOrg']);
                $("#priSchoolOrder").val(data.data['priSchoolOrder']);
                $("#fkTeacherCode").val(data.data['fkTeacherCode']);
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
        var priName = $("#priName").val();
        var priRank = $("#priRank").val();
        var priDate = $("#priDate").val();
        var priOrg = $("#priOrg").val();
        var priTeacherOrder = $("#priTeacherOrder").val();
        var priUuid = $("#priUuid").val();
        var fkTeacherCode = $("#fkTeacherCode").val();
        var priSchoolOrder = $("#priSchoolOrder").val();

        var data = {
            "files": jsonText,
            "priName": priName,
            "priRank": priRank,
            "priDate": priDate,
            "priOrg": priOrg,
            "priTeacherOrder": priTeacherOrder,
            "fkTeacherCode": fkTeacherCode,
            "priUuid":priUuid,
            "priSchoolOrder":priSchoolOrder
        };

        $.post(prize.URL.editURL(), data, function (result) {
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
                    $.post(prize.URL.deleteURL(uuid), {}, function (data) {
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

    $("#prizeUpdateBtn").click(function () {
        prize.edit();
    });

/////////点击确定按钮/////////////

});