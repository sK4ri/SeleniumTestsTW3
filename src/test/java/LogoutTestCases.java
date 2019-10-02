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
    private String username = System.getenv("SEL_USERNAME");
    private String password = System.getenv("SEL_PASSWORD");

    @BeforeEach
    public void setup() {

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.loginWithEnter(driver, username, password);
        dashboardPage = new DashboardPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @AfterEach
    void quit() {

        driver.quit();
    }

    @Test
    public void logout() {

        dashboardPage.logout(driver);
        assertTrue(logoutPage.logoutSuccessful(driver));
    }
}
