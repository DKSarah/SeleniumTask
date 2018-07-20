package seleniumTask.webInfra.pages;

import org.openqa.selenium.Keys;
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

    private String googleHomepageUrl = PageConstants.googleHomepageUrl;

    public GoogleHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(WebElement searchBar) {
        this.searchBar = searchBar;
    }

    public String getGoogleHomepageUrl() {
        return googleHomepageUrl;
    }

    public GoogleSearchResultsPage search(String searchText){
        setSearchText(searchText, searchBar);
        searchBar.sendKeys(Keys.RETURN);
        return new GoogleSearchResultsPage(webDriver);
    }
}
