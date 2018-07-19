package selenium_task;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sarahd on 18/07/2018.
 */
abstract class AbstractTest extends FunctionalTest {

    AbstractTest navigateToGoogleHomePage(){

        webDriver.get("https://www.google.com");
        GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
        assertTrue(googleHomePage.isInitialized());

        return this;
    }

    AbstractTest searchInGoogleHomePage(String searchText){

        GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
        GoogleSearchResultsPage googleSearchResultsPage = googleHomePage.search(searchText);
        assertTrue(googleSearchResultsPage.isInitialized(googleSearchResultsPage.resultStats));

        return this;
    }

    AbstractTest navigateToBringgHomePageFromSearchResults() throws Exception {

        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(webDriver);
        BringgHomepage bringgHomepage = googleSearchResultsPage.goToBringgHomePage();
        assertTrue(bringgHomepage.isInitialized(bringgHomepage.cookieView));
        bringgHomepage.declineCookies();

        return this;
    }

    AbstractTest searchInBringgHomePage(String searchText){

        BringgHomepage bringgHomepage = new BringgHomepage(webDriver);
        BringgSearchResultsPage bringgSearchResultsPage = bringgHomepage.search(searchText);
        assertTrue(bringgSearchResultsPage.isInitialized(bringgSearchResultsPage.foundCount));

        return this;
    }

    void validateBringgSearchResultsPage() {

        BringgSearchResultsPage bringgSearchResultsPage = new BringgSearchResultsPage(webDriver);
        bringgSearchResultsPage.validateFoundCountMatchesSearchPageCount();
        bringgSearchResultsPage.validateNextPageButton();
        bringgSearchResultsPage.validateWhitepapersResultSet();
    }
}
