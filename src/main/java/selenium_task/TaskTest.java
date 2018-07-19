package selenium_task;

import org.junit.Test;

/**
 * Created by sarahd on 16/07/2018.
 */
public class TaskTest extends AbstractTest {

    @Test
    public void navigateAndSearchBringgHomePage() throws Exception {

        this
                .navigateToGoogleHomePage()
                .searchInGoogleHomePage("bringg")
                .navigateToBringgHomePageFromSearchResults()
                .searchInBringgHomePage("sarah")
                .validateBringgSearchResultsPage();
    }
}
