function setChart(){
   
    // 指定图表的配置项和数据
    option = ({
        title: {
            text: '近七日收益'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['legend']
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
        backgroundColor: 'white',
        xAxis: {
            type: 'category',
            axisTick:{
                show:false,
            },
            boundaryGap: false,
            axisTick:{
                show:false,
            },
            axisLabel:{
                color:'black'
            },
            axisLine:{
                lineStyle:{
                    color:'rgba(12,102,173,.5)',
                    width:2,
                }
            },
        },
        yAxis: {
            type: 'value',
            axisTick:{
                show:false,//不显示刻度线
            },
            axisLabel:{
                color:'black'  //y轴上的字体颜色
            },
            axisLine:{
                lineStyle:{
                    width:2,
                    color:'rgba(12,102,173,.5)',//y轴的轴线的宽度和颜色
                }
            },
            splitLine: {
                show: false       
            }
        },
        series: [
            {
                type:'line',
                symbol: 'none',
                smooth:true,
                itemStyle: {
                    normal: {
                        color: 'red',
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'red'
                        }, {
                            offset: 1,
                            color: 'rgba(12,102,173,.5)'
                        }])
                    }
                },
            }
        ]
    });

    option.xAxis.data = ['01','02','03','04','05','06','07','08','09','10','11','12 (月)'];
    option.series[0].data = [21,25,27,12,22,21,25,27,12,22,42,32];

    var myChart = echarts.init(document.getElementById('chart'));
    myChart.setOption(option);

   

}