package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectGlassDocumentationPage {

    private final String PROJECT;
    private final String PAGE_URL;

    @FindBy(xpath = "//tr[contains(.,'Browse Projects') ]/td[3]/div") private WebElement thirdBrowseProjectsColumn;
    @FindBy(xpath = "//tr[contains(.,'Create Issues') ]/td[3]/div") private WebElement thirdCreateIssuesColumn;
    @FindBy(xpath = "//tr[contains(.,'Edit Issues') ]/td[3]/div") private WebElement thirdEditIssuesColumn;

    private String checkIconClassName = "glass-true-icon";

    public ProjectGlassDocumentationPage (WebDriver driver, String project) {

        this.PROJECT = project;
        PAGE_URL = "https://jira.codecool.codecanvas.hu/projects/" + project + "?selectedItem=com.codecanvas.glass:glass";
        PageFactory.initElements(driver, this);
    }

    public boolean glassPermissionForBrowseProjects (WebDriver driver) {

        driver.get(PAGE_URL);
        return Util.doesAttributeContainString(driver, thirdBrowseProjectsColumn, "class", checkIconClassName);
    }

    public boolean glassPermissionForCreateIssues (WebDriver driver) {

        driver.get(PAGE_URL);
        return Util.doesAttributeContainString(driver, thirdCreateIssuesColumn, "class", checkIconClassName);
    }

    public boolean glassPermissionForEditIssues (WebDriver driver) {

        driver.get(PAGE_URL);
        return Util.doesAttributeContainString(driver, thirdEditIssuesColumn, "class", checkIconClassName);
    }
}
