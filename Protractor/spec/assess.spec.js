describe("Testing assess batch page",()=>{
    var until = protractor.ExpectedConditions;
    var assess = require("../src/AssessPage.js");
    var ajax = require("../Ajax.js");
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 5000000;
    var assessment = ajax.getAssessment();
    assessment.then((val)=> assessment = val);

    describe("user clicks through week tabs",()=>{
        it("user clicks through all possible tabs in all years",()=>{
            assess.yearDropdown().click();
            let button = assess.yearList();
            button.all(by.tagName("li")).then(function(years){
                for(let year of years){
                        year.element(by.tagName('a')).click();
                            assess.weekList().all(by.tagName('li')).then(function(weeks){
                                for(let week of weeks){
                                    week.element(by.tagName('a')).click();
                                }
                                
                            })
                    assess.addWeekNo();
                    assess.yearDropdown().click();
                }
                
            })  
        })
    })
    describe("test creating assessment and cycling through trainers",()=>{
        it("user cycles through trainers",()=>{
            assess.trainerButton();
            assess.trainerList().all(by.tagName('li')).then(function(trainers){
                for(let trainer of trainers){
                    trainer.element(by.tagName('a')).click();
                    assess.trainerButton();
                }
               trainers[0].click();
            })
        })
        it("user creates an assessment",()=>{
            assess.createAssessement();
            let category = assess.category();
            let types = assess.type();
            category.all(by.tagName('option')).then(function(options){
                for(let cat of options){
                    cat.click();
                }
            })
            types.all(by.tagName('option')).then(function(options){
                for(let t of options){
                    t.click();
                }
            })
            assess.score().sendKeys(assessment.point);
            expect(assess.score().getAttribute('value')).toBe(assessment.point);
            assess.newAssessmentSave().click();
        })
    })
    describe("user input into assessment table",()=>{
        it("clicks on all columns in a row",()=>{
            let table = assess.tableBody();
            let count = 0;
            table.all(by.tagName('tr')).then(function(rows){
                for(let row of rows){
                    row.all(by.tagName('td')).then(function(columns){
                        for(let col of columns){
                            if(count > 1 && count !== columns.length -1){
                                col.element(by.tagName('input')).clear().sendKeys("50");
                            }
                            if(count === columns.length -1){
                                let text = col.element(by.tagName("textarea"));
                                text.clear().sendKeys("This is a note");
                                expect(text.getAttribute('value')).toBe("This is a note");
                            }
                            count++;
                        }
                        count = 0;
                    })
                }
            })
        })
    })
    describe("Enter feedback and save",()=>{
        it("user enters feedback",()=>{
            assess.feedback().clear().sendKeys("This batch is ok");
            expect(assess.feedback().getAttribute('value')).toBe("This batch is ok");
        })
        it("user clicks on save button",()=>{
            expect(assess.saveButton().getText()).toBe("Save");
            assess.saveButton().click();
        })
        it("add a new week",()=>{
            let list = assess.weekList();
            list.all(by.tagName('li')).then(function(week){
                week[week.length-1].element(by.tagName('a')).click();
                assess.addWeekYes();
            })
        })
    })
    describe("Report page",()=>{
        it("user clicks on report page",()=>{
            expect(assess.reportPage().getText()).toBe("Reports");
            assess.reportPage().click();
        })
    })
})