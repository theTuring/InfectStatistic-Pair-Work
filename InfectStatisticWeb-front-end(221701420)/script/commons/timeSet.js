//初始化
layui.use('laydate', function(){
    var laydate = layui.laydate;
     
    //执行一个laydate实例
    laydate.render({
        elem: '#time', //指定元素
        value:new Date()
        ,done: function(value, date, endDate){//控件选择完毕后的回调---点击日期、清空、现在、确定均会触发。
            console.log(value); //得到日期生成的值，如：2017-08-18
            console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
            console.log(endDate); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            var set=document.getElementsByClassName("click")[0].innerHTML;
            setMap(set);
            setChart();
            setBoxs();
            dataChange();
        }
    })
});

//返回选项框的日期
function dateFormat(){
    var date=document.getElementById("time").value;
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
   return date;
}