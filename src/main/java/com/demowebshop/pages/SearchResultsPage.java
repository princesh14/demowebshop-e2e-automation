package com.demowebshop.pages;

import com.demowebshop.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private final WaitUtil wait;

    // Locators
    private final By thirdProductAddToCartButton = By.xpath("(//input[@value='Add to cart'])[3]");

    public SearchResultsPage(WebDriver driver, int timeout) {
        this.wait = new WaitUtil(driver, timeout);
    }


    public void addThirdProductToCart() {
        wait.waitForElementClickable(thirdProductAddToCartButton).click();
    }


}
