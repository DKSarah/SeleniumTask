package seleniumTask.bringgWebTests.tests;

import seleniumTask.bringgWebTests.AbstractBringgWebTest;
import org.junit.Test;

/**
 * Created by sarahd on 16/07/2018.
 */
public class SearchInBringgTest extends AbstractBringgWebTest {

    @Test
    public void navigateAndSearchBringgHomePage() throws Exception {

        navigateToGoogleHomePage()
        .searchInGoogleHomePage("bringg")
        .navigateToBringgHomePageFromGoogleSearchResults()
        .searchInBringgHomePage("delivery")
        .validateBringgSearchResultsPage();
    }
}
