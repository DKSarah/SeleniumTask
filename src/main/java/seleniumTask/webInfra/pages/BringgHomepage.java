package seleniumTask.webInfra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTask.webInfra.BasePage;

/**
 * Created by sarahd on 16/07/2018.
 */
public class BringgHomepage extends BasePage {

    public WebElement getCookieView() {
        return cookieView;
    }

    public void setCookieView(WebElement cookieView) {
        this.cookieView = cookieView;
    }

    @FindBy(id = "hs-eu-cookie-confirmation-inner")
    private WebElement cookieView;

    @FindBy(id = "hs-eu-confirmation-button")
    private WebElement cookieDeclineButton;

    @FindBy(id = "search-icon")
    private WebElement searchIcon;

    @FindBy(id = "header-search-input")
    private WebElement searchBar;


    public BringgHomepage(WebDriver webDriver) {
        super(webDriver);
    }

    public void declineCookies(){
        click(cookieDeclineButton);
    }

    public BringgSearchResultsPage search(String searchText){
        click(searchIcon);
        setSearchText(searchText, searchBar);
        click(searchIcon);
        return new BringgSearchResultsPage(webDriver);
    }
}
