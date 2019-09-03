import com.codecanvas.pomtestsTW3.LoginPage;
import com.codecanvas.pomtestsTW3.DashboardPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowseIssueTestCases {

    private WebDriver driver = new ChromeDriver();
    private DashboardPage mainPage = new DashboardPage(driver);

    @BeforeEach
    void setup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver, System.getenv("USER_NAME"), System.getenv("PASSWORD"), "true");
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @Test
    void getSearchIssuesPage() {
        mainPage.getToIssuesPage(driver);
        assertEquals(true, driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/browse/"));
    }

    @Test
    void searchForCoalaIssues() {
        mainPage.getToCoalaIssues(driver);
        assertEquals(true, driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/projects/COALA/issues"));
    }

    @Test
    void searchForToucanIssues() {
        mainPage.getToToucanIssues(driver);
        assertEquals(true, driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/projects/TOUCAN/issues"));
    }

    @Test
    void searchForJetiIssues() {
        mainPage.getToJetiIssues(driver);
        assertEquals(true, driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/projects/JETI/issues"));
    }
}
