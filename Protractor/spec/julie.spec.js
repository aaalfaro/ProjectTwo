describe("Page object models can also be leveraged in protractor",()=>{
    
    let julie = require("../src/JuliePage.js")
    beforeAll(()=>{
        julie.navigateToPage();
        browser.manage().window().maximize();
    });
    describe("This spec is much cleaner than helloWorld.spec.js", ()=>{
        it("should navigate properly",()=>{
            expect(julie.getPageTitle()).toBe("Super Calculator");
        });
        it("Should say super calculator",()=>{
            expect(julie.getHeader().getText()).toBe("Super Calculator");
        });
    });
    describe("Super Calculator performs addition well", ()=>{
        it("Should add 10 and 20 properly", ()=>{
            julie.getFirstOperand().sendKeys(10);
            julie.getSecondOperand().sendKeys(20);
            julie.getGoButton().click();
            expect(julie.getResult().getText()).toBe('30');
        });
    });
    describe("Super Calculator should perform division properly", ()=>{
        it("Should divide 15 into 3", ()=>{
            julie.getFirstOperand().sendKeys(15);
            julie.getSecondOperand().sendKeys(3);
            julie.getDivision().click();
            julie.getGoButton().click();
            expect(julie.getResult().getText()).toBe('5');
            
        });
    })
    describe("Super Calculator rocks at multiplication", ()=>{
        it("Should find the product of 10 and 20",()=>{
            julie.multi(10,20);
            expect(julie.getResult().getText()).toBe('200');
        });
    });
});