package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @CacheLookup
    @FindBy(id = "header-details-user-fullname") private WebElement userMenu;
    @CacheLookup
    @FindBy(id = "log_out") private WebElement logoutButton;
    @FindBy(id = "create_link") private WebElement createIssueButton;
    @FindBy(id = "project-field") private WebElement projectNameInput;
    @FindBy(id = "summary") private WebElement summaryInput;
    @FindBy(xpath = "//input[@id='create-issue-submit']") private WebElement createIssueSubmit;
    @FindBy(xpath = "//*[@id='aui-flag-container']/div/div/a") private WebElement confirmationLink;
    @FindBy(id = "summary-val") private WebElement summaryValue;
    @FindBy(id = "opsbar-operations_more") private WebElement moreOptions;
    @FindBy(xpath = "//*[@id='delete-issue']/a/span") private WebElement deleteIssue;
    @FindBy(id = "delete-issue-submit") private WebElement deleteIssueSubmit;
    @FindBy(xpath = "//input[@id='qf-create-another']") private WebElement createAnotherCheckbox;
    @FindBy(xpath = "//div[@class='aui-message aui-message-success closeable']") private WebElement confirmationMessage;

    public DashboardPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void logout(WebDriver driver) {

        Util.waitForWebElementToBeLocated(driver, userMenu);
        userMenu.click();
        Util.waitForWebElementToBeLocated(driver, logoutButton);
        logoutButton.click();
    }

    public void createIssue(WebDriver driver, String projectName, String summary) throws InterruptedException {
        selectProjectAndFillSummary(driver, projectName, summary);
        submitIssueCreation(driver);
        Util.waitForWebElementToBeLocated(driver, confirmationLink);
        confirmationLink.click();
        deleteTestIssue(driver);
    }

    public String getSummaryValue() {
        return summaryValue.getText();
    }

    private void submitIssueCreation(WebDriver driver) {
        Util.waitForWebElementToBeLocated(driver, createIssueSubmit);
        createIssueSubmit.click();
    }

    private void selectProjectAndFillSummary(WebDriver driver, String projectName, String summary) throws InterruptedException {
        Util.waitForWebElementToBeLocated(driver, createIssueButton);
        createIssueButton.click();
        Util.waitForWebElementToBeLocated(driver, projectNameInput);
        projectNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), projectName + Keys.RETURN);
        Thread.sleep(10000);
        summaryInput.sendKeys(summary);

//        Actions actions = new Actions(driver);
//        actions.moveToElement(summaryInput);
//        actions.click();
//        actions.sendKeys(summary);
//        actions.build().perform();

        // TODO: only works with Thread. sleep (JETI should fail, because of user permission! everything else passes)
        //  exception: InvalidElementStateException OR StaleElementReferenceException OR assert error (not the entire summary is entered)
        //  tried: wait for input element to be visible/located/clickable, waiting for "Create" button, try-catch, for loop, refresh, click before sendkeys, Actions class

    }

    private void deleteTestIssue(WebDriver driver) {
        Util.waitForWebElementToBeLocated(driver, moreOptions);
        moreOptions.click();
        Util.waitForWebElementToBeLocated(driver, deleteIssue);
        deleteIssue.click();
        Util.waitForWebElementToBeLocated(driver, deleteIssueSubmit);
        deleteIssueSubmit.click();
    }

    public void createChainIssue(WebDriver driver, String projectName, String summary) throws InterruptedException {
        selectProjectAndFillSummary(driver, projectName, summary);
        Util.waitForWebElementToBeLocated(driver, createAnotherCheckbox);
        createAnotherCheckbox.click();
        submitIssueCreation(driver);
    }

    public boolean validateChainIssueCreation(WebDriver driver) {
        return Util.waitForWebElementToBeLocated(driver, confirmationMessage);
    }

}
