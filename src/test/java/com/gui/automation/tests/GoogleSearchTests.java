package com.gui.automation.tests;

import com.gui.automation.functions.GoogleSearch;
import com.gui.automation.utils.TestBase;
import com.gui.automation.utils.TestListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(TestListeners.class)
public class GoogleSearchTests extends TestBase {
    @Test(description = "Verify Title")
    public void testGoogleSearchPageTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(GoogleSearch.isGoogleSearchPageLoaded("Google"),
                "Google Search Page Not Loaded");
        softAssert.assertAll();
    }
}
