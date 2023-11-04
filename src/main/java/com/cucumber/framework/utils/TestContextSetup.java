package com.cucumber.framework.utils;

import com.cucumber.framework.page.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
