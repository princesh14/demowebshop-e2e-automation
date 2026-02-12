package com.demowebshop.pages;

import com.demowebshop.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    private final WaitUtil wait;

    // Locators


    private final By shoppingCart = By.xpath("//span[starts-with(text(),'Sh')]");
    private final By countryDropdown = By.xpath("//select[@id='CountryId']");
    private final By termsCheckbox = By.xpath("//input[@id='termsofservice']");
    private final By checkoutButton = By.xpath("//button[@id='checkout']");
    private final By productNameInCart = By.xpath("//a[@class='product-name']");

    public CartPage(WebDriver driver, int timeout) {
        this.wait = new WaitUtil(driver, timeout);
    }

    public void clickShoppingCart() {
        wait.waitForElementClickable(shoppingCart).click();
    }

    public void selectCountry(String india) {
        Select select = new Select(wait.waitForElementVisible(countryDropdown));
        select.selectByVisibleText("India");
    }

    public void acceptTerms() {
        wait.waitForElementClickable(termsCheckbox).click();
    }

    public String getProductNameInCart() {
        return wait.waitForElementVisible(productNameInCart).getText();
    }

    public void clickCheckout() {
        wait.waitForElementClickable(checkoutButton).click();
    }
}
