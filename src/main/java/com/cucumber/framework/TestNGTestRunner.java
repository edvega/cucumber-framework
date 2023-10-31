package com.cucumber.framework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features",
        glue = "com/cucumber/framework/steps",
        dryRun = true
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
