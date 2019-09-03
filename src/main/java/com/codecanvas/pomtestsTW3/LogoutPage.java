package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogoutPage {

    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/secure/Logout!default.jspa";

    @FindBy(id = "user-options") private WebElement loginButton;

    public LogoutPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        driver.get(PAGE_URL);
    }

    public boolean logoutSuccessful() {

        return "Log In".equals(loginButton.getText());
    }
}
