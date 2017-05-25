var college = {

    //用户相关的url
    URL: {

        editURL: function () {
            return "/college/edit";
        },
        deleteURL: function (collegeId) {
            return "/college/" + collegeId + "/delete";
        }

    },
    //
    //编辑
    edit: function () {

        var collegeName = $("#collegeName").val();

        var data = {
            "collegeName": collegeName
        };

        $.post(college.URL.editURL(), data, function (result) {
            //清空对象
            if (result) {
                if(result.success){
                    $("#collegeModal").modal('hide');
                    Alert({
                        msg: result.message,
                        onOk:function(){
                            window.location.reload();
                        }
                    });
                }else{
                    Alert({
                        msg: result.message
                    });
                }


            }
        });
    },
    //删除用户
    delete: function (collegeId) {
        if (collegeId) {
            Confirm({
                msg: '您确定要删除该记录吗？该操作不可撤回,请慎重操作',
                onOk: function () {
                    $.post(college.URL.deleteURL(collegeId), {}, function (data) {
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
    $("#collegeUpdateBtn").click(function () {
        college.edit();
    });

    $("#collegeAddBtn").click(function(){
        $('#form')[0].reset();
        $("#collegeModal").modal({//显示弹出层
            backdrop: 'static',//不可后退
            keyboard: false//进制键盘事件
        }).show();
    });
/////////点击确定按钮/////////////

});