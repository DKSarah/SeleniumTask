package selenium_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by sarahd on 16/07/2018.
 */
class GoogleSearchResultsPage extends BasePage {

    @FindBy(id = "resultStats")
    WebElement resultStats;

    @FindBy(xpath = "//*[@id='rso']//h3/a")
    private  List<WebElement> searchResults;

    GoogleSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    BringgHomepage goToBringgHomePage() throws Exception{
        String bringgURL = "https://www.bringg.com/";
        for (WebElement webElement : searchResults) {
            if(webElement.getAttribute("href").equals(bringgURL)){
                webElement.click();
                return new BringgHomepage(webDriver);
            }
        }
        throw new Exception("Bringg does not appear in google search!");
    }
}
