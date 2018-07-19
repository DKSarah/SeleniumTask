package seleniumTask.webInfra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sarahd on 17/07/2018.
 */
public class BasePage extends PageConstants{

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isInitialized(WebElement webElement){
        return webElement.isDisplayed();
    }

    public void goToWebsite(String url){
        webDriver.get(url);
    }

    public void setSearchText(String searchText, WebElement webElement){
        webElement.sendKeys(searchText);
    }

    public void click(WebElement webElement){
        webElement.click();
    }

//    driver() if wendriver==nul return webdriver
//    gotowebsite(url)
//    click
//    search
//    get
}
