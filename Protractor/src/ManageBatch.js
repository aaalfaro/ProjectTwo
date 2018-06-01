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
    this.ViewTrainees = function(){
         return element(by.css("#manage > div:nth-child(2) > div > div > table > tbody"));
    }
    this.addTrainee = function(){
        return element(by.css("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.col-md-12.col-lg-12 > div > div > a"));
    }
    this.TraineeName = function(){
        return element(by.id("traineeName"));
    }
    this.TraineeEmail = function (){
        return element(by.id("traineeEmail"));
    }
    this.TraineeSkype = function(){
        return element(by.id("traineeSkype"));
    }
    this.TraineePhone = function(){
        return element(by.id("traineePhone"));
    }
    this.TraineeCollege = function(){
        return element(by.id("traineeCollege"));
    }
    this.TraineeDegree = function(){
        return element(by.id("traineeDegree"));
    }
    this.TraineeMajor = function(){
        return element(by.id("traineeMajor"))
    }
    this.TraineeRecruiter = function(){
        return element(by.id("traineeRecruiterName"));
    }
    this.TraineeScreener = function(){
        return element(by.id("traineeTechScreenerName"));
    }
    this.TraineeCompletion = function(){
        return element(by.id("traineeProjectCompletion"));
    }
    this.TraineeURL = function(){
        let div = element(by.css("#addTraineeModal > div > div > div.modal-body > div:nth-child(2) > div:nth-child(6) > div"));
        return div.element(by.id("traineeName"));
    }
    this.TraineeStatus = function(){
        return element(by.id("traineeStatus"));
    }
    this.saveTrainee = function(){
        return element(by.css("#addTraineeModal > div > div > div.modal-body > div.modal-footer > input:nth-child(1)"));
    }
    this.traineeTable = function(){
        return element(by.css("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.col-md-12.col-lg-12 > div > table > tbody"));
    }
    this.traineeActiveButton = function(){
        return element(by.css("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.container.modal-widest > div > a:nth-child(2)"))
    }
    this.traineeUnactiveButton = function(){
        element(by.css("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.container.modal-widest > div > a:nth-child(3)")).click();
    }
    this.closeTrainee = function(){
        element(by.css("#viewTraineeModal > div > div > div.modal-header > button")).click();
    }
    this.updateTrainee = function(){
        element(by.css("#addTraineeModal > div > div > div.modal-body > div.modal-footer > input:nth-child(3)")).click();
    }
    this.updateBatch = function(){
        element(by.css("#createBatchModal > div > div > div.modal-footer > input")).click();
    }
    this.assessBatch = function(){
        element(by.css("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(3) > a")).click();
    }
    this.deleteBatch = function(){
        element(by.css("#deleteBatchModal > div > div > div.modal-footer > input")).click();
    }

}
module.exports = new Manage();