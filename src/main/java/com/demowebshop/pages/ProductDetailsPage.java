package com.demowebshop.pages;

import com.demowebshop.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    private final WaitUtil wait;

    // Locators

    private final By thirdProductName = By.xpath("//h1[@itemprop='name']");
    private final By addToCart = By.xpath("//input[@id ='add-to-cart-button-74']");
    private final By successNotification = By.xpath("//p[@class='content']");
    private final By closeNotification = By.xpath("//span[@title='Close']");

    public ProductDetailsPage(WebDriver driver, int timeout) {
        this.wait = new WaitUtil(driver, timeout);
    }

    public String getThirdProductName() {
        return wait.waitForElementVisible(thirdProductName).getText();
    }

    public void addToCartProduct() {
        wait.waitForElementClickable(addToCart).click();
    }

    public boolean isProductAddedSuccessfully() {
        return wait.waitForElementVisible(successNotification).isDisplayed();
    }

    public void closeNotification() {
        wait.waitForElementVisible(closeNotification).click();
    }

}
