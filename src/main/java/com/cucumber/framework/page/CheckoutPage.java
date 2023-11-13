package com.cucumber.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private By cartBag = By.cssSelector("[alt='Cart']");
    private By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoButton = By.cssSelector(".promoBtn");
    private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public Boolean verifyPromoButton() {
        return driver.findElement(promoButton).isDisplayed();
    }

    public Boolean verifyPlaceOrder() {
        return driver.findElement(placeOrder).isDisplayed();
    }
}
