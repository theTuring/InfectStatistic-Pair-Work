function setChart(set){
    if(set==null||set==undefined){
        set=document.getElementById("chartName").value;
    }
    var date=new Date(Date.parse(dateFormat().replace(/-/g,  "/")));
    //相当于date2减去10天
    date-=10*24 * 60 * 60 * 1000;
    //月份格式化
    date=new Date(date);
    var month=date.getMonth();
    var day=date.getDate();
    month++;
    if(month<10) month='0'+month;
    if(day<10) day='0'+day;
    //访问接口的日期格式化
    var date1=date.getFullYear()+'-'+month+'-'+day;
    
    var date2=dateFormat();
    //获取省份
    province=document.getElementById("province").innerHTML;
    if(set==null||set==undefined) set=document.getElementById("chartName").value;
     //初始化图表
     var myChart = echarts.init(document.getElementById('chart'));
     //访问端口
    axios.get('http://47.95.3.253:8080/InfectStatistic/api/query/province/increase/date1_to_date2/'+date1+"/"+date2+"/"+province)
    .then(function (response) {
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
            yAxis: [
                {
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
            ],
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
        //x轴数据数组
        var xAxisData=new Array();

        for(var i=0;i<response.data.data.length;i++){
            if(set=="新增感染者"){
                dataList[i]=response.data.data[i].current_diagnosis;
                if(dataList[i]<0) dataList[i]=0;
            }
            else if(set=="累计感染者"){
                dataList[i]=response.data.data[i].cumulative_diagnosis;
                if(dataList[i]<0) dataList[i]=0;
            }
            else if(set=="治愈"){
                dataList[i]=response.data.data[i].cured;
                if(dataList[i]<0) dataList[i]=0;
            }
            else if(set=="死亡"){
                dataList[i]=response.data.data[i].dead;
                if(dataList[i]<0) dataList[i]=0;
            }
            //x轴为日期
            xAxisData[i]=response.data.data[i].date;

        }
        option.series[0].data = dataList;
        //x轴数据设定
        option.xAxis.data = xAxisData;
        myChart.setOption(option);
    });
   

   

}
//根据日期和省份获得新增确诊情况
function diagnosisChange(date,name){
    //获取选择的省份
    
    var province= document.getElementById("province").innerHTML;
    //接口
    axios.get('http://47.95.3.253:8080/InfectStatistic/api/query/province/increase/'+date+"/"+province)
    .then(function (response) {
           //清除缓存
        sessionStorage.removeItem(date);
        //根据判断存进内存
        if(name=="新增感染者"){
            sessionStorage.setItem(date,response.data.data.current_diagnosis);
        }
        else if(name=="累计感染者"){
            sessionStorage.setItem(date,response.data.data.cumulative_diagnosis);
        }
        else if(name=="治愈"){
            sessionStorage.setItem(date,response.data.data.cured);
        }
        else if(name=="死亡"){
            sessionStorage.setItem(date,response.data.data.dead);
        }
        console.log("a");
    })
    .catch(function(error){
        sessionStorage.setItem(date,'0');
    })
}



