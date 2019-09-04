package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JetiIssuesPage {

    private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/projects/JETI/issues/JETI-1?filter=allopenissues&orderby=key+ASC%2C+priority+DESC%2C+updated+DESC";

    @CacheLookup
    @FindBy(xpath = "//span[.='JETI-1']")
    private WebElement jeti1;
    @FindBy(xpath = "//span[.='JETI-2']")
    private WebElement jeti2;
    @FindBy(xpath = "//span[.='JETI-3']")
    private WebElement jeti3;

    public JetiIssuesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(PAGE_URL);
    }

    public boolean checkForJetiIssues(WebDriver driver) {
        try {
            Util.waitForWebElementToBeLocated(driver, jeti1);
            Util.waitForWebElementToBeLocated(driver, jeti2);
            Util.waitForWebElementToBeLocated(driver, jeti3);
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

}
