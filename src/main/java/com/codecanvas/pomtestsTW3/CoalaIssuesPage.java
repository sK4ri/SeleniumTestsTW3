package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoalaIssuesPage {

    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/projects/COALA/issues/COALA-1?filter=allopenissues&orderby=key+ASC%2C+priority+DESC%2C+updated+DESC";

    @CacheLookup
    @FindBy(xpath = "//span[.='COALA-1']")
    private WebElement coala1;
    @FindBy(xpath = "//span[.='COALA-2']")
    private WebElement coala2;
    @FindBy(xpath = "//span[.='COALA-3']")
    private WebElement coala3;

    public CoalaIssuesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(PAGE_URL);
    }

    public void checkForCoalaIssues(WebDriver driver) {
        Util.waitForWebElementToBeLocated(driver, coala1);
        Util.waitForWebElementToBeLocated(driver, coala2);
        Util.waitForWebElementToBeLocated(driver, coala3);
    }
}
