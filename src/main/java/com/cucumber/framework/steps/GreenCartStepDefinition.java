package com.cucumber.framework.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenCartStepDefinition {

    private WebDriver driver;
    private String landingPageProductName;
    private String offerPageProductName;
    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched for shortname {string} and extracted actual name  of product")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("\\s-\\s")[0];
        System.out.println(landingPageProductName + " is extracted from Home Page");
    }

    @Then("user searched for {string} shortname in offers page")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(landingPageProductName, offerPageProductName);
    }
}
