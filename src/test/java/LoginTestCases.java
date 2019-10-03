import com.codecanvas.pomtestsTW3.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTestCases {

    private String nodeURL;
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setup() throws MalformedURLException {
        nodeURL = "http://10.44.2.0:4444/wd/hub/";
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(nodeURL), chromeOptions);
        loginPage = new LoginPage(driver);
    }


    @AfterEach
    void quit() {
        driver.quit();
    }

    @ParameterizedTest
    //@CsvFileSource(resources = "/sensitive_data/logindata.csv")
    //user19,CoolCanvas19.,true
    // lobab,CoolCanvas19.,false
    // user19,sanyi,false
    // admin,admin,false
    @CsvSource({"user19,CoolCanvas19.,true", "lobab,CoolCanvas19.,false"})
    public void login(String username, String password, String success) throws InterruptedException {

        assertTrue(loginPage.login(driver, username, password, success));
    }

    @Test
    public void loginWithMissingCredentials () {

        assertTrue(loginPage.loginWithMissingCredentials(driver));
    }

    @ParameterizedTest
    // @CsvFileSource(resources = "/sensitive_data/correctlogindata.csv")
    @CsvSource({"user19,CoolCanvas19."})
    public void loginWithEnter (String username, String password) {

        assertTrue(loginPage.loginWithEnter(driver, username, password));
    }
}
