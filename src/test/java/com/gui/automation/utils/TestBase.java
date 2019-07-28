package com.gui.automation.utils;

import com.gui.automation.common.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Level;

public class TestBase {

    @BeforeMethod
    public void startDriver() {
        SeleniumUtils.setDriver(DriverUtils.getChromeDriver(Constant.URL));

    }

    @AfterMethod
    public void closeDriver() {
        try {
            SeleniumUtils.getDriver().quit();
        } catch (Exception e) {
            LoggerUtil.logger.log(Level.WARNING, e.getMessage(), e);
        }
    }


}
