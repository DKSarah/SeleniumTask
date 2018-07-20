package seleniumTask.bringgWebTests.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seleniumTask.webInfra.pages.BringgSearchResultsPage;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sarahd on 19/07/2018.
 */
public class BringgSearchResultsPageValidations {

    public static void validateFoundCountMatchesSearchPageCount(BringgSearchResultsPage bringgSearchResultsPage){

        if(bringgSearchResultsPage.hasPagination()){
            Integer foundCountNumber = Integer.valueOf(bringgSearchResultsPage.getFoundCount().getText().split(" ")[0]);
            Integer actualSearchPageCountNumber = Integer.valueOf(bringgSearchResultsPage.getSearchPageCount().getText()
                    .split("of " )[1]);
            Integer maxResultsPerPage = bringgSearchResultsPage.getMaxResultsPerPage();
            Integer expectedSearchPageCountNumber = foundCountNumber / maxResultsPerPage +
                    ((foundCountNumber % maxResultsPerPage == 0) ? 0 : 1);
            assertTrue(actualSearchPageCountNumber == expectedSearchPageCountNumber);
        }

    }

    public static void validateNextPageButton(BringgSearchResultsPage bringgSearchResultsPage, WebDriver webDriver){

        if(bringgSearchResultsPage.hasPagination()) {
            Integer beforeClickActivePageIndex = Integer.valueOf(webDriver.findElement(By.className("active")).getText());
            clickNextPageButton(bringgSearchResultsPage);
            Integer afterClickActivePageIndex = Integer.valueOf(webDriver.findElement(By.className("active")).getText());
            assertTrue(afterClickActivePageIndex == beforeClickActivePageIndex + 1);
        }

    }

    private static void clickNextPageButton(BringgSearchResultsPage bringgSearchResultsPage){
        if(bringgSearchResultsPage.hasPagination()) {
            for (WebElement element : bringgSearchResultsPage.getPagesList()) {
                if (!element.getText().equals("…")) {
                    if (element.findElement(By.tagName("a")).getText().equals(bringgSearchResultsPage.getNextPageButtonText())) {
                        bringgSearchResultsPage.click(element);
                        break;
                    }
                }
            }
        }
    }

    public static void validateWhitepapersResultSet(BringgSearchResultsPage bringgSearchResultsPage){

        Integer whitepapersCount = 0;
        for (WebElement element: bringgSearchResultsPage.getResultTypeCountList()) {
            if(element.getText().contains("Whitepapers")){
                whitepapersCount = Integer.valueOf(element.getText().split(" ")[2]);
                bringgSearchResultsPage.click(element);
                break;
            }
        }
        if(whitepapersCount > 0){
            assertTrue(bringgSearchResultsPage.getSearchTableResults().size() == whitepapersCount);
        }
    }
}
