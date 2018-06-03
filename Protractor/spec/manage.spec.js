//Tests go to fast and get an element not found exception when trying
//to create a new batch. This function slows down the test to execute every 100 ms,
//Also buys more time for AJAX calls to complete
var origFn = browser.driver.controlFlow().execute;

browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(50);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};


describe("Testing manage page", ()=>{
    let manage = require("../src/ManageBatch.js");
    var ajax = require("../Ajax.js");
    

    var trainers = ajax.getTrainers();
    var batch  = ajax.getBatch();
    var training = ajax.getTrainingTypes();
    var skill = ajax.getSkillTypes();
    var trainees = ajax.getTrainee();

    trainers.then((val)=> trainers = val);
    batch.then((val)=> batch = val);
    skill.then((val)=> skill = val);
    training.then((val)=>training = val);
    trainees.then((val)=> trainees = val);

    describe("Just making sure we are at the correct page", ()=>{
        it("user should be at the manage page",()=>{
            expect(manage.getPageTitle()).toBe("Caliber | Performance Management");
        })
    })
    describe('user clicks through links to other pages',()=>{
        it("user clicks on assess batch",()=>{
            manage.assessBatch();  
        })
        it("user clicks on report",()=>{
            manage.reports();
        })
        it("user clicks back to manage page",()=>{
            manage.managePage();
        })
    })
    describe("Testing dropdown for year",()=>{
        it("should cycle through all options in the dropdown",()=>{
            dropdown = manage.getYearDropdown();
            
            dropdown.$$('.dropdown-menu li').each(function(element, index){
                dropdown.click();
                element.click();
            })
        })
    })

    describe("Creating a new batch",()=>{
        it("user clicks on the create batch button",()=>{
            newBatch = manage.createNewBatchButton().click();
        })
        it("user inputs information about the new batch",()=>{
            manage.insertTrainingName().sendKeys(batch[1].name);
            expect(manage.insertTrainingName().getAttribute('value')).toBe(batch[1].name);
        })

        it("user selects training type",()=>{
            let select = manage.insertType();
            let count = 0;
            select.all(by.tagName('option')).then(function(elements){
                for(let option of elements){
                    option.click(); 
                }
                elements[1].click();
            })
        })
        it("user selects skill type",()=>{
            let select = manage.insertSkillType();
            let count = 0;
            select.all(by.tagName('option')).then(function(elements){
                for(let option of elements){
                    if(count !== 0){
                        expect(option.getText()).toBe(skill[count-1].type);
                        option.click();
                    }
                    count++;
                }
            })
        })
        it("user selects a location",()=>{
            let select = manage.insertLocation();
            let count = 2;
            select.all(by.tagName('optgroup')).then(function(elements){
                for(let optgroup of elements){
                    optgroup.all(by.tagName('option')).then(function(element){
                        for(let option of element){
                            expect(option.getText()).toBe(batch[count].location);
                            option.click();
                        }
                        count--;
                    })
                }
            })
        })
        it("user selects a trainer",()=>{
            let select = manage.insertTrainer();
            select.all(by.tagName('option')).then(function(elements){
                for(let option of elements){
                    option.click();
                    
                }
                elements[10].click();
            })
        })

        it("user selects a trainer",()=>{
            let select = manage.insertCoTrainer();
            select.all(by.tagName('option')).then(function(elements){
                for(let option of elements){
                    option.click();
                }
                elements[1].click();
            })
        })

        it("user selects a start date",()=>{
            let select = manage.insertStartDate();
            select.sendKeys(batch[1].startDate);
        })

        it("user selects an end date",()=>{
            let select = manage.insertEndDate();
            select.sendKeys(batch[1].endDate);
        })

        it("user selects a good grade",()=>{
            let select = manage.insertGoodGrade();
            select.sendKeys(batch[1].goodGrade.toString());
            expect(select.getAttribute('value')).toBe(batch[1].goodGrade.toString());
        })
        
        it("user selects a passing grade",()=>{
            let select= manage.insertPassingGrade();
            select.clear().then(function(){
                select.sendKeys(batch[1].passingGrade.toString());
            expect(select.getAttribute('value')).toBe(batch[1].passingGrade.toString());
            })
        })
        it("user saves the batch",()=>{
            let button = manage.saveButton();
            button.click();
        })
    })
    describe("A user modifies a batch",()=>{
        it("clicks on add trainee",()=>{
           let batchRow =  manage.ViewTrainees();
           let lastRow;
           batchRow.all(by.tagName("tr")).then(function(rows){
                lastRow = rows[rows.length -1];
                lastRow.all(by.tagName("td")).then(function(row){
                    let colCount = 0;
                    for(let columns of row){
                        if(colCount == 10){
                            columns.element(by.tagName("a")).click();
                            break;
                        }
                        colCount++;
                    }
                })
           })

        })
        it("user clicks button to add a trainee",()=>{
            let add = manage.addTrainee();
            add.click();
            let header = element(by.css("#traineeModalLabel"));
            expect(header.getText()).toBe("View/Add Trainees");
        })
        it("user adds trainee name", ()=>{
            manage.TraineeName().sendKeys(trainees[0].name);
            expect(manage.TraineeName().getAttribute('value')).toBe(trainees[0].name);
        })
        it("user enters an email address",()=>{
            manage.TraineeEmail().sendKeys(trainees[0].email);
            expect(manage.TraineeEmail().getAttribute('value')).toBe(trainees[0].email);
        })
        it("user enters skype ID",()=>{
            manage.TraineeSkype().sendKeys(trainees[0].skype);
            expect(manage.TraineeSkype().getAttribute('value')).toBe(trainees[0].skype);
        })
        it("user eneters a phone number",()=>{
            manage.TraineePhone().sendKeys(trainees[0].phone);
            expect(manage.TraineePhone().getAttribute('value')).toBe(trainees[0].phone);
        })
        it("user enters college name",()=>{
            manage.TraineeCollege().sendKeys(trainees[0].college);
            expect(manage.TraineeCollege().getAttribute('value')).toBe(trainees[0].college);
        })
        it("user enters degree",()=>{
            manage.TraineeDegree().sendKeys(trainees[0].degree);
            expect(manage.TraineeDegree().getAttribute('value')).toBe(trainees[0].degree);
        })
        it("user enters major",()=>{
            manage.TraineeMajor().sendKeys(trainees[0].major);
            expect(manage.TraineeMajor().getAttribute('value')).toBe(trainees[0].major);
        })
        it("user enters recuiter name",()=>{
            manage.TraineeRecruiter().sendKeys(trainees[0].recruiter);
            expect(manage.TraineeRecruiter().getAttribute('value')).toBe(trainees[0].recruiter);
        })
        it("user enters tech screener name",()=>{
            manage.TraineeScreener().sendKeys(trainees[0].screener);
            expect(manage.TraineeScreener().getAttribute('value')).toBe(trainees[0].screener);
        })
        it("user enters project completion",()=>{
            manage.TraineeCompletion().sendKeys(trainees[0].completion.toString());
            expect(manage.TraineeCompletion().getAttribute('value')).toBe(trainees[0].completion.toString());
        })
        it("user enter profile URL",()=>{
            manage.TraineeURL().sendKeys(trainees[0].url);
            expect(manage.TraineeURL().getAttribute('value')).toBe(trainees[0].url);
        })
        it("cycle through status",()=>{
            let status = manage.TraineeStatus();
            status.all(by.tagName("option")).then(function(elements){
                for(let option of elements){
                    option.click();
                }
                elements[3].click();
            })
        })
        it("user saves trainee",()=>{
            manage.saveTrainee().click();
        })
        it("user edits trainee information",()=>{
            let table = manage.traineeTable();
            let recruiter = trainees[0].recruiter.substring(0,4);
            let last;
            table.all(by.tagName("tr")).then(function(rows){
                last = rows[rows.length-1];
                last.all(by.tagName("td")).then(function(cols){
                    cols[13].element(by.tagName("a")).click();
                })  
            })
            manage.TraineeRecruiter().clear().then(function(){
                manage.TraineeRecruiter().sendKeys(recruiter);
            expect(manage.TraineeRecruiter().getAttribute('value')).toBe(recruiter);
            })
            manage.updateTrainee();
        })
        it("user clicks on active button",()=>{
            manage.traineeActiveButton().click();
            manage.traineeUnactiveButton();
            manage.closeTrainee();
        })
        it("user clicks edit batch button",()=>{
            let batchRow =  manage.ViewTrainees();
            let lastRow;
             batchRow.all(by.tagName("tr")).then(function(rows){
                lastRow = rows[rows.length -1];
                lastRow.all(by.tagName("td")).then(function(row){
                    row[11].element(by.tagName("a")).click()
                })
           })
        })
        it("user changes skill",()=>{
            let skill = manage.insertSkillType();
            skill.all(by.tagName("option")).then(function(option){
                option[8].click();
            })
            manage.updateBatch();
        })
        it("user deletes batch",()=>{
            let batchRow =  manage.ViewTrainees();
            let lastRow;
             batchRow.all(by.tagName("tr")).then(function(rows){
                lastRow = rows[rows.length -1];
                lastRow.all(by.tagName("td")).then(function(row){
                    row[12].element(by.tagName("a")).click()
                })
                manage.deleteBatch();
           })
        })
    })
    describe("assess link",()=>{
        it("user clicks on assess batch",()=>{
            manage.assessBatch();
        })
    })
})