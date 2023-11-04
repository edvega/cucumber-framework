package com.cucumber.framework.steps;

import com.cucumber.framework.page.LandingPage;
import com.cucumber.framework.page.OffersPage;
import com.cucumber.framework.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class OfferPageStepDefinition {

    private String offerPageProductName;
    TestContextSetup testContextSetup;
    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
    }

    public void switchToOffersPage(){
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDeals();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
    }
}
