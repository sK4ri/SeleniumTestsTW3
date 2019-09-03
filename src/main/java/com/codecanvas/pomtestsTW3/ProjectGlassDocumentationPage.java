package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiter.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProjectGlassDocumentationPage {

    private final String PROJECT;
    private final String PAGE_URL;

    private Waiter waiter;

    @FindBy(xpath = "//tr[contains(.,'Browse Projects')]") private WebElement browseProjectsTableRow;
    @FindBy(xpath = "//th[contains(.,'Any logged in user')]") private WebElement applicationAccessTableHeader;
    @FindBy(xpath = "//tr[contains(.,'Any logged in user')]") private WebElement permissionMatrixTableHeader;
    @FindBy(xpath = "//tr[contains(.,'Any logged in user')]/th[@class='rotate']//span") private List<WebElement> permissionMatrixHeaderTitles;
    @FindBy(xpath = "//span[contains(.,'Any logged in user')]") private WebElement anyLoggedInUserSpan;

    public ProjectGlassDocumentationPage (WebDriver driver, String project) {

        this.PROJECT = project;
        PAGE_URL = "https://jira.codecool.codecanvas.hu/projects/" + project + "?selectedItem=com.codecanvas.glass:glass";
        PageFactory.initElements(driver, this);
    }

    public boolean permissionForProjectFromGlass (WebDriver driver) {

        driver.get(PAGE_URL);
        int tableColumn = 0;
        ListIterator<WebElement> lIterator;
        waiter = new Waiter();

        try {
            lIterator = permissionMatrixHeaderTitles.listIterator();
            int counter = 2;
            while (lIterator.hasNext()){
                if (anyLoggedInUserSpan.equals(lIterator.next())) {
                    tableColumn = counter;
                    break;
                } else counter ++;
            }

            if (tableColumn != 0) {
                WebElement poi = driver.findElement(By.xpath("//tr[contains(.,'Browse Projects')]/td[" + tableColumn + "]"));
                return poi.findElement(By.className("glass-true-icon")).isEnabled();
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false; }

    }
}
