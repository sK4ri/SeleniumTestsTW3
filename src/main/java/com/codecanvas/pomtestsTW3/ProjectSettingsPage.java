package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class ProjectSettingsPage {

    private final String PROJECT;
    private final String PAGE_URL;
    private final String PERMISSIONS_URL;

    private Waiter waiter;

    @FindBy(xpath = "//tr[contains(.,'Browse Projects')]") private WebElement browseProjectsTableRow;

    public ProjectSettingsPage (WebDriver driver, String project) {

        this.PROJECT = project;
        PAGE_URL = "https://jira.codecool.codecanvas.hu/plugins/servlet/project-config/" + project;
        PERMISSIONS_URL = PAGE_URL + "/permissions";
        PageFactory.initElements(driver, this);
        waiter = new Waiter();
    }

    public boolean permissionsForProject (WebDriver driver, String permissionType) {

        driver.get(PERMISSIONS_URL);
        return Util.doesContainString(driver, browseProjectsTableRow,permissionType);
        }
}
