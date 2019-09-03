import com.codecanvas.pomtestsTW3.LoginPage;
import com.codecanvas.pomtestsTW3.ProjectGlassDocumentationPage;
import com.codecanvas.pomtestsTW3.ProjectSettingsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionsWithGlassTestCases {

    private LoginPage loginPage;
    private WebDriver driver;
    private String USERNAME = System.getenv("seleniumUsername");
    private String PASSWORD = System.getenv("seleniumPassword");

    @BeforeEach
    public void setup () {

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void browseProjectsPermission() {

        loginPage.loginWithEnter(driver, USERNAME, PASSWORD);

        ProjectSettingsPage projectSettingsPage = new ProjectSettingsPage(driver, "PP1");
        ProjectGlassDocumentationPage projectGlassDocumentationPage = new ProjectGlassDocumentationPage(driver, "PP1");
        projectGlassDocumentationPage.permissionForProjectFromGlass(driver);
        assertTrue(projectSettingsPage.permissionsForProject(driver,"Any logged in user") && projectGlassDocumentationPage.permissionForProjectFromGlass(driver));

    }
}
