package com.cucumber.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    private WebDriver driver;

    public WebDriver webDriverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String qaUrl = properties.getProperty("qaurl");

        if (driver == null){
            if (properties.getProperty("browser").equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(qaUrl);
        }
        return driver;
    }
}
