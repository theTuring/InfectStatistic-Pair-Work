function setChart(province){
    var year=document.getElementById("year").value;
    var month=document.getElementById("month").value;
    var day=document.getElementById("day").value;
    //使日期格式符合接口要求
    if(month<10) month=0+month;
    if(day<10) day=0+day;
    var date=year+"-"+month+"-"+day;

    //出现直接改变日期的情况
    if(province==undefined){
        province=document.getElementById("province").innerHTML;
    }

    var myChart = echarts.init(document.getElementById('chart'));

   //根据日期获取指定省份情况的情况
   axios.get('http://47.95.3.253:8080/InfectStatistic/api/query/province/increase/'+date+"/"+province)
   .then(function (response) {
        var dataList=new Array();
        for(var i=0;i<34;i++){
            dataList[i]={
                name:response.data.data[i].province,
                value:response.data.data[i].current_diagnosis
            }
        }
       console.log(response);

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

        option.xAxis.data = ['01','02','03','04','05','06','07','08','09','10','11','12 (月)'];
        option.series[0].data = dataList;

        myChart.setOption(option);

    })
    .catch(function (error) {
       console.log(error);
    });
   
   
   

}
//根据日期和省份获得变化情况
function dataChange(){
    
}