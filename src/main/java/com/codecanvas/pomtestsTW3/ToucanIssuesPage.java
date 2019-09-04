package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToucanIssuesPage {

        private final String PAGE_URL = "https://jira.codecool.codecanvas.hu/projects/TOUCAN/issues/TOUCAN-1?filter=allopenissues&orderby=key+ASC%2C+priority+DESC%2C+updated+DESC";

        @CacheLookup
        @FindBy(xpath = "//span[.='TOUCAN-1']")
        private WebElement toucan1;
        @FindBy(xpath = "//span[.='TOUCAN-2']")
        private WebElement toucan2;
        @FindBy(xpath = "//span[.='TOUCAN-3']")
        private WebElement toucan3;

        public ToucanIssuesPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            driver.get(PAGE_URL);
        }

        public boolean checkForToucanIssues(WebDriver driver) {
            try {
                Util.waitForWebElementToBeLocated(driver, toucan1);
                Util.waitForWebElementToBeLocated(driver, toucan2);
                Util.waitForWebElementToBeLocated(driver, toucan3);
                return true;
            }
            catch (TimeoutException e) {
                return false;
            }
        }

    }

