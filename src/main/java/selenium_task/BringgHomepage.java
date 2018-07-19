package selenium_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sarahd on 16/07/2018.
 */
class BringgHomepage extends BasePage {

    @FindBy(id = "hs-eu-cookie-confirmation-inner")
    WebElement cookieView;

    @FindBy(id = "hs-eu-confirmation-button")
    private WebElement cookieDeclineButton;

    @FindBy(id = "search-icon")
    private WebElement searchIcon;

    @FindBy(id = "header-search-input")
    private WebElement searchBar;


    BringgHomepage(WebDriver webDriver) {
        super(webDriver);
    }

    void declineCookies(){
        cookieDeclineButton.click();
    }

    BringgSearchResultsPage search(String searchText){
        searchIcon.click();
        searchBar.sendKeys(searchText);
        searchIcon.click();
        return new BringgSearchResultsPage(webDriver);
    }
}
