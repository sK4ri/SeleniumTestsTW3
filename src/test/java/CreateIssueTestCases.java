import com.codecanvas.pomtestsTW3.DashboardPage;
import com.codecanvas.pomtestsTW3.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void createIssue() {
        String summary = "This is a test issue";
        dashboardPage.createIssue(driver, "Main Testing Project (MTP)", summary);
        assertEquals(summary, dashboardPage.getSummaryValue());
    }

}
