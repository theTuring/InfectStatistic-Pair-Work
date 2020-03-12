var date=dateFormat();
axios.get('http://47.95.3.253:8080/InfectStatistic//api/query/nation/increase/'+date)
.then(function (response) {
    document.getElementById("nationExistDiagnosisChange").innerHTML=response.data.data.current_diagnosis;
    document.getElementById("nationExistSuspectsChange").innerHTML=response.data.data.suspected;
    document.getElementById("nationExistSevereChange").innerHTML=0;
    document.getElementById("nationCumulativeDiagnosisChange").innerHTML=response.data.data.cumulative_diagnosis;
    document.getElementById("nationCumulativeCureChange").innerHTML=response.data.data.cured;
    document.getElementById("nationCumulativeDeadChange").innerHTML=response.data.data.dead;
})