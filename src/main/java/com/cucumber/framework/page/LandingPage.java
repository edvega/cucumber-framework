package com.cucumber.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public void getSearchText(){
        driver.findElement(search).getText();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void selectTopDeals(){
        driver.findElement(topDeals).click();
    }
}
