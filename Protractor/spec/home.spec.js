describe("Testing Caliber Home Page", ()=>{
    let home = require("../src/CaliberHome.js");
    describe("Navigate to the Caliber Trainer page", () => {
        beforeAll(() => {
            browser.driver.manage().window().maximize();
            browser.get("https://dev-caliber.revature.tech");
            browser.sleep(3000);
            browser.navigate().to("https://dev-caliber.revature.tech/caliber/#/trainer/home");
            browser.sleep(3000);
        });
        it("should have 5 <li> if on the Trainer page", () => {
            expect(element.all(by.tagName('li')).count()).toBe(5);
        });
    });
    describe("Are we at the right website?", ()=>{
        it("This should be the home page",()=>{
            expect(home.getHeader().getText()).toBe("Welcome to Caliber!");
        });
    });
    describe("Take me to the Manage Batch page",()=>{
        it("Should take us to to the Manage Batch Page", ()=>{
            expect(home.getManageLink().getText()).toBe("Manage Batch");
            home.getReportsLink().click();
        })
    });
});