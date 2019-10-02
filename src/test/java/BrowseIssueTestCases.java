import com.codecanvas.pomtestsTW3.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseIssueTestCases {

    private WebDriver driver = new ChromeDriver();
    private String nodeURL;

    private DashboardPage mainPage = new DashboardPage(driver);
    private CoalaIssuesPage coalaIssuesPage = new CoalaIssuesPage(driver);
    private ToucanIssuesPage toucanIssuesPage = new ToucanIssuesPage(driver);
    private JetiIssuesPage jetiIssuesPage = new JetiIssuesPage(driver);


    @BeforeEach
    void setup() throws MalformedURLException {
        nodeURL = "http://10.44.2.0:4444/wd/hub/";
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
        LoginPage loginPage = new LoginPage(driver);
        // loginPage.loginWithEnter(driver, System.getenv("user"), System.getenv("password"));
        loginPage.loginWithEnter(driver,"user12", "CoolCanvas19.");

    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @Test
    void getSearchIssuesPage() {
        mainPage.getToIssuesPage(driver);
        assertTrue(driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/browse/"));
    }

    @Test
    void searchForCoalaIssues() {
        mainPage.getToCoalaIssues(driver);
        assertTrue(driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/projects/COALA/issues"));
    }

    @Test
    void searchForToucanIssues() {
        mainPage.getToToucanIssues(driver);
        assertTrue(driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/projects/TOUCAN/issues"));
    }

    @Test
    void searchForJetiIssues() {
        mainPage.getToJetiIssues(driver);
        assertTrue(driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/projects/JETI/issues"));
    }

    @Test
    void locateCoalaIssues() {
        assertTrue(coalaIssuesPage.checkForCoalaIssues(driver));
    }

    @Test
    void locateToucanIssues() {
        assertTrue(toucanIssuesPage.checkForToucanIssues(driver));
    }

    @Test
    void locateJetiIssues() {
        assertTrue(jetiIssuesPage.checkForJetiIssues(driver));
    }
}
