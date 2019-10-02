import com.codecanvas.pomtestsTW3.LoginPage;
import com.codecanvas.pomtestsTW3.ProjectPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CreateVersionGlassTestCases {

    private LoginPage loginPage;
    private WebDriver driver;
    private String USERNAME = System.getenv("seleniumUsername");
    private String PASSWORD = System.getenv("seleniumPassword");
    private final String PROJECT = "PP1";
    private final String VERSION_NAME = "Lobab";

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
    public void createVersionsGlass () {

        loginPage.loginWithEnter(driver, USERNAME, PASSWORD);
        ProjectPage projectPage = new ProjectPage(driver, PROJECT);

        projectPage.createVersion(driver, VERSION_NAME);
        projectPage.deleteVersion(driver, VERSION_NAME);
        //assertTrue(projectPage.validateNewVersionCreation(driver, PROJECT));
    }

}
