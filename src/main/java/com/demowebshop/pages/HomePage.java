package com.demowebshop.pages;

import com.demowebshop.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WaitUtil wait;

    //Locators
    private final By searchBox = By.xpath("//input[@id='small-searchterms']");
    private final By searchButton = By.xpath("//input[@value='Search']");

    public HomePage(WebDriver driver, int timeout) {
        this.wait = new WaitUtil(driver, timeout);
    }

    public void searchProduct(String productName) {
        wait.waitForElementVisible(searchBox).clear();
        wait.waitForElementVisible(searchBox).sendKeys(productName);
        wait.waitForElementClickable(searchButton).click();
    }
}
