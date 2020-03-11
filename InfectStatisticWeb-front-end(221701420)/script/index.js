//设置时间选项
var setTime=document.getElementById("timeSet");
//初始化
setMap();
setChart();
setBoxs();
function changeChart(set){
    document.getElementById("chartName").value=set;
    setChart();
}
