package com.cucumber.framework.utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    private WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindowToChild() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
    }
}
