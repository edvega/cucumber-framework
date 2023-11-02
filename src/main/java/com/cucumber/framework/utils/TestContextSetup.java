package com.cucumber.framework.utils;

import com.cucumber.framework.page.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup(){
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
