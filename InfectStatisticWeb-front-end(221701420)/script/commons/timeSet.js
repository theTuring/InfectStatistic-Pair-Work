//根据时间设置
function timeChange(){
    var year=document.getElementById("year").value;
    var month=document.getElementById("month").value;
    var day=document.getElementById("day").value;
    //使日期格式符合接口要求
    if(month<10) month=0+month;
    if(day<10) day=0+day;
    var date=year+"-"+month+"-"+day;
    setMap(date);
}