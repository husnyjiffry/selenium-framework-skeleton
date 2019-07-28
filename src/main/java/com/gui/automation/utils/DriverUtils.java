package com.gui.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    public static WebDriver getChromeDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5l, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        return driver;

    }
}
