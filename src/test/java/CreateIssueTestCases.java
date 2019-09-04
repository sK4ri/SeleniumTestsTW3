import com.codecanvas.pomtestsTW3.DashboardPage;
import com.codecanvas.pomtestsTW3.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateIssueTestCases {

    private WebDriver driver;
    private DashboardPage dashboardPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithEnter(driver, System.getenv("seleniumUsername"), System.getenv("seleniumPassword"));
        dashboardPage = new DashboardPage(driver);
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/namesofallfourprojects.csv")
    public void createIssue(String projectName) throws InterruptedException {
        String summary = "This is a test issue";
        dashboardPage.createIssue(driver, projectName, summary);
        assertEquals(summary, dashboardPage.getSummaryValue());
    }

    @Test
    public void createIssueChain() throws InterruptedException {
        String projectName = "Main Testing Project (MTP)";
        String summary = "Test issue chain";
        dashboardPage.createChainIssue(driver, projectName, summary);
        assertTrue(dashboardPage.validateChainIssueCreation(driver));
    }

}
