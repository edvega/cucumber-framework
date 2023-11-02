package com.cucumber.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("tr td:nth-child(1)");
    private WebDriver driver;

    public OffersPage(WebDriver driver) {
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
}
