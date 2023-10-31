package com.cucumber.framework.steps;

import com.cucumber.framework.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

    private String offerPageProductName;
    TestContextSetup testContextSetup;
    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("user searched for {string} shortname in offers page")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = testContextSetup.driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        testContextSetup.driver.switchTo().window(childWindow);

        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
    }
}
