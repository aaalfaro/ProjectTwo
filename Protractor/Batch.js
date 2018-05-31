let Batch = function() {
    getBatch();
}

function getBatch(){
    let ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function(){
        if(ajax.readyState ===4 && ajax.status ===200){
            return JSON.parse(ajax.responseText);
        }
    }
    ajax.open("GET","localhost:8080/ProjectTwo/getBatch.ajax");
    ajax.send();
}