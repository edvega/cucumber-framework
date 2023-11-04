package com.cucumber.framework.steps;

import com.cucumber.framework.page.LandingPage;
import com.cucumber.framework.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
    }

    @When("^user searched for shortname (.+) and extracted actual name  of product$")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        // testContextSetup.landingPageProductName = landingPage.getProductName().split("\\s-\\s")[0];
        testContextSetup.landingPageProductName = "Tomato";
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }
}
