var magazine={
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
            return common.basePath+"/magazine/"+uuid+"/detail";
        },
        editURL:function(){
            return common.basePath+"/magazine/update";
        },
        deleteURL:function(uuid){
            return common.basePath+"/magazine/"+uuid+"/delete";
        }

    },
    //
    query:function(uuid){

        $.get(magazine.URL.queryById(uuid),{},function(data){

            if(data&&data.success){
                // 弹出模态框并且赋值
                $("#magName").val(data.data['magName']);
                $("#magUuid").val(data.data['magUuid']);
                $("#magLevel").val(data.data['magLevel']);
                $("#fkTeacherCode").val(data.data['fkTeacherCode']);
                $("#magTeacherOrder").val(data.data['magTeacherOrder']);
                $("#magPubDate").val(data.data['magPubDate']);

                $("#magSchoolOrder").val(data.data['magSchoolOrder']);
                $("#magDeac").val(data.data['magDeac']);

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
        var magName=$("#magName").val();
        var magUuid= $("#magUuid").val();
        var magLevel=$("#magLevel").val();
        var magTeacherOrder=$("#magTeacherOrder").val();
        var fkTeacherCode=$("#fkTeacherCode").val();
        var magPubDate=$("#magPubDate").val();

        var magSchoolOrder=$("#magSchoolOrder").val();
        var magDeac=$("#magDeac").val();

        var jsonText = null;
        if(filesupload.length>0)
         jsonText = JSON.stringify(filesupload);

        var data = {
            "magUuid":magUuid,
            "files": jsonText,
            "magName": magName,
            "magLevel": magLevel,
            "magTeacherOrder": magTeacherOrder,
            "magPubDate": magPubDate,
            "fkTeacherCode": fkTeacherCode,
            "magSchoolOrder":magSchoolOrder,
            "magDeac":magDeac
        };

        $.post(magazine.URL.editURL(), data, function (result) {
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
                    $.post(magazine.URL.deleteURL(uuid),{},function(data){
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

    $("#updateMagazineBtn").click(function(){
        magazine.edit();
    });

/////////点击确定按钮/////////////

});