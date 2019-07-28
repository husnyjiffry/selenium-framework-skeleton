package com.gui.automation.functions;

import com.gui.automation.pages.GoogleSearchPage;

public class GoogleSearch {
    public static boolean isGoogleSearchPageLoaded(String title) {
        return GoogleSearchPage.getPageTitle().equals(title);
    }
}
