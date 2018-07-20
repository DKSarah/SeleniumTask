package seleniumTask.bringgWebTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by sarahd on 16/07/2018.
 */
public class FunctionalBringgWebTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        webDriver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        webDriver.close();
    }

}
