//Tests go to fast and get an element not found exception when trying
//to create a new batch. This function slows down the test to execute every 100 ms,
//Also buys more time for AJAX calls to complete
var origFn = browser.driver.controlFlow().execute;

browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(20);
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

     trainers.then((val)=> trainers = val);
    batch.then((val)=> batch = val);
    skill.then((val)=> skill = val);
    training.then((val)=>training = val);

    describe("Just making sure we are at the correct page", ()=>{
        it("user should be at the manage page",()=>{
            expect(manage.getPageTitle()).toBe("Caliber | Performance Management");
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
            manage.insertTrainingName().sendKeys(batch[0].name);
            expect(manage.insertTrainingName().getAttribute('value')).toBe(batch[0].name);
        })

        it("user selects training type",()=>{
            let select = manage.insertType();
            let count = 0;
            select.all(by.tagName('option')).then(function(elements){
                for(let option of elements){
                    if( count !== 0){
                        expect(option.getText()).toBe(training[count-1].type);
                        option.click();
                    }
                    count++;
                }
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
            let count = 1;
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
            // for(let trainer of trainers){
            //     select.element(by.css('option[value="'+trainer.name+'"]')).click();
            // }
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
            select.sendKeys(batch[0].startDate);
            // expect(select.getAttribute('value')).toBeCloseTo(batch[0].startDate);
            
        })

        it("user selects an end date",()=>{
            let select = manage.insertEndDate();
            select.sendKeys(batch[0].endDate);
            // expect(select.getText()).toBe(batch[0].endDate);
        })

        it("user selects a good grade",()=>{
            let select = manage.insertGoodGrade();
            select.sendKeys(batch[0].goodGrade.toString());
            expect(select.getAttribute('value')).toBe(batch[0].goodGrade.toString());
        })
        
        it("user clicks the save button",()=>{
            let select= manage.insertPassingGrade();
            select.sendKeys(batch[0].passingGrade.toString());
        })
        it("user saves the batch",()=>{
            let button = manage.saveButton();
            button.click();
        })
    })
    describe("A user modifies a batch",()=>{
        it("clicks on add ",()=>{
           let batchRow =  manage.addTrainee();
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
    })
})