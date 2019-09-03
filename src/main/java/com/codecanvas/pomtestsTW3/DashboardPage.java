package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class DashboardPage {

    private Waiter waiter = new Waiter();
    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa";

    @CacheLookup
    @FindBy(id = "header-details-user-fullname") private WebElement userMenu;
    @CacheLookup
    @FindBy(id = "log-out") private WebElement logoutButton;

    public DashboardPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        driver.get(PAGE_URL);
    }

    public void logout(WebDriver driver) {

        userMenu.click();
        waiter.waitForElementToBeDisplayed(logoutButton, driver, 10);
        logoutButton.click();
        waiter.waitForPageLoadComplete(driver, 10);
    }
}
