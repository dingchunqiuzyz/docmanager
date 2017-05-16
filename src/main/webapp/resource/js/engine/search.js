var mysearch={
    //跳转页面
    teachers:null,
    //记录旧的值
    teacherOldVal :null,
    //初始化参数

    init:function(teacherCode){
      mysearch.teacherOldVal = teacherCode;
        mysearch.setSelection();
    },


    judgePage:function(pageNum){
        //设定当前页码
        //alert(pageNum);
        $("#pageNum").val(pageNum);
        //出发搜索按钮的点击事件
        $("#btnSearch").trigger("click");
    },
    URL:{
        queryTeacher:function(){
            return "/teachers/queryTeacher";
        }
    },

    queryTeacher:function(teacherName){

      if(teacherName!=null&&teacherName!=""){

          $.post(mysearch.URL.queryTeacher(),{"teacherName":teacherName},function(result){
              var selectNode=$("#fkTeacherCode");
              if(result&&result.success){
                  //查询成功
                  var data=eval('(' + result.data + ')');
                  mysearch.teachers=data;
                  //为option 添加子节点
                  //先删除所有子节点
                  selectNode.empty();
                  $.each(data,function(key,value){
                      selectNode.append("<option value="+key+">"+key+"</option>")
                  });
                  //显示教师信息
                  var code =selectNode.val();
                  $("#info").html(mysearch.teachers[code]);

              }else{
                  Alert('你输入的教工姓名不存在');
                  //清空数据
                  selectNode.empty();
                  selectNode.append("<option value=''>请输入名字</option>")
                  $("#info").html("");
              }
          });

      }
    },

    setSelection:function(){

        //如果名字不为空，再查一遍
        var teacherName = $("#teacherName").val();

        if(teacherName!=null&&""!=teacherName){
            mysearch.queryTeacher(teacherName);
        }
        //旧的值
        if(mysearch.teacherOldVal){
            if(mysearch.teachers!=null){
                $("#info").html(mysearch.teachers[mysearch.teacherOldVal]);
            }
            $("#fkTeacherCode").val(mysearch.teacherOldVal)
        }
    }

}






$(function(){
    //这里讲ajax 改为同步

    $.ajaxSetup({
        async : false
    });
    //名字改变进行搜索
    $('#teacherName').blur( function() {


        var teacherName = $("#teacherName").val();
        if(teacherName!=null&&""!=teacherName)
            mysearch.queryTeacher(teacherName);

    });
    //教工号改变就行联动
    $("#fkTeacherCode").change(function(){

        var code =$("#fkTeacherCode").val();
        if(mysearch.teachers!=null){
            $("#info").html(mysearch.teachers[code]);
        }
    });




});