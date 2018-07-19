package selenium_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sarahd on 17/07/2018.
 */
public class BasePage {

    WebDriver webDriver;

    BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    boolean isInitialized(WebElement webElement){
        return webElement.isDisplayed();
    }
}
