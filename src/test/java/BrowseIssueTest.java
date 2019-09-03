import com.codecanvas.pomtestsTW3.LoginPage;
import com.codecanvas.pomtestsTW3.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowseIssueTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver, "user16", "CoolCanvas19.", "true");
    }

    @Test
    void getSearchIssuesPage() {
        mainPage.getToIssuesPage(driver);
        assertEquals(true, driver.getCurrentUrl().contains("https://jira.codecool.codecanvas.hu/browse/"));
    }
}
