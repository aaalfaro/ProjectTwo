describe("Testing Caliber Home Page", ()=>{
    let home = require("../src/CaliberHome.js");
    beforeAll(() => {
        home.navigateToPage();
        browser.manage().window().maximize();
    });
    describe("Are we at the right website?", ()=>{
        it("We are at caliber right?", ()=>{
            expect(home.getPageTitle()).toBe("Caliber | Performance Management");
        });
        it("This should be the home page",()=>{
            expect(home.getHeader().getText()).toBe("Welcome to Caliber!");
        });
    });
    describe("Take me to the Manage Batch page",()=>{
        it("Should take us to to the Manage Batch Page", ()=>{
            home.getManageLink().click();
            expect(home.getPageTitle()).toBe("Caliber | Performance Management");
        })
    });
});