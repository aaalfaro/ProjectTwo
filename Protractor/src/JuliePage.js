let JuliePage = function() {

    this.navigateToPage = function(){
        browser.get("http://juliemr.github.io/protractor-demo/");
    }

    this.getPageTitle = function(){
        return browser.getTitle();
    }

    this.getHeader = function() {
        return element(by.tagName('h3'));
    }

    this.getFirstOperand = function(){
        return element(by.model('first'));
    }

    this.getSecondOperand = function(){
        return element(by.model('second'));
    }

    this.getGoButton = function(){
        return element(by.id('gobutton'))
    }
    this.getResult = function(){
        return element(by.className('ng-binding'));
    }

    this.getAddition = function(){
        return element(by.xpath('/html/body/div/div/form/select/option[1]'));
    }

    this.getDivision = function(){
        return element(by.xpath('/html/body/div/div/form/select/option[2]'));
    }

    this.getModulo = function(){
        return element(by.xpath('/html/body/div/div/form/select/option[3]'));
    }

    this.getMultiply = function(){
        return element(by.xpath('/html/body/div/div/form/select/option[4]'));
    }

    this.getSubtract = function(){
        return element(by.xpath('/html/body/div/div/form/select/option[5]'));
    }

    this.multi = function(a,b){
        this.getFirstOperand().sendKeys(a);
        this.getSecondOperand().sendKeys(b);
        this.getMultiply().click();
    }
}

module.exports = new JuliePage();