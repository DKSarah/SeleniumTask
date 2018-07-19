package bringgWebTests.tests;

import bringgWebTests.AbstractTest;
import org.junit.Test;

/**
 * Created by sarahd on 16/07/2018.
 */
public class TaskTest extends AbstractTest {

    @Test
    public void navigateAndSearchBringgHomePage() throws Exception {

        navigateToGoogleHomePage()
        .searchInGoogleHomePage("bringg")
        .navigateToBringgHomePageFromGoogleSearchResults()
        .searchInBringgHomePage("sarah")
        .validateBringgSearchResultsPage();
    }
}
