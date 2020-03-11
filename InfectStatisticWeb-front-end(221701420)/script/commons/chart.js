function setChart(){

    var date=dateFormat;
    province=document.getElementById("province").innerHTML;
  
    //初始化图表
    var myChart = echarts.init(document.getElementById('chart'));

    // 指定图表的配置项和数据
    option = ({
        title: {
            text: '统计图'
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
   //根据日期获取指定省份情况的情况
   var dataList=new Array();
    for(var i=0;i<12;i++){
        diagnosisChange();
        dataList[i]=sessionStorage.getItem('currentDiagnosis');
    }
    option.series[0].data = dataList;
   
    option.xAxis.data = ['01','02','03','04','05','06','07','08','09','10','11','12 (月)'];
    myChart.setOption(option);

}
//根据日期和省份获得新增确诊情况
function diagnosisChange(date){
    var province= document.getElementById("province").innerHTML;
    var date=dateFormat();
    axios.get('http://47.95.3.253:8080/InfectStatistic/api/query/province/increase/'+date+"/"+province)
    .then(function (response) {
        sessionStorage.setItem('currentDiagnosis',response.data.data.current_diagnosis);
    })
    .catch(function(error){
        console.log(error);
    })
}


