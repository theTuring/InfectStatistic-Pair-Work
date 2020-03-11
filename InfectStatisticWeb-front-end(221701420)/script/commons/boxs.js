function setBoxs(){
    var date=dateFormat();
    axios.get('http://47.95.3.253:8080/InfectStatistic//api/query/nation/all')
    .then(function(response){
        for(var i=0;i<response.data.data.length;i++){
            if(response.data.data[i].date==date){
                document.getElementById("nationExistDiagnosis").innerHTML=response.data.data[i].current_diagnosis;
                document.getElementById("nationExistSuspects").innerHTML=response.data.data[i].suspected;
                document.getElementById("nationExistSevere").innerHTML=0;
                document.getElementById("nationCumulativeDiagnosis").innerHTML=response.data.data[i].cumulative_diagnosis;
                document.getElementById("nationCumulativeCure").innerHTML=response.data.data[i].cured;
                document.getElementById("nationCumulativeDead").innerHTML=response.data.data[i].dead;

            }
        }
    });
    axios.get('http://47.95.3.253:8080/InfectStatistic///api/query/province/all')
    .then(function(response){
        var pro=document.getElementById("province").innerHTML;
        for(var i=0;i<response.data.data.length;i++){
            if(response.data.data[i].date==date&&response.data.data[i].province==pro){

                document.getElementById("provinceExistDiagnosis").innerHTML=response.data.data[i].current_diagnosis;
                document.getElementById("provinceCumulativeDiagnosis").innerHTML=response.data.data[i].cumulative_diagnosis;
                document.getElementById("provinceCumulativeCure").innerHTML=response.data.data[i].cured;
                document.getElementById("provinceCumulativeDead").innerHTML=response.data.data[i].dead;
            }
        }
    });
}