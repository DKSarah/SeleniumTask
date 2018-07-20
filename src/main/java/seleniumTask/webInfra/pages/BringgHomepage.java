package seleniumTask.webInfra.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTask.webInfra.BasePage;

/**
 * Created by sarahd on 16/07/2018.
 */
public class BringgHomepage extends BasePage {

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

    public WebElement getCookieView() {
        return cookieView;
    }

    public void setCookieView(WebElement cookieView) {
        this.cookieView = cookieView;
    }

    public WebElement getCookieDeclineButton() {
        return cookieDeclineButton;
    }

    public void setCookieDeclineButton(WebElement cookieDeclineButton) {
        this.cookieDeclineButton = cookieDeclineButton;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public void setSearchIcon(WebElement searchIcon) {
        this.searchIcon = searchIcon;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(WebElement searchBar) {
        this.searchBar = searchBar;
    }

    public void declineCookies(){
        click(cookieDeclineButton);
    }

    public BringgSearchResultsPage search(String searchText){
        click(searchIcon);
        setSearchText(searchText, searchBar);
        searchBar.sendKeys(Keys.RETURN);
        return new BringgSearchResultsPage(webDriver);
    }
}
