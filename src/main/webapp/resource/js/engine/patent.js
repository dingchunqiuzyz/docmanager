var patent={
    //跳转页面
    judgePage:function(pageNum){
        //设定当前页码
        $("#pageNum").val(pageNum);
        //出发搜索按钮的点击事件
        $("#btnSearch").trigger("click");
    },
    //用户相关的url
    URL:{
        queryById:function(uuid){
            return "/patent/"+uuid+"/detail";
        },
        editURL:function(){
            return "/patent/update";
        },
        deleteURL:function(uuid){
            return "/patent/"+uuid+"/delete";
        }

    },
    //
    query:function(uuid){

        $.get(patent.URL.queryById(uuid),{},function(data){

            if(data&&data.success){
                // 弹出模态框并且赋值
                $("#patUuid").val(data.data['patUuid']);
                $("#patName").val(data.data['patName']);
                $("#patType").val(data.data['patType']);
                $("#patCode").val(data.data['patCode']);
                $("#patDate").val(data.data['patDate']);
                $("#patTeacherOrder").val(data.data['patTeacherOrder']);
                $("#fkTeacherCode").val(data.data['fkTeacherCode']);
                $("#patTeacherName").val(data.data['patTeacherName']);

                $("#modal").modal({//显示弹出层
                    backdrop: 'static',//不可后退
                    keyboard: false//进制键盘事件
                }).show();
            }else{
                Alert('查询杂志信息失败！');
            }
        });
    },
    //编辑
    edit:function(){
        var patName = $("#patName").val();
        var patType = $("#patType").val();
        var patDate = $("#patDate").val();
        var patCode = $("#patCode").val();
        var patTeacherOrder = $("#patTeacherOrder").val();
        var patUuid=$("#patUuid").val();
        var fkTeacherCode=$("#fkTeacherCode").val();

        var patTeacherName=$("#patTeacherName").val();

        var jsonText = null;
        if(filesupload.length>0)
         jsonText = JSON.stringify(filesupload);
        var data = {
            "files": jsonText,
            "patName": patType,
            "patType": patType,
            "patDate": patDate,
            "patCode": patCode,
            "patTeacherOrder": patTeacherOrder,
            "patUuid":patUuid,
            "fkTeacherCode": fkTeacherCode,
            "patTeacherName":patTeacherName
        };
        $.post(patent.URL.editURL(), data, function (result) {
            //清空对象
            if (result) {
                if (result.success) {
                    filesupload.length=0;
                    $("#modal").modal('hide');
                    Alert({
                        msg: result.message,
                        onOk: function () {
                            //reflush();
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
    delete:function(uuid){
        if(patent){
            Confirm({
                msg: '您确定要删除该文档吗？该操作不可撤回,请慎重操作',
                onOk: function(){
                    $.post(patent.URL.deleteURL(uuid),{},function(data){
                        if(data){
                                window.location.reload();
                        }
                    });
                },
                onCancel: function(){
                }

            });
        }
    }



}






$(function(){


/////////点击确定按钮编辑框/////////////

    $("#patentUpdateBtn").click(function(){
        patent.edit();
    });

/////////点击确定按钮/////////////

});