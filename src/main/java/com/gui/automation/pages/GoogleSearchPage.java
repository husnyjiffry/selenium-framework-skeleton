package com.gui.automation.pages;

import com.gui.automation.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class GoogleSearchPage {
    private static By googleSearchTextBox = By.xpath("");

    public static String getPageTitle() {
        return SeleniumUtils.getTitle();
    }
}