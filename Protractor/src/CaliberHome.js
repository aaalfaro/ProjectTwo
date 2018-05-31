let CaliberHome = function(){
    this.navigateToPage = function(){
        browser.get("https://dev-caliber.revature.tech/caliber/#/trainer/home");
    }

    this.getPageTitle = function(){
        return browser.getTitle();
    }
    this.getHeader = function(){
        return element(by.tagName("h1"))
    }
    this.getuserGuide = function(){
        return element(by.css("body > div > ui-view > ui-view > div:nth-child(1) > div:nth-child(2) > p > a"));
    }
    this.getManageLink = function(){
        return element(by.css("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(2) > a"));
    }
    this.getAssessLink = function(){
        
    }
    this.getReportsLink = function(){

    }
}
module.exports = new CaliberHome();