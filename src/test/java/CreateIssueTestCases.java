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



//    public void checkCreateIssuePossible() {
//        Wait wait = new FluentWait(driver).ignoring(NoSuchElementException.class).withTimeout(20, TimeUnit.SECONDS);
//        driver.findElement(By.id("create_link")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("project-field")));
//        driver.findElement(By.id("project-field")).sendKeys("Main Testing Project (MTP)" + Keys.RETURN);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
//        driver.findElement(By.id("summary")).sendKeys("Create Issue Test");
//        driver.findElement(By.id("create-issue-submit")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"aui-flag-container\"]/div/div/a")));
//        driver.findElement(By.xpath("//*[@id=\"aui-flag-container\"]/div/div/a")).click();
//        WebElement issueSummary = driver.findElement(By.id("summary-val"));
//        assertEquals("Create Issue Test", issueSummary.getText());
//
//        // Delete test issue
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"opsbar-operations_more\"]")));
//        driver.findElement(By.xpath("//*[@id=\"opsbar-operations_more\"]")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"delete-issue\"]/a/span")));
//        driver.findElement(By.xpath("//*[@id=\"delete-issue\"]/a/span")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("delete-issue-submit")));
//        driver.findElement(By.id("delete-issue-submit")).click();
}
