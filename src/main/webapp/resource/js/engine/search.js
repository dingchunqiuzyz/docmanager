var mysearch = {
    //跳转页面
    teachers: null,
    //记录旧的值
    teacherOldVal: null,
    //初始化参数




    judgePage: function (pageNum) {
        //设定当前页码
        //alert(pageNum);
        $("#pageNum").val(pageNum);
        //出发搜索按钮的点击事件
        $("#btnSearch").trigger("click");
    },
    URL: {
        queryTeacher: function () {
            return "/teachers/queryTeacher";
        }
    },





}


$(function () {
    //这里讲ajax 改为同步

    // $.ajaxSetup({
    //     async : false
    // });
    // //名字改变进行搜索
    // $('#teacherName').blur( function() {
    //
    //
    //     var teacherName = $("#teacherName").val();
    //     if(teacherName!=null&&""!=teacherName)
    //         mysearch.queryTeacher(teacherName);
    //
    // });
    // //教工号改变就行联动
    // $("#fkTeacherCode").change(function(){
    //
    //     var code =$("#fkTeacherCode").val();
    //     if(mysearch.teachers!=null){
    //         $("#info").html(mysearch.teachers[code]);
    //     }
    // });



});


(function() {

    //搜索提示
    $("#teacherName").bsSuggest({
        autoDropup: true,       //自动判断菜单向上展开
        clearable: false,
        allowNoKeyword: false,
        getDataMethod: "url",
        delayUntilKeyup: true,
        url: "/teachers/queryTeacher?d=" + new Date().getTime(),
        idField: "teacherCode",
        effectiveFields: ["college", "teacherName", "teacherCode"],
        effectiveFieldsAlias: {teacherName: "姓名", college: "学院", teacherCode: "教工号"}, //有效字段别名
        showBtn: true,
        delay: 300,
        keyField: "teacherName",
        fnAdjustAjaxParam: function (keyword, opts) {
//调整 ajax 请求参数方法，用于更多的请求配置需求。如对请求关键字作进一步处理、修改超时时间等
            console.log('ajax 请求参数调整：', keyword, opts);
            return {
                type: 'POST',
                timeout: 10000,
                data: {
                    teacherName:  keyword
                }
            };
        }
    }).on('onDataRequestSuccess', function (e, result) {
        console.log('onDataRequestSuccess: ', result);
    }).on('onSetSelectValue', function (e, keyword, data) {
        console.log('onSetSelectValue: ', keyword, data);
        //设置教工号
        $("#fkTeacherCode").val(data.teacherCode);
    }).on('onUnsetSelectValue', function () {
        console.log('onUnsetSelectValue');
    });


    $("#teacherName").bind('input propertychange',function(){

        $("#fkTeacherCode").val('');
    });

}());