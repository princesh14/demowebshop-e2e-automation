package com.demowebshop.pages;

import com.demowebshop.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private final WaitUtil wait;

    // Locators

    private final By loginLink = By.xpath("//a[@class='ico-login' and contains(text(),'Log in')]");
    private final By emailField = By.cssSelector("input[class='email']");
    private final By passwordField = By.xpath("//input[@id='Password']");
    private final By loginButton = By.cssSelector("input[value='Log in']");
    private final By logoutLink = By.xpath("//a[contains(text(),'Log out')]");

    public LoginPage(WebDriver driver, int timeout) {
        this.wait = new WaitUtil(driver, timeout);
    }

    public void login(String email, String password) {
        wait.waitForElementClickable(loginLink).click();
        wait.waitForElementVisible(emailField).sendKeys(email);
        wait.waitForElementVisible(passwordField).sendKeys(password);
        wait.waitForElementClickable(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return wait.waitForElementVisible(logoutLink).isDisplayed();
    }
}
