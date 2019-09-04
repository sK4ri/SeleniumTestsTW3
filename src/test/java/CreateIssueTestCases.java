import com.codecanvas.pomtestsTW3.BrowseProjectsPage;
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
        loginPage.loginWithEnter(driver, System.getenv("USER_NAME"), System.getenv("PASSWORD"));
        dashboardPage = new DashboardPage(driver);
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @Test
    public void createIssue() {
        String summary ="123";
        dashboardPage.createIssue(driver, "Main Testing Project (MTP)", summary);
        assertEquals(summary, dashboardPage.getSummaryValue());
    }



//        // Delete test issue
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"opsbar-operations_more\"]")));
//        driver.findElement(By.xpath("//*[@id=\"opsbar-operations_more\"]")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"delete-issue\"]/a/span")));
//        driver.findElement(By.xpath("//*[@id=\"delete-issue\"]/a/span")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("delete-issue-submit")));
//        driver.findElement(By.id("delete-issue-submit")).click();
}
