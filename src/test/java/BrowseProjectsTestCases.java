import com.codecanvas.pomtestsTW3.BrowseProjectsPage;
import com.codecanvas.pomtestsTW3.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseProjectsTestCases {

    private WebDriver driver;
    private BrowseProjectsPage browseProjectsPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithEnter(driver, System.getenv("seleniumUsername"), System.getenv("seleniumPassword"));
        browseProjectsPage = new BrowseProjectsPage(driver);
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @Test
    public void browseProjects() {
        assertTrue(browseProjectsPage.allProjectsPresent(driver));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/projectnames.csv")
    public void searchForAProject(String projectName) {
        browseProjectsPage.searchForProject(driver, projectName);
        assertTrue(browseProjectsPage.validateProjectFound(projectName));
    }
}
