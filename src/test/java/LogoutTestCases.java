import com.codecanvas.pomtestsTW3.DashboardPage;
import com.codecanvas.pomtestsTW3.LoginPage;
import com.codecanvas.pomtestsTW3.LogoutPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTestCases {

    private WebDriver driver;
    private String nodeURL;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LogoutPage logoutPage;

    @BeforeEach
    public void setup() throws MalformedURLException {
        nodeURL = "https://selenium:CoolCanvas19.@seleniumhub.codecool.codecanvas.hu/wd/hub";
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
        loginPage = new LoginPage(driver);
//        loginPage.loginWithEnter(driver, System.getenv("seleniumUsername"), System.getenv("seleniumPassword"));
        loginPage.loginWithEnter(driver,"user12", "CoolCanvas19.");
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
