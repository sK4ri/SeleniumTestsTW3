package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @CacheLookup
    @FindBy(linkText = "Issues")
    private WebElement issuesDropdown;
    @FindBy(id = "issues_new_search_link_lnk")
    private WebElement searchForIssues;
    @FindBy(linkText = "Projects")
    private WebElement projectsDropdown;
    @FindBy(linkText = "COALA Project (COALA)")
    private WebElement coalaProjectLink;
    @FindBy(linkText = "TOUCAN projekt (TOUCAN)")
    private WebElement toucanProjectLink;
    @FindBy(linkText = "JETI Project (JETI)")
    private WebElement jetiProjectLink;
    @FindBy(id = "header-details-user-fullname")
    private WebElement userMenu;
    @FindBy(id = "log_out")
    private WebElement logoutButton;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickIssues(WebDriver driver) {
        Util.waitForWebElementToBeLocated(driver, issuesDropdown);
        issuesDropdown.click();
    }

    public void getToIssuesPage(WebDriver driver) {
        clickIssues(driver);
        Util.waitForWebElementToBeLocated(driver, searchForIssues);
        searchForIssues.click();
    }

    public void clickProjects(WebDriver driver) {
        projectsDropdown.click();
    }

    public void getToCoalaIssues(WebDriver driver) {
        clickProjects(driver);
        Util.waitForWebElementToBeLocated(driver, coalaProjectLink);
        coalaProjectLink.click();
    }

    public void getToToucanIssues(WebDriver driver) {
        clickProjects(driver);
        Util.waitForWebElementToBeLocated(driver, toucanProjectLink);
        toucanProjectLink.click();
    }

    public void getToJetiIssues(WebDriver driver) {
        clickProjects(driver);
        Util.waitForWebElementToBeLocated(driver, jetiProjectLink);
        jetiProjectLink.click();
    }

    public void logout(WebDriver driver) {

        Util.waitForWebElementToBeLocated(driver, userMenu);
        userMenu.click();
        Util.waitForWebElementToBeLocated(driver, logoutButton);
        logoutButton.click();
    }
}