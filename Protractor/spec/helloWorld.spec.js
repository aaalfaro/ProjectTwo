describe("Protractor uses the Jasmin syntax by default", () =>{
    describe("Browser is a global variable used for browser level operations", () =>{
        beforeAll(()=> {
            browser.get("http://juliemr.github.io/protractor-demo/");
            browser.manage().window().maximize();
        });
        let header = element(by.tagName('h3'));

        it("Should navigate to the correct page", ()=>{
            expect(browser.getTitle()).toBe('Super Calculator');
        });

        it("should have the correct header", ()=>{
            expect(header.getText()).toBe('Super Calculator');
        });
    });
});