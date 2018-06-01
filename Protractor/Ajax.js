var http = require('http');
var parsedData = null;
var Ajax = function(){
    
    this.getTrainers = function(){
        return ajax("getTrainers");
    }
    this.getSkillTypes = function(){
        return ajax("getSkill");
    }
    this.getBatch = function(){
        return ajax("getBatch");
    }
    this.getTrainingTypes= function(){
        return ajax("getTrainingType");
    }
    this.getTrainee = function(){
        return ajax("getTrainee")
    }
    
    function ajax(r){
        var promise = new Promise(function(resolve, reject){
            http.get('http://localhost:8080/ProjectTwo/'+r+'.ajax', (res) => {
            const { statusCode } = res;
            const contentType = res.headers['content-type'];

            let error;
            if (statusCode !== 200) {
                error = new Error('Request Failed.\n' +
                                `Status Code: ${statusCode}`);
            } else if (!/^application\/json/.test(contentType)) {
                error = new Error('Invalid content-type.\n' +
                                `Expected application/json but received ${contentType}`); 
            }
            if (error) {
                console.error(error.message);
                res.resume();
                return;
            }

            res.setEncoding('utf8');
            let rawData = '';
            res.on('data', (chunk) => { rawData += chunk; });
            res.on('end', () => {
                try {
                    var data = JSON.parse(rawData);
                    resolve(data);
                } catch (e) {
                console.error(e.message);
                reject(statusCode);
                }
            });
        }).on('error', (e) => {
        console.error(`Got error: ${e.message}`);
        }).end();
        })
        return promise;
    }
}
module.exports = new Ajax();