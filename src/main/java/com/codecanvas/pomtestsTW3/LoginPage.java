package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/login.jsp";

    @CacheLookup
    @FindBy(id = "login-form-username") private WebElement usernameInputField;
    @CacheLookup
    @FindBy(id = "login-form-password") private WebElement passwordInputField;
    @CacheLookup
    @FindBy(id = "login-form-submit") private WebElement loginButton;
    @FindBy(id = "header-details-user-fullname") private WebElement userLogo;
    @FindBy(xpath = "//p[contains(.,'Sorry')]") private WebElement loginErrorMessage;

    public LoginPage (WebDriver driver) {

        PageFactory.initElements(driver, this);
        driver.get(PAGE_URL);
    }

    private boolean loginSuccess (WebDriver driver, WebElement webElement) {

        return Util.waitForWebElementToBeLocated(driver, webElement);
    }

    public boolean login (WebDriver driver, String username, String password, String success) {

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();

        if ("true".equals(success)) {
            return loginSuccess(driver, userLogo);
        }
        else if ("false".equals(success)) {
            return loginSuccess(driver, loginErrorMessage);
        } else return false;
    }

    public boolean loginWithMissingCredentials (WebDriver driver) {

        loginButton.click();
        return loginSuccess(driver, loginErrorMessage);
    }

    public boolean loginWithEnter (WebDriver driver, String username, String password) {

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password + Keys.RETURN);
        return loginSuccess(driver, userLogo);
    }
}
