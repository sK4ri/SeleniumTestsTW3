package com.codecanvas.pomtestsTW3;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waiter.Waiter;

public class Util {

    private static Waiter waiter = new Waiter();

    public static boolean waitForWebElementToBeLocated(WebDriver driver, WebElement element) {
        try {
            waiter.waitForElementToBeDisplayed(element, driver, 10);
            return true;
        } catch (
                TimeoutException e) {
            return false;
        }
    }


    public static void waitUntilElementContainsString(WebDriver driver, WebElement element, String text) {
        waiter.waitForElementTextContainsString_IgnoreWhitespaces(element, text, driver);
    }


}
