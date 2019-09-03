package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowseProjectsPage {

    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/secure/BrowseProjects.jspa?selectedCategory=all&selectedProjectType=all";

    @FindBy(xpath = "//a[contains(@original-title, 'COALA')]")
    private WebElement coalaProject;

    @FindBy(xpath = "//a[contains(@original-title, 'JETI')]")
    private WebElement jetiProject;

    @FindBy(xpath = "//a[contains(@original-title, 'TOUCAN')]")
    private WebElement toucanProject;

    @FindBy(id = "project-filter-text")
    private WebElement searchInput;

    @FindBy(xpath = "//tbody[@class='projects-list']/tr[1]")
    private WebElement firstTableRow;

    public BrowseProjectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(PAGE_URL);
    }

    private boolean projectIsPresent(WebDriver driver, WebElement project) {
        return Util.waitForWebElementToBeLocated(driver, project);
    }

    public boolean allProjectsPresent(WebDriver driver) {
        return projectIsPresent(driver, coalaProject)
                && projectIsPresent(driver, jetiProject)
                && projectIsPresent(driver, toucanProject);
    }

    public void searchForProject(WebDriver driver, String projectName) {
        searchInput.sendKeys(projectName);
        Util.waitUntilElementContainsString(driver, firstTableRow, projectName);
    }

    public boolean validateProjectFound(String projectName) {
        return firstTableRow.getText().contains(projectName);
    }

}
