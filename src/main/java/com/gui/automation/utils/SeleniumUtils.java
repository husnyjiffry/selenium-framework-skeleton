package com.gui.automation.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class SeleniumUtils {
    private static final long TIMEOUT = 10;
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        SeleniumUtils.driver = driver;
    }

    public static WebElement findElement(By by) {
        try {
            WebElement element = getDriver().findElement(by);
            return element;
        } catch (NoSuchElementException e) {
            LoggerUtil.logger.log(Level.WARNING, e.getMessage(), e);
            return null;
        }
    }

    public static WebElement findElement(By by, int timeout) {
        try {
            setTimeout(timeout);
            WebElement element = getDriver().findElement(by);
            setTimeout(TIMEOUT);
            return element;
        } catch (NoSuchElementException e) {
            LoggerUtil.logger.log(Level.WARNING, e.getMessage(), e);
            return null;
        }
    }

    public static void setTimeout(long timeInSeconds) {
        getDriver().manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }

    public static List<WebElement> findElements(By by) {
        try {
            List<WebElement> elements = getDriver().findElements(by);
            return elements;
        } catch (NoSuchElementException e) {
            LoggerUtil.logger.log(Level.WARNING, e.getMessage(), e);
            return null;
        }
    }

    public static void sendKeys(By txtField, String text) {
        findElement(txtField).sendKeys(text);
    }

    public static void click(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    private static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean isDisplayed(By by) {
        WebElement element = findElement(by);
        if (element == null)
            return false;
        return isDisplayed(element);
    }

    public static String getTitle() {
        return getDriver().getTitle();
    }


    public static void captureScreenShot(String pathToStore) {
        TakesScreenshot screenShot = (TakesScreenshot) getDriver();
        File source = screenShot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(source, new File(pathToStore));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomNameWithTimestamp() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        return "screenshot_" + timeStamp;
    }

    private static WebElement getSelectedValue(WebElement element) {
        Select dropdown = new Select(element);
        return dropdown.getFirstSelectedOption();
    }

    public static String getSelectedValue(By by) {
        WebElement element = findElement(by);
        return getSelectedValue(element).getText();
    }

    public static void selectValueByVisibleTextFromDropDown(By by, String text) {
        WebElement element = findElement(by);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public static String getText(By by) {
        return findElement(by).getText();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }


}
