package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

//    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa";

    @CacheLookup
    @FindBy(id = "header-details-user-fullname") private WebElement userMenu;
    @CacheLookup
    @FindBy(id = "log_out") private WebElement logoutButton;
    @FindBy(id = "create_link") private WebElement createIssueButton;
    @FindBy(id = "project-field") private WebElement projectNameInput;
    @FindBy(id = "summary") private WebElement summaryInput;
    @FindBy(xpath = "//input[@id='create-issue-submit']") private WebElement createIssueSubmit;
    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div/a") private WebElement confirmationLink;
    @FindBy(id = "summary-val") private WebElement summaryValue;

    public DashboardPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
//        driver.get(PAGE_URL);
    }

    public void logout(WebDriver driver) {

        Util.waitForWebElementToBeLocated(driver, userMenu);
        userMenu.click();
        Util.waitForWebElementToBeLocated(driver, logoutButton);
        logoutButton.click();
    }

    public void createIssue(WebDriver driver, String projectName, String summary) {
        Util.waitForWebElementToBeLocated(driver, createIssueButton);
        createIssueButton.click();
        Util.waitForWebElementToBeLocated(driver, projectNameInput);
        projectNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), projectName + Keys.RETURN);
        Util.waitForWebElementToBeLocated(driver, summaryInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(summaryInput);
        actions.click();
        actions.sendKeys(summary + Keys.RETURN);
        actions.build().perform();
        Util.waitForWebElementToBeLocated(driver, createIssueSubmit);
        createIssueSubmit.click();
        Util.waitForWebElementToBeLocated(driver, confirmationLink);
        confirmationLink.click();
    }

    public String getSummaryValue() {
        return summaryValue.getText();
    }
}
