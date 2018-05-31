let Manage = function(){
    this.getPageTitle = function(){
        return browser.getTitle();
    }
    this.getYearDropdown = function(){
        return element(by.css("#manage > div:nth-child(1) > div > div > ul > li.dropdown"));
    }
    this.createNewBatchButton = function(){
        return element(by.css("#manage > div:nth-child(1) > div > div > ul > li:nth-child(3)"));
    }
    this.insertTrainingName = function(){
        return element(by.id("trainingName"));
    }
    this.insertType = function(){
        return element(by.css("#trainingType"));
    }
    
    this.insertSkillType = function(){
        return element(by.id("skillType"));
    }
    this.insertLocation = function(){
        return element(by.id("location"));
    }
    this.insertTrainer = function(){
        return element(by.id("trainer"))
    }
    this.insertCoTrainer = function(){
        return element(by.id("co-trainer"));
    }
    this.insertStartDate = function(){
        return element(by.css("#start-date > input"));
    }
    this.insertEndDate = function(){
        return element(by.css("#end-date > input"));
    }
    this.insertGoodGrade = function(){
        return element(by.id("goodGrade"));
    }
    this.insertPassingGrade = function(){
        return element(by.id("borderlineGrade"));
    }
    this.saveButton = function (){
        return element(by.css("#createBatchModal > div > div > div.modal-footer > input"));
    }
    this.closeButton = function(){
        return element(by.css("#createBatchModal > div > div > div.modal-footer > button"));
    }
    this.importBatchButton = function(){
        return element(by.css(""));
    }
    this.addTrainee = function(){
         return element(by.css("#manage > div:nth-child(2) > div > div > table > tbody"));
    }
}
module.exports = new Manage();