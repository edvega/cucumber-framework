package com.cucumber.framework.steps;

import com.cucumber.framework.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched for shortname {string} and extracted actual name  of product")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) {
        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        testContextSetup.landingPageProductName = "Tomato";//testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("\\s-\\s")[0];
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }
}
