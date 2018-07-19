package seleniumTask.webInfra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTask.webInfra.BasePage;
import seleniumTask.webInfra.PageConstants;

/**
 * Created by sarahd on 16/07/2018.
 */
public class GoogleHomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    private String googleHomepageUrl = PageConstants.googleHomepageUrl;

    public GoogleHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getGoogleHomepageUrl() {
        return googleHomepageUrl;
    }

    public boolean isInitialized(){
        return isInitialized(searchBar) && isInitialized(searchButton);
    }

    public GoogleSearchResultsPage search(String searchText){
        setSearchText(searchText, searchBar);
        click(searchButton);
        return new GoogleSearchResultsPage(webDriver);
    }
}
