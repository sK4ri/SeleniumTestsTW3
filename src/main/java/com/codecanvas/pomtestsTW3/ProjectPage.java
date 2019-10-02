package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class ProjectPage {

    private final String PROJECT;
    private final String PAGE_URL;
    private final String RELEASES_URL;
    private Waiter waiter = new Waiter();

    @FindBy(name = "name") private WebElement nameInputField;
    @FindBy(id = "version-filter-text") private WebElement searchVersionsInputField;
    @FindBy(xpath = "//div[.='Lobab']") private WebElement lobabVersionDiv;
    @FindBy(xpath = "//a[.='Delete']") private WebElement deleteVersion;
    @FindBy(id = "submit") private WebElement confirmDelete;
    @FindBy(xpath = "//a[.='Operations']") private WebElement operationsDropdown;

    public ProjectPage (WebDriver driver, String project) {

        PROJECT = project;
        PAGE_URL =  "https://jira.codecool.codecanvas.hu/projects/" + project;
        RELEASES_URL = PAGE_URL + "?selectedItem=com.atlassian.jira.jira-projects-plugin%3Arelease-page&status=no-filter";


        PageFactory.initElements(driver, this);
    }

    public void createVersion(WebDriver driver, String name) {

        driver.get(RELEASES_URL);
        waiter.waitForElementToBeDisplayed(nameInputField, driver);
        nameInputField.sendKeys(name + Keys.RETURN);
    }

    public void searchForVersion (WebDriver driver, String name) {

        waiter.waitForElementToBeDisplayed(searchVersionsInputField, driver);
        searchVersionsInputField.sendKeys(name + Keys.RETURN);
    }

    public boolean validateNewVersionCreation (WebDriver driver, String name) {

        searchForVersion(driver, name);
        return Util.waitForWebElementToBeLocated(driver, lobabVersionDiv);
    }

    public boolean deleteVersion (WebDriver driver, String name) {

        searchForVersion(driver, name);
        waiter.click(operationsDropdown, driver);
        waiter.click(deleteVersion, driver);
        waiter.click(confirmDelete, driver);
        return false;
    }
}
