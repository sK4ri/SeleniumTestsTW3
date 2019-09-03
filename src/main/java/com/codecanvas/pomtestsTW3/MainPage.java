package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class MainPage {

    private Waiter waiter = new Waiter();
    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa";

    @CacheLookup
    @FindBy (id = "find_link") private WebElement issuesDropdown;
    @FindBy (id = "issues_new_search_link_lnk") private WebElement searchForIssues;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(PAGE_URL);
    }

    public void clickIssues(WebDriver driver) {
        waiter.waitForElementToBeDisplayed(issuesDropdown, driver, 10);
        issuesDropdown.click();
    }

    public void getToIssuesPage(WebDriver driver) {
        clickIssues(driver);
        waiter.waitForElementToBeDisplayed(searchForIssues, driver, 10);
        searchForIssues.click();
    }
}
