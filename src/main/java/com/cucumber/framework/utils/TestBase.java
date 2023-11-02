package com.cucumber.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    private WebDriver driver;

    public WebDriver webDriverManager() {
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
        }
        return driver;
    }
}
