describe("testing reports page",()=>{
    var Report = require("../src/ReportPage.js");


    describe("loop through all dropdowns",()=>{
        it("user clicks through different years",()=>{
            let dropdown = Report.years();
            dropdown.all(by.tagName("li")).then(function(elements){
                for(let year of elements){
                    Report.yearsButton().click();
                    year.click();
                }
            })
        })
        it("user clicks through different trainers",()=>{
            let dropdown = Report.trainers();
            dropdown.all(by.tagName("li")).then(function(elements){
                for(let trainer of elements){
                    Report.trainersButton().click();
                    trainer.click();
                }
                Report.trainersButton().click();
                elements[0].click();
            })
        })
        it("user clicks through different weeks",()=>{
            let dropdown = Report.weeks();
            dropdown.all(by.tagName("li")).then(function(elements){
                for(let week of elements){
                    Report.weeksButton().click();
                    week.click();
                }
                Report.weeksButton().click();
                elements[0].click();
            })
        })
        it("user clicks through different trainees",()=>{
            let dropdown = Report.trainee();
            let count = 0;
            dropdown.all(by.tagName("li")).then(function(elements){
                for(let trainee of elements){
                    Report.traineeButton().click();
                    trainee.click();
                    if(count !== 0){
                        Report.assessmentBreakdown().click();
                    }
                    count++;
                }
                Report.traineeButton().click();
                elements[0].click();
            })
        })
    })
    describe("Download reports",()=>{
      it("user downloads cumulative scores",()=>{
          let score = Report.cumulativeScore();
          score.element(by.tagName("i")).click();
      })
      it("user download batch QC report",()=>{
          let qc = Report.qcReport();
          qc.element(by.tagName('i')).click();
      })
      it("user downloads tech skill",()=>{
          let skill = Report.techSkills();
          skill.element(by.tagName('i')).click();
      })
      it("user downloads weekly progress",()=>{
          let progress = Report.weeklyProgress();
          progress.element(by.tagName('i')).click();
      })
    })
    describe("user clicks through trainee comparison",()=>{
        it("user clicks on comparison button",()=>{
            Report.comparison().click();
        })
        it("user clicks through different trainees",()=>{
            let tbody = Report.comparisonBody()
            tbody.all(by.tagName("tr")).then(function(rows){
                for(let item of rows){
                    item.element(by.tagName("input")).click();
                }
                Report.comparisonClose().click();
            })
        }) 
    })

})