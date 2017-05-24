<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<link id="bscss" href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
    <h3>测试(首次从 URL 获取数据，显示 header，不显示按钮，忽略大小写，显示清除按钮)</h3>
    <div class="row">
        <div class="col-lg-6">
            <div class="input-group">
                <input type="text" class="form-control" id="testNoBtn3">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" value="惦记我">
                        惦记我
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                    </ul>
                </div>
                <!-- /btn-group -->
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-6">
        <div class="input-group">
            <input type="text" class="form-control" id="taobao5">
            <div class="input-group-btn">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu dropdown-menu-right" role="menu">
                </ul>
            </div>
            <!-- /btn-group -->
        </div>
    </div>
</div>
<script src="//cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/tether/1.2.0/js/tether.min.js"></script>
<script id="bsjs" src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/bootstrap-suggest.min.js"></script>
<script>
    function initTest() {

    }
    //initTest();
</script>

<script>
    (function() {


        /**
         * 淘宝搜索 API 测试
         */
        $("#taobao").bsSuggest({
            indexId: 2,             //data.value 的第几个数据，作为input输入框的内容
            indexKey: 1,            //data.value 的第几个数据，作为input输入框的内容
            allowNoKeyword: false,  //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
            multiWord: true,        //以分隔符号分割的多关键字支持
            separator: ",",         //多关键字支持时的分隔符，默认为空格
            getDataMethod: "url",   //获取数据的方式，总是从 URL 获取
            showHeader: true,       //显示多个字段的表头
            autoDropup: true,       //自动判断菜单向上展开
            effectiveFieldsAlias:{Id: "序号", Keyword: "关键字"},
            url: 'http://suggest.taobao.com/sug?code=utf-8&extras=1&q=', /*优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数*/
            jsonp: 'callback',               //如果从 url 获取数据，并且需要跨域，则该参数必须设置
            // url 获取数据时，对数据的处理，作为 fnGetData 的回调函数
            fnProcessData: function(json){
                var index, len, data = {value: []};

                if(! json || ! json.result || ! json.result.length) {
                    return false;
                }

                len = json.result.length;

                for (index = 0; index < len; index++) {
                    data.value.push({
                        "Id": (index + 1),
                        "Keyword": json.result[index][0],
                        "Count": json.result[index][1]
                    });
                }
                console.log('淘宝搜索 API: ', data);
                return data;
            }
        }).on('onDataRequestSuccess', function (e, result) {
            console.log('onDataRequestSuccess: ', result);
        }).on('onSetSelectValue', function (e, keyword, data) {
            console.log('onSetSelectValue: ', keyword, data);
        }).on('onUnsetSelectValue', function () {
            console.log("onUnsetSelectValue");
        });



        $("#taobao5").bsSuggest({
            autoDropup: true,       //自动判断菜单向上展开
            clearable: true,
            allowNoKeyword: false,
            getDataMethod: "url",
            delayUntilKeyup: true,
            url: "/teachers/queryTeacher?teacherName=&d="+new Date().getTime(),
            idField: "teacherCode",
            effectiveFields: ["college", "teacherName","teacherCode"],
            effectiveFieldsAlias:{teacherName: "姓名",college:"学院",teacherCode:"教工号"}, //有效字段别名
            showBtn: true,
            keyField: "teacherName",
            fnAdjustAjaxParam: function (keyword, opts) {
//调整 ajax 请求参数方法，用于更多的请求配置需求。如对请求关键字作进一步处理、修改超时时间等
                console.log('ajax 请求参数调整：', keyword, opts);
                return {
                    type: 'POST',
                    timeout: 10000,
                    data: {
                        t: (new Date()).getTime(),
                        //wd: $('#customKeyword').val() + keyword
                    }
                };
            }
        }).on('onDataRequestSuccess', function (e, result) {
            console.log('onDataRequestSuccess: ', result);
        }).on('onSetSelectValue', function (e, keyword, data) {
            console.log('onSetSelectValue: ', keyword, data);
        }).on('onUnsetSelectValue', function () {
            console.log('onUnsetSelectValue');
        });

    }());

</script>
</html>