import com.codecanvas.pomtestsTW3.BrowseProjectsPage;
import com.codecanvas.pomtestsTW3.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseProjectsTestCases {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver, "user13", "CoolCanvas19.", "true");
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @Test
    public void browseProjects() {
        BrowseProjectsPage browseProjectsPage = new BrowseProjectsPage(driver);
        assertTrue(browseProjectsPage.allProjectsPresent(driver));
    }
}
