var users={
    //跳转页面
    judgePage:function(pageNum){
        //设定当前页码
        $("#pageNum").val(pageNum);
        //出发搜索按钮的点击事件
        $("#btnSearch").trigger("click");
    },
    //用户相关的url
    URL:{
        queryById:function(id){
            return "/users/"+id+"/detail";
        },
        editURL:function(){
            return "/users/edit";
        },
        deleteURL:function(userid){
            return "/users/"+userid+"/delete";
        }

    },
    //查询单个用户信息
    query:function(userid){

        $.get(users.URL.queryById(userid),{},function(data){

            if(data&&data.success){
                // 弹出模态框并且赋值
                $("#userId").val(data.data['userId']);
                $("#userType").val(data.data['userType']);
                $("#username").val(data.data['username']);
                $("#password").val(data.data['password']);
                $("#realName").val(data.data['realName']);
                $("#userModel").modal({//显示弹出层
                    backdrop: 'static',//不可后退
                    keyboard: false//进制键盘事件
                }).show();
            }else{
                $("#success").show();
            }
        });
    },
    //编辑用户信息
    edit:function(){

        var userType =$("#userType").val();
        var userId= $("#userId").val();
        var username= $("#username").val();
        var password=$("#password").val();
        var realName=$("#realName").val();

        var user={
            "userId":userId,
            "userType":userType,
            "username":username,
            "password":password,
            "realName":realName
        };
        $.post(users.URL.editURL(),user,function(data){
            if(data&&data.success){
                // 编辑成功：隐藏显示框，刷新界面

                Alert({
                    msg: data.message,
                    onOk: function(){
                        window.location.reload();
                    }

                });



            }else{//显示错误信息
                Alert(data['message']);
            }
        });

    },
    //删除用户
    delete:function(userid){
        if(userid&&!isNaN(userid)){
            Confirm({
                msg: '你确定要删除该数据吗？',
                onOk: function(){
                    $.post(users.URL.deleteURL(userid),{},function(data){
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

/////////点击添加用户按钮出发事件/////////////

    $("#btnAdd").click(function(){
        //清空表单
        $('#form')[0].reset();
        $("#userId").val('');
        $("#userModel").modal({//显示弹出层
            backdrop: 'static',//不可后退
            keyboard: false//进制键盘事件
        }).show();
    });
/////////点击添加用户按钮出发事件/////////////


/////////点击关闭编辑框/////////////

    $("#closeBtn").click(function(){
        $("#userModel").modal('hide');
    });
/////////点击关闭编辑框/////////////

/////////点击确定按钮编辑框/////////////

    $("#editBtn").click(function(){

        users.edit();
    });

/////////点击确定按钮/////////////

});