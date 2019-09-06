package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void createIssue(WebDriver driver, String projectName, String summary) {
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

    private void selectProjectAndFillSummary(WebDriver driver, String projectName, String summary) {
        Util.waitForWebElementToBeLocated(driver, createIssueButton);
        createIssueButton.click();
        Util.waitForWebElementToBeLocated(driver, projectNameInput);
        projectNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), projectName + Keys.RETURN);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until((ExpectedCondition<Boolean>) d -> !summaryInput.isEnabled());
            wait.until((ExpectedCondition<Boolean>) d -> summaryInput.isEnabled());
        } catch (Exception e) {
            // no problem
        }
        wait.until(ExpectedConditions.elementToBeClickable(summaryInput));
        summaryInput.sendKeys(summary);
    }

    private void deleteTestIssue(WebDriver driver) {
        Util.waitForWebElementToBeLocated(driver, moreOptions);
        moreOptions.click();
        Util.waitForWebElementToBeLocated(driver, deleteIssue);
        deleteIssue.click();
        Util.waitForWebElementToBeLocated(driver, deleteIssueSubmit);
        deleteIssueSubmit.click();
    }

    public void createChainIssue(WebDriver driver, String projectName, String summary) {
        selectProjectAndFillSummary(driver, projectName, summary);
        Util.waitForWebElementToBeLocated(driver, createAnotherCheckbox);
        createAnotherCheckbox.click();
        submitIssueCreation(driver);
    }

    public boolean validateChainIssueCreation(WebDriver driver) {
        return Util.waitForWebElementToBeLocated(driver, confirmationMessage);
    }

}
