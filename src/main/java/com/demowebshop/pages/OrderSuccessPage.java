package com.demowebshop.pages;

import com.demowebshop.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage {
    private final WaitUtil wait;

    // Locators
    private final By orderSuccessMessage = By.xpath("//div[@class='title']/strong");

    public OrderSuccessPage(WebDriver driver, int timeout) {
        this.wait = new WaitUtil(driver, timeout);
    }

    public String getSuccessMessage() {
        return wait.waitForElementVisible(orderSuccessMessage).getText();
    }

    public boolean validateOrderSuccessMessage() {
        return getSuccessMessage().contains("successfully processed");
    }

}
