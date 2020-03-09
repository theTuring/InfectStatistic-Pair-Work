var myChart = echarts.init(document.getElementById('chart'));
// 指定图表的配置项和数据
myChart.setOption({
    title: {
        text: '近七日收益'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['收益']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
        saveAsImage: {}
    }
    },
    xAxis: {
        type: 'category',
        splitLine:{show:false},//网格线是否显示
        boundaryGap: false,
        data: ["1","2","3","4","5"]
    },
    yAxis: {
        type: 'value',
        splitLine:{show:true},//网格线是否显示
    },
    series: [
        {
            name:'收益',
            type:'line',
            stack: '总量',
            data:["1","2","3","4","5"]
        }
    ]
});