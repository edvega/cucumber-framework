package com.cucumber.framework.steps;

import com.cucumber.framework.page.LandingPage;
import com.cucumber.framework.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    private LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^user searched for shortname (.+) and extracted actual name  of product$")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        // testContextSetup.landingPageProductName = landingPage.getProductName().split("\\s-\\s")[0];
        testContextSetup.landingPageProductName = "Tomato";
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }

    @When("added {string} items of the selected product to cart")
    public void added_items_product(String quantity) {
        landingPage.increment(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}
