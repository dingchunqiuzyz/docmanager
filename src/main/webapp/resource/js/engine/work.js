var work={
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
            return common.basePath+"/work/"+uuid+"/detail";
        },
        editURL:function(){
            return common.basePath+"/work/update";
        },
        deleteURL:function(uuid){
            return common.basePath+"/work/"+uuid+"/delete";
        }

    },
    //
    query:function(uuid){

        $.get(work.URL.queryById(uuid),{},function(data){

            if(data&&data.success){
                // 弹出模态框并且赋值
                $("#workUuid").val(data.data['workUuid']);
                $("#workName").val(data.data['workName']);
                $("#workPublish").val(data.data['workPublish']);
                $("#fkTeacherCode").val(data.data['fkTeacherCode']);
                $("#workIsbn").val(data.data['workIsbn']);
                $("#workDate").val(data.data['workDate']);
                $("#workTeacherOrder").val(data.data['workTeacherOrder']);

                $("#workCharNumber").val(data.data['workCharNumber']);
                $("#workType").val(data.data['workType']);

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
        var workName = $("#workName").val();
        var workPublish = $("#workPublish").val();
        var workIsbn = $("#workIsbn").val();
        var workDate = $("#workDate").val();
        var workTeacherOrder = $("#workTeacherOrder").val();

        var workUuid = $("#workUuid").val();
        var fkTeacherCode = $("#fkTeacherCode").val();

        var workCharNumber=$("#workCharNumber").val();
        var workType=$("#workType").val();

        var jsonText = null;
        if(filesupload.length>0)
         jsonText = JSON.stringify(filesupload);
        var data = {
            "files": jsonText,
            "workName": workName,
            "workPublish": workPublish,
            "workIsbn": workIsbn,
            "workDate": workDate,
            "workTeacherOrder": workTeacherOrder,
            "workUuid":workUuid,
            "fkTeacherCode": fkTeacherCode,
            "workCharNumber":workCharNumber,
            "workType":workType
        };
        $.post(work.URL.editURL(), data, function (result) {
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
        if(uuid){
            Confirm({
                msg: '您确定要删除该文档吗？该操作不可撤回,请慎重操作',
                onOk: function(){
                    $.post(work.URL.deleteURL(uuid),{},function(data){
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

    $("#workUpdateBtn").click(function(){
        work.edit();
    });

/////////点击确定按钮/////////////

});