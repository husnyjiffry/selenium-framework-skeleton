package com.gui.automation.utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FrameworkUtils {
    public static List<String> getTextAsAList(List<WebElement> listOfWebElement) {
        List<String> result = new ArrayList<String>();
        if (listOfWebElement != null) {
            for (WebElement element : listOfWebElement) {
                result.add(element.getText());
            }
        }
        return result;
    }

    /**
     * Use this method to compare two lists.
     * Returns true if list1 exactly same to list2
     *
     * @param list1 {@code ArrayList<String>}
     * @param list2 {@code ArrayList<String>}
     * @return {@code boolean}
     */
    public static boolean CompareTwoStringListsWithSameSize(List<String> list1, List<String> list2) {
        boolean result = true;
        if (list1 != null || list2 != null || !list1.isEmpty() || !list2.isEmpty()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    result = false;
                }
            }
        }
        return result;
    }
}
