


// 指定图表的配置项和数据
var barOption = {
    color: ['#3398DB'],
    title: {
        text: 'ECharts 入门示例'
    },
    tooltip: {},
    legend: {
        data:['文件个数'],
        orient: 'vertical',
        left: 'left',
    },
    xAxis: {
        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
    },
    yAxis: {},
    series: [{
        name: '文件个数',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
    }]
};

var pieOption = {
    title : {
        text: '某站点用户访问来源',
        subtext: '纯属虚构',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。


$(function(){

    var bar = echarts.init(document.getElementById('bar'));
    var pie = echarts.init(document.getElementById('pie'));

    function showBar(data) {
        barOption.title=data.title;

        var nameArray = new Array();

        var valueArray =new Array();

        var barDats=data.datas;

        for(var i in barDats) {
            nameArray.push(barDats[i].name);
            valueArray.push(barDats[i].value);
        }

        barOption.xAxis.data=nameArray;

        barOption.series[0].data=valueArray;

        bar.setOption(barOption);
    }
    function showPie(data) {
        pieOption.title = data.title;
        var nameArray = new Array();

        var pieDats=data.datas;

        for(var i in pieDats) {
            nameArray.push(pieDats[i].name);
        }
        pieOption.legend.data=nameArray;

        pieOption.series[0].data=pieDats;

        pie.setOption(pieOption);
    }
    $.get("/search/count",function (data) {
        if(data&&data.success){//访问数据成功

            var barData = data.data.bar;
            var pieData =data.data.pie;
            showBar(barData);
            showPie(pieData);
        }


    });

});