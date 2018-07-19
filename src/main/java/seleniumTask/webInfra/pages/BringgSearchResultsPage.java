package seleniumTask.webInfra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTask.webInfra.BasePage;
import seleniumTask.webInfra.PageConstants;

import java.util.List;

/**
 * Created by sarahd on 17/07/2018.
 */
public class BringgSearchResultsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div/header/h3")
    private WebElement foundCount;

    @FindBy(xpath = "//*[@id=\"content\"]/div/header/h4[2]")
    private WebElement searchPageCount;

    @FindBy(xpath = "//*[@id=\"nav-below\"]/div/ul/li")
    private List<WebElement> pagesList;

    @FindBy(className = "type-count")
    private List<WebElement> resultTypeCountList;

    @FindBy(className = "tr")
    private List<WebElement> searchTableResults;

    private Integer maxResultsPerPage = PageConstants.BringgSearchResultsMaxResultsPerPage;

    private String nextPageButtonText = PageConstants.BringgSearchResultsNextPageButtonText;

    public BringgSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getFoundCount() {
        return foundCount;
    }

    public void setFoundCount(WebElement foundCount) {
        this.foundCount = foundCount;
    }

    public WebElement getSearchPageCount() {
        return searchPageCount;
    }

    public void setSearchPageCount(WebElement searchPageCount) {
        this.searchPageCount = searchPageCount;
    }

    public List<WebElement> getPagesList() {
        return pagesList;
    }

    public void setPagesList(List<WebElement> pagesList) {
        this.pagesList = pagesList;
    }

    public List<WebElement> getResultTypeCountList() {
        return resultTypeCountList;
    }

    public void setResultTypeCountList(List<WebElement> resultTypeCountList) {
        this.resultTypeCountList = resultTypeCountList;
    }

    public List<WebElement> getSearchTableResults() {
        return searchTableResults;
    }

    public void setSearchTableResults(List<WebElement> searchTableResults) {
        this.searchTableResults = searchTableResults;
    }

    public Integer getMaxResultsPerPage() {
        return maxResultsPerPage;
    }

    public String getNextPageButtonText() {
        return nextPageButtonText;
    }

    public boolean hasPagination(){
        Integer foundCountNumber = Integer.valueOf(foundCount.getText().split(" ")[0]);
        return foundCountNumber > maxResultsPerPage;
    }
}
