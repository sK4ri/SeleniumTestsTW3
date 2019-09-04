package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class ProjectGlassDocumentationPage {

    private final String PROJECT;
    private final String PAGE_URL;

    private Waiter waiter;

    @FindBy(xpath = "//tr[contains(.,'Browse Projects') ]/td[3]/div") private WebElement thirdBrowseProjectsColumn;

    private String checkIconClassName = "glass-true-icon";

    public ProjectGlassDocumentationPage (WebDriver driver, String project) {

        this.PROJECT = project;
        PAGE_URL = "https://jira.codecool.codecanvas.hu/projects/" + project + "?selectedItem=com.codecanvas.glass:glass";
        PageFactory.initElements(driver, this);
    }

    public boolean permissionForProjectFromGlass (WebDriver driver) {

        driver.get(PAGE_URL);
        waiter = new Waiter();
        return Util.doesAttributeContainString(driver, thirdBrowseProjectsColumn, "class", checkIconClassName);
    }
}
