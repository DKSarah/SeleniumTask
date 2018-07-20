package seleniumTask.bringgWebTests;

import seleniumTask.bringgWebTests.validations.BringgSearchResultsPageValidations;
import seleniumTask.webInfra.pages.BringgHomepage;
import seleniumTask.webInfra.pages.BringgSearchResultsPage;
import seleniumTask.webInfra.pages.GoogleHomePage;
import seleniumTask.webInfra.pages.GoogleSearchResultsPage;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sarahd on 18/07/2018.
 */
public abstract class AbstractBringgWebTest extends FunctionalBringgWebTest {

    public AbstractBringgWebTest navigateToGoogleHomePage(){

        GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
        googleHomePage.goToWebsite(googleHomePage.getGoogleHomepageUrl());
        assertTrue(googleHomePage.isInitialized(googleHomePage.getSearchBar()));

        return this;
    }

    public AbstractBringgWebTest searchInGoogleHomePage(String searchText){

        GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
        GoogleSearchResultsPage googleSearchResultsPage = googleHomePage.search(searchText);
        assertTrue(googleSearchResultsPage.isInitialized(googleSearchResultsPage.getResultStats()));

        return this;
    }

    public AbstractBringgWebTest navigateToBringgHomePageFromGoogleSearchResults() throws Exception {

        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(webDriver);
        BringgHomepage bringgHomepage = googleSearchResultsPage.goToBringgHomePage();
        assertTrue(bringgHomepage.isInitialized(bringgHomepage.getCookieView()));
        bringgHomepage.declineCookies();

        return this;
    }

    public AbstractBringgWebTest searchInBringgHomePage(String searchText){

        BringgHomepage bringgHomepage = new BringgHomepage(webDriver);
        BringgSearchResultsPage bringgSearchResultsPage = bringgHomepage.search(searchText);
        assertTrue(bringgSearchResultsPage.isInitialized(bringgSearchResultsPage.getFoundCount()));

        return this;
    }

    public void validateBringgSearchResultsPage() {

        BringgSearchResultsPage bringgSearchResultsPage = new BringgSearchResultsPage(webDriver);
        BringgSearchResultsPageValidations.validateFoundCountMatchesSearchPageCount(bringgSearchResultsPage);
        BringgSearchResultsPageValidations.validateNextPageButton(bringgSearchResultsPage, webDriver);
        BringgSearchResultsPageValidations.validateWhitepapersResultSet(bringgSearchResultsPage);
    }
}
