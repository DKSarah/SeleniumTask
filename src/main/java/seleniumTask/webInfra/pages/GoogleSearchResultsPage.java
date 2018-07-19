package seleniumTask.webInfra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTask.webInfra.BasePage;

import java.util.List;

/**
 * Created by sarahd on 16/07/2018.
 */
public class GoogleSearchResultsPage extends BasePage {

    @FindBy(id = "resultStats")
    private WebElement resultStats;

    @FindBy(xpath = "//*[@id='rso']//h3/a")
    private  List<WebElement> searchResults;

    public GoogleSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getResultStats() {
        return resultStats;
    }

    public void setResultStats(WebElement resultStats) {
        this.resultStats = resultStats;
    }

    public BringgHomepage goToBringgHomePage() throws Exception{
        String bringgURL = "https://www.bringg.com/";
        for (WebElement webElement : searchResults) {
            if(webElement.getAttribute("href").equals(bringgURL)){
                click(webElement);
                return new BringgHomepage(webDriver);
            }
        }
        throw new Exception("Bringg does not appear in google search!");
    }
}
