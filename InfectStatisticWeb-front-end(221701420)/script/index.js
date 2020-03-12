//设置时间选项
var setTime=document.getElementById("timeSet");
//初始化
setMap();
setChart();
setBoxs();
function changeChart(set){
    document.getElementById("chartName").value=set;
    setChart(set);
}

function changeMap(set){
    setMap(set);
    if(set=="累计确诊"){
        document.getElementById("cumulativeBnt").removeAttribute("class");
        document.getElementById("existBnt").removeAttribute("class");
        document.getElementById("cumulativeBnt").classList.add("click");
        document.getElementById("existBnt").classList.add("unclick");
    }
    else{
        document.getElementById("existBnt").removeAttribute("class");
        document.getElementById("cumulativeBnt").removeAttribute("class");
        document.getElementById("existBnt").classList.add("click");
        document.getElementById("cumulativeBnt").classList.add("unclick");
    }
}