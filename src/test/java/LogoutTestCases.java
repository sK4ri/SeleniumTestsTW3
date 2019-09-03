import com.codecanvas.pomtestsTW3.DashboardPage;
import com.codecanvas.pomtestsTW3.LoginPage;
import com.codecanvas.pomtestsTW3.LogoutPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTestCases {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LogoutPage logoutPage;

    @BeforeEach
    public void setup() {

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.login(driver, System.getenv("USER_NAME"), System.getenv("PASSWORD"), "true");
    }

    @AfterEach
    void quit() {

        driver.quit();
    }

    @Test
    public void logout() {

        dashboardPage.logout(driver);
        assertTrue(logoutPage.logoutSuccessful());
    }
}
