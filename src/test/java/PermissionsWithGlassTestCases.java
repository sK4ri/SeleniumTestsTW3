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
    private final String PROJECT = "PP1";
    private final String ALL_USERS  = "Any logged in user";

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

        ProjectSettingsPage projectSettingsPage = new ProjectSettingsPage(driver, PROJECT);
        ProjectGlassDocumentationPage projectGlassDocumentationPage = new ProjectGlassDocumentationPage(driver, PROJECT);
        assertTrue(projectSettingsPage.permissionsForBrowseProjects(driver, ALL_USERS) && projectGlassDocumentationPage.glassPermissionForBrowseProjects(driver));
    }

    @Test
    public void createIssuePermission() {

        loginPage.loginWithEnter(driver, USERNAME, PASSWORD);

        ProjectSettingsPage projectSettingsPage = new ProjectSettingsPage(driver, PROJECT);
        ProjectGlassDocumentationPage projectGlassDocumentationPage = new ProjectGlassDocumentationPage(driver, PROJECT);
        assertTrue(projectSettingsPage.permissionsForCreateIssues(driver, ALL_USERS) && projectGlassDocumentationPage.glassPermissionForCreateIssues(driver));
    }

    @Test
    public void editIssuesPermissions() {

        loginPage.loginWithEnter(driver, USERNAME, PASSWORD);

        ProjectSettingsPage projectSettingsPage = new ProjectSettingsPage(driver, PROJECT);
        ProjectGlassDocumentationPage projectGlassDocumentationPage = new ProjectGlassDocumentationPage(driver, PROJECT);
        assertTrue(projectSettingsPage.permissionsForEditIssues(driver, ALL_USERS) && projectGlassDocumentationPage.glassPermissionForEditIssues(driver));
    }
}
