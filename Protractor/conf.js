exports.config = {
    //This is the default address for the WebDriver-Manager
    seleniumAddress: "http://localhost:4444/wd/hub",
    //specs takes an array of where your tests are located
    specs: ['./spec/home.spec.js','./spec/manage.spec.js','./spec/assess.spec.js','./spec/report.spec.js'],

    capabilities: {
        browserName: 'chrome'
    },

    framework: 'jasmine2',
    onPrepare: function() {
        var jasmineReporters = require('jasmine-reporters');
        jasmine.getEnv().addReporter(new jasmineReporters.JUnitXmlReporter({
            consolidateAll: true,
            savePath: 'testresults',
            filePrefix: 'xmloutput'
        }));
    },

    onComplete: function() {
        var browserName, browserVersion;
        var capsPromise = browser.getCapabilities();
    
        capsPromise.then(function (caps) {
           browserName = caps.get('browserName');
           browserVersion = caps.get('version');
    
           var HTMLReport = require('protractor-html-reporter');
    
           testConfig = {
               reportTitle: 'Test Execution Report',
               outputPath: './',
               screenshotPath: './screenshots',
               testBrowser: browserName,
               browserVersion: browserVersion,
               modifiedSuiteName: false,
               screenshotsOnlyOnFailure: true
           };

           new HTMLReport().from('./testresults/xmloutput.xml', testConfig);
       });
       
    }
}