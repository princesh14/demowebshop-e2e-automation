package com.demowebshop.pages;

import com.demowebshop.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    private final WaitUtil wait;

    // Locators
    private final By billingAddressDropdown = By.xpath("//select[@id='billing-address-select']");
    private final By firstName = By.xpath("//input[@id='BillingNewAddress_FirstName']");
    private final By lastName = By.xpath("//input[@id='BillingNewAddress_LastName']");
    private final By email = By.xpath("//input[@id='BillingNewAddress_Email']");
    private final By countryName = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private final By city = By.xpath("//input[@id='BillingNewAddress_City']");
    private final By billingAddress = By.xpath("//input[@id='BillingNewAddress_Address1']");
    private final By postalCode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private final By phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    private final By billingContinueButton = By.xpath("//input[@onclick='Billing.save()']");
    private final By shippingAddressContinue = By.xpath("//input[@onclick='Shipping.save()']");
    private final By shippingMethodContinue = By.xpath("//input[@onclick='ShippingMethod.save()']");
    private final By paymentMethodContinue = By.xpath("//input[@onclick='PaymentMethod.save()']");
    private final By paymentInfoContinue = By.xpath("//input[@onclick='PaymentInfo.save()']");
    private final By confirmOrderButton = By.xpath("//input[@onclick='ConfirmOrder.save()']");


    public CheckoutPage(WebDriver driver, int timeout) {
        this.wait = new WaitUtil(driver, timeout);
    }


    public void selectNewBillingAddress() {

        Select select = new Select(
                wait.waitForElementVisible(billingAddressDropdown)
        );

        select.selectByVisibleText("New Address");
    }

    public void fillBillingAddress(String fName, String lName,
                                   String mail, String country,
                                   String cityName,
                                   String address,
                                   String zip,
                                   String phone) {

        WebElement fNameField = wait.waitForElementVisible(firstName);
        fNameField.clear();
        fNameField.sendKeys(fName);

        WebElement lNameField = wait.waitForElementVisible(lastName);
        lNameField.clear();
        lNameField.sendKeys(lName);

        WebElement emailField = wait.waitForElementVisible(email);
        emailField.clear();
        emailField.sendKeys(mail);

        Select select = new Select(wait.waitForElementVisible(countryName));
        select.selectByVisibleText(country);

        wait.waitForElementVisible(city).sendKeys(cityName);
        wait.waitForElementVisible(billingAddress).sendKeys(address);
        wait.waitForElementVisible(postalCode).sendKeys(zip);
        wait.waitForElementVisible(phoneNumber).sendKeys(phone);
    }

    public void clickBillingContinue() {
        wait.waitForElementClickable(billingContinueButton).click();
    }

    public void clickShippingAddressContinue() {
        wait.waitForElementClickable(shippingAddressContinue).click();
    }

    public void clickShippingMethodContinue() {
        wait.waitForElementClickable(shippingMethodContinue).click();
    }

    public void clickPaymentMethodContinue() {
        wait.waitForElementClickable(paymentMethodContinue).click();
    }

    public void clickPaymentInfoContinue() {
        wait.waitForElementClickable(paymentInfoContinue).click();
    }

    public void clickConfirmOrder() {
        wait.waitForElementClickable(confirmOrderButton).click();
    }


}
