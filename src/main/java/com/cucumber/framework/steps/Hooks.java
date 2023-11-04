package com.cucumber.framework.steps;

import com.cucumber.framework.utils.TestContextSetup;
import io.cucumber.java.After;

import java.io.IOException;

public class Hooks {

    private TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() throws IOException {
        testContextSetup.testBase.webDriverManager().quit();
    }
}
