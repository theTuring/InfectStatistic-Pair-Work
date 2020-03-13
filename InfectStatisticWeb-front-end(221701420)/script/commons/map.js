function setMap(set){

    var date=dateFormat();

    var myChart = echarts.init(document.getElementById('map'));
    //修理日期未生成时产生的接口访问错误bug
    if(date==''){
        var temp=new Date();
        var years=temp.getFullYear();
        var month=temp.getMonth();
        month++;
        if(month<10) month='0'+month;
        var days=temp.getDate();
        if(days<10) days='0'+days;
        date=years+'-'+month+'-'+days;
    }
    //根据日期获取全国各省的情况
    axios.get('http://47.95.3.253:8080/InfectStatistic//api/query/province/date/'+date)
    .then(function (response) {
        var dataList=new Array();
        if(set=='现有确诊'){
            for(var i=0;i<34;i++){
                dataList[i]={
                    name:response.data.data[i].province,
                    value:response.data.data[i].current_diagnosis
                }
            }
        }
        else{
            for(var i=0;i<34;i++){
                dataList[i]={
                    name:response.data.data[i].province,
                    value:response.data.data[i].cumulative_diagnosis
                }
            }
        }
        //console.log(dataList);

    
        option = {
            tooltip: {
                formatter:function(params,ticket, callback){
                    return params.seriesName+'<br />'+params.name+'：'+params.value
                }//数据格式化
            },
            visualMap: {
                min: 0,
                max: 1500,
                left: 'left',
                top: 'bottom',
                text: ['高','低'],//取值范围的文字
                inRange: {
                    color: ['#FFFFFF', '#FF0000']//取值范围的颜色
                },
                show:true//图注
            },
            geo: {
                map: 'china',
                roam: false,//不开启缩放和平移
                zoom:1.23,//视角缩放比例
                label: {
                    normal: {
                        show: true,
                        fontSize:'10',
                        color: 'rgba(0,0,0,0.7)'
                    }
                },
                itemStyle: {
                    normal:{
                        borderColor: 'rgba(0, 0, 0, 0.2)'
                    },
                    emphasis:{
                        areaColor: '#F3B329',//鼠标选择区域颜色
                        shadowOffsetX: 0,
                        shadowOffsetY: 0,
                        shadowBlur: 20,
                        borderWidth: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            },
            series : [
                {
                    name: '信息量',
                    type: 'map',
                    geoIndex: 0,
                    data:dataList
                }
            ]
        };
        myChart.setOption(option,true);

        //点击地图上的省份显示详细信息
        myChart.on('click', function (params) {
            var pro=document.getElementById("province");
            pro.innerHTML=params.name;
            setChart();
            setBoxs();
        });

      
    })
    .catch(function (error) {
        console.log(date);
        console.log(error);
    });

}