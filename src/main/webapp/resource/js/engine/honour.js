var honour = {
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
            return common.basePath+"/honour/" + uuid + "/detail";
        },
        editURL: function () {
            return common.basePath+"/honour/update";
        },
        deleteURL: function (uuid) {
            return common.basePath+"/honour/" + uuid + "/delete";
        }

    },
    //
    query: function (uuid) {

        $.get(honour.URL.queryById(uuid), {}, function (data) {

            if (data && data.success) {
                // 弹出模态框并且赋值
                $("#hoUuid").val(data.data['hoUuid']);
                $("#hoName").val(data.data['hoName']);
                $("#hoRank").val(data.data['hoRank']);
                $("#hoStartDate").val(data.data['hoStartDate']);
                $("#hoEndDate").val(data.data['hoEndDate']);
                $("#hoTeacherOrder").val(data.data['hoTeacherOrder']);
                $("#hoOrg").val(data.data['hoOrg']);
                $("#hoMoney").val(data.data['hoMoney']);
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
        var hoUuid = $("#hoUuid").val();
        var fkTeacherCode = $("#fkTeacherCode").val();
        var hoName = $("#hoName").val();
        var hoRank = $("#hoRank").val();
        var hoStartDate = $("#hoStartDate").val();
        var hoEndDate = $("#hoEndDate").val();

        var hoOrg = $("#hoOrg").val();
        var hoMoney = $("#hoMoney").val();
        var hoTeacherOrder = $("#hoTeacherOrder").val();

        var data = {
            "files": jsonText,
            "hoName": hoName,
            "hoRank": hoRank,
            "hoStartDate": hoStartDate,
            "hoEndDate": hoEndDate,
            "hoMoney": hoMoney,
            "hoOrg": hoOrg,
            "hoTeacherOrder": hoTeacherOrder,
            "fkTeacherCode": fkTeacherCode,
            "hoUuid":hoUuid
        };

        $.post(honour.URL.editURL(), data, function (result) {
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
                    $.post(honour.URL.deleteURL(uuid), {}, function (data) {
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

    $("#honourUpdateBtn").click(function () {
        honour.edit();
    });

/////////点击确定按钮/////////////

});