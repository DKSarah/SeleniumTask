package selenium_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sarahd on 17/07/2018.
 */
class BringgSearchResultsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div/header/h3")
    WebElement foundCount;

    @FindBy(xpath = "//*[@id=\"content\"]/div/header/h4[2]")
    private WebElement searchPageCount;

    @FindBy(xpath = "//*[@id=\"nav-below\"]/div/ul/li")
    private List<WebElement> pagesList;

    @FindBy(className = "type-count")
    private List<WebElement> resultTypeCountList;

    @FindBy(className = "tr")
    private List<WebElement> searchTableResults;

    private final Integer maxResultsPerPage = 12;

    private final String nextPageButtonText = "Next Page »";

    BringgSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    private boolean hasPagination(){
        Integer foundCountNumber = Integer.valueOf(foundCount.getText().split(" ")[0]);
        return foundCountNumber > maxResultsPerPage;
    }

    void validateFoundCountMatchesSearchPageCount(){

        if(hasPagination()){
            Integer foundCountNumber = Integer.valueOf(foundCount.getText().split(" ")[0]);
            Integer actualSearchPageCountNumber = Integer.valueOf(searchPageCount.getText()
                    .split("of " )[1]);
            Integer expectedSearchPageCountNumber = foundCountNumber / maxResultsPerPage +
                    ((foundCountNumber % maxResultsPerPage == 0) ? 0 : 1);
            assertTrue(actualSearchPageCountNumber == expectedSearchPageCountNumber);
        }

    }

    void validateNextPageButton(){

        if(hasPagination()) {
            Integer beforeClickActivePageIndex = Integer.valueOf(webDriver.findElement(By.className("active")).getText());
            clickNextPageButton();
            Integer afterClickActivePageIndex = Integer.valueOf(webDriver.findElement(By.className("active")).getText());
            assertTrue(afterClickActivePageIndex == beforeClickActivePageIndex + 1);
        }

    }

    private BringgSearchResultsPage clickNextPageButton(){
        if(hasPagination()) {
            for (WebElement element : pagesList) {
                if (!element.getText().equals("…")) {
                    if (element.findElement(By.tagName("a")).getText().equals(nextPageButtonText)) {
                        element.click();
                        break;
                    }
                }
            }
        }

        return this;
    }

    void validateWhitepapersResultSet(){

        Integer whitepapersCount = 0;
        for (WebElement element: resultTypeCountList) {
            if(element.getText().contains("Whitepapers")){
                whitepapersCount = Integer.valueOf(element.getText().split(" ")[2]);
                element.click();
                break;
            }
        }
        if(whitepapersCount > 0){
            assertTrue(searchTableResults.size() == whitepapersCount);
        }

    }

}
