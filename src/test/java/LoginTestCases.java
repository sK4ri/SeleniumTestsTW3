import com.codecanvas.pomtestsTW3.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.*;

public class LoginTestCases {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void quit() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sensitive_data/logindata.csv")
    public void login(String username, String password, String success) throws InterruptedException {

        assertTrue(loginPage.login(driver, username, password, success));
    }

    @Test
    public void loginWithMissingCredentials () {

        assertTrue(loginPage.loginWithMissingCredentials(driver));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sensitive_data/correctlogindata.csv")
    public void loginWithEnter (String username, String password) {

        assertTrue(loginPage.loginWithEnter(driver, username, password));
    }
}
