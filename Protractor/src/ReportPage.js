let Reports = function(){
    this.years = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(1) > ul"));
    }
    this.yearsButton = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(1) > a"));
    }
    this.trainers = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(2) > ul"));
    }
    this.trainersButton = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(2) > a"));
    }
    this.weeks = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(3) > ul"));
    }
    this.weeksButton = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(3) > a"));
    }
    this.trainee = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(4) > ul"));
    }
    this.traineeButton = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div > ul > li:nth-child(4) > a"));
    }
    this.cumulativeScore = function(){
        return element(by.css("#caliber-container > div > div > div.col-sm-12.col-md-12.col-lg-12 > div:nth-child(1) > div > div > div.panel-heading"));
    }
    this.qcReport = function(){
        return element(by.css("#caliber-container > div > div > div.col-sm-12.col-md-12.col-lg-12 > div.row.ng-scope > div > div > div > div > div.panel-heading"));
    }
    this.techSkills = function(){
        return element(by.css("#caliber-container > div > div > div.row > div.col-sm-5.col-md-5.col-lg-5 > div > div.panel-heading"));
    }
    this.weeklyProgress = function(){
        return element(by.css("#caliber-container > div > div > div.row > div.col-sm-7.col-md-7.col-lg-7 > div.panel.panel-default > div.panel-heading"));
    }
    this.comparison = function(){
        return element(by.css("#caliber-container > div > div > div.row > div.col-sm-5.col-md-5.col-lg-5 > div > div.panel-heading > div > i"));
    }
    this.comparisonBody = function(){
        return element(by.css("#insert-trainee > div > div > div.modal-body > div > table > tbody"));
    }
    this.comparisonClose = function(){
        return element(by.css("#insert-trainee > div > div > div.modal-header > button"));
    }
    this.assessmentBreakdown = function(){
        return element(by.css("#caliber-container > div.row.ng-scope > div.col-sm-12.col-md-12.col-lg-12 > div:nth-child(1) > div > div > div.panel-heading > i"));
    }
}
module.exports = new Reports();