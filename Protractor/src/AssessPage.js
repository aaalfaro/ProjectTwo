let Assess = function(){
    this.navigateToPage = function(){
        browser.get("https://dev-caliber.revature.tech/caliber/#/trainer/assess");
    }
    this.getPageTitle = function(){
        return browser.getTitle();
    }
    this.createAssessement = function(){
        element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.pull-right > a")).click();
    }
    this.yearDropdown = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > a"));
    }
    this.weekList = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-sm-12.col-md-12.col-lg-12.top5 > ul"));
    }
    this.yearList = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.dropdown.open > ul"));
    }
    this.trainerButton = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > a")).click();
    }
    this.trainerList = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.dropdown.open > ul"));
    }
    this.addWeekNo = function(){
        element(by.css("#confirmingweeks > div > div > div.modal-footer > button.btn.btn-default")).click();
    }
    this.addWeekYes = function(){
        element(by.id("yesBtn")).click();
    }
    this.category = function(){
        return element(by.model("category.model"));
    }
    this.type = function(){
        return element(by.model("assessmentType.model"));
    }
    this.tableBody = function(){
        return element(by.css("#trainer-assess-table > div > div > ul > ul > table > tbody"));
    }
    this.newAssessmentBody = function(){
        return element(by.css("#createAssessmentModal > div > div > form > div.modal-body > "));
    }
    this.newAssessmentClose = function(){
        element(by.css("#createAssessmentModal > div > div > form > div.modal-footer > button")).click();
    }
    this.score = function(){
        return element(by.id('rawScore'));
    }
    this.newAssessmentSave = function(){
        return element(by.css("#createAssessmentModal > div > div > form > div.modal-footer > input"));
    }
    this.assessmentTableHeader = function(){
        return element(by.css("#trainer-assess-table > div > div > ul > ul > table > thead > tr"));
    }
    this.deleteAssessment = function(){
        element(by.css("#editAssessmentModal_158030 > div > div > div:nth-child(3) > div:nth-child(1)")).click();
    }
    this.feedback = function(){
        return element(by.id("tBatchNotes"));
    }
    this.saveButton = function(){
        return element(by.css("#trainer-assess-table > div > div > ul > ul > div.form-group.col-lg-12.col-md-12.col-sm-12.overall-feedback > div > a"));
    }
    this.reportPage = function(){
        return element(by.css('body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(4) > a'));
    }
}
module.exports = new Assess();