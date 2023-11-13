package com.cucumber.framework.steps;

import com.cucumber.framework.page.CheckoutPage;
import com.cucumber.framework.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutPageStepDefinition {

    TestContextSetup testContextSetup;
    private CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout(String name) {
        checkoutPage.checkoutItems();
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verifyPromoButton());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }
}
