function dataChange(){
    var date=dateFormat();
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
    axios.get('http://47.95.3.253:8080/InfectStatistic//api/query/nation/increase/'+date)
    .then(function (response) {
        document.getElementById("nationExistDiagnosisChange").innerHTML=response.data.data.current_diagnosis;
        document.getElementById("nationExistSuspectsChange").innerHTML=response.data.data.suspected;
        document.getElementById("nationExistSevereChange").innerHTML=0;
        document.getElementById("nationCumulativeDiagnosisChange").innerHTML=response.data.data.cumulative_diagnosis;
        document.getElementById("nationCumulativeCureChange").innerHTML=response.data.data.cured;
        document.getElementById("nationCumulativeDeadChange").innerHTML=response.data.data.dead;
    })
}
