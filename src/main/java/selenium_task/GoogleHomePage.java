package selenium_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sarahd on 16/07/2018.
 */
class GoogleHomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    GoogleHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    boolean isInitialized(){
        return isInitialized(searchBar) && isInitialized(searchButton);
    }

    GoogleSearchResultsPage search(String searchText){
        searchBar.sendKeys(searchText);
        searchButton.click();
        return new GoogleSearchResultsPage(webDriver);
    }
}
