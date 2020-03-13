axios.get('http://api.tianapi.com/txapi/ncov/index?key=6e07e5626fdebe0394ff896b6bdb52a3')
.then(function (response) {
    var news=document.getElementById("news");
    for(var i=0;i<response.data.newslist[0].news.length;i++){
        var node=document.createElement('div');
        var a=document.createElement('a');
        a.innerHTML=response.data.newslist[0].news[i].title;
        a.setAttribute("href",response.data.newslist[0].news[i].sourceUrl)
        node.appendChild(a);
        news.appendChild(node);
    }
    
})
.catch(function(error){
    console.log(error);
})