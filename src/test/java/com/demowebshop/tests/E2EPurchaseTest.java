package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.*;
import com.demowebshop.testdata.CheckoutDataProvider;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
q
public class E2EPurchaseTest extends BaseTest {
    private String selectedProductName;
    private static final Logger logger =
            LogManager.getLogger(E2EPurchaseTest.class);



    @Epic("Demo Web Shop")
    @Feature("E2E Purchase Flow")
    @Story("User completes full purchase")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validates full end-to-end purchase flow including login, cart validation and order confirmation")
    @Test(
            dataProvider = "checkoutData",
            dataProviderClass = CheckoutDataProvider.class
    )
    public void completePurchaseFlow(String firstName, String lastName, String country, String city, String address, String zip, String phone) throws InterruptedException {

        logger.info("-E2E PURCHASE FLOW STARTED-");
        login();
        searchAndAddProduct();
        verifyCartProduct();
        completeCheckoutFlow(firstName, lastName, country, city, address, zip, phone);
        verifyOrderSuccess();
        logger.info("-E2E PURCHASE FLOW COMPLETED SUCCESSFULLY-");

    }


    // STEP 1: LOGIN

    @Step("Login with valid credentials")
    private void login() {

        logger.info("Step 1: Login Started");

        LoginPage loginPage =
                new LoginPage(driver, config.getTimeout());

        loginPage.login(
                config.getEmail(),
                config.getPassword()
        );

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login was unsuccessful"
        );
        logger.info("Login Successful");
    }


    // STEP 2: SEARCH + ADD

    @Step("Search and add product to cart")
    private void searchAndAddProduct() {

        logger.info("Step 2: Searching and Adding Product");


        HomePage homePage =
                new HomePage(driver, config.getTimeout());

        homePage.searchProduct("computer");

        SearchResultsPage resultsPage =
                new SearchResultsPage(driver, config.getTimeout());


        resultsPage.addThirdProductToCart();

        ProductDetailsPage productDetails =
                new ProductDetailsPage(driver, config.getTimeout());

        selectedProductName = productDetails.getThirdProductName();

        productDetails.addToCartProduct();

        Assert.assertTrue(
                productDetails.isProductAddedSuccessfully(),
                "Product not added to cart successfully"
        );

        productDetails.closeNotificationAndWait();
        logger.info("Product Added Successfully");

    }


    // STEP 3: VERIFY CART ITEM

    @Step("Verify product in cart")
    private void verifyCartProduct() {

        logger.info("Step 3: Verifying Product in Cart");

        CartPage cartPage =
                new CartPage(driver, config.getTimeout());
        cartPage.clickShoppingCart();

        String productInCart = cartPage.getProductNameInCart();

        Assert.assertEquals(
                productInCart.trim(),
                selectedProductName.trim(),
                "Product added to cart did not match selected product"
        );

        cartPage.selectCountry("India");
        cartPage.acceptTerms();
        cartPage.clickCheckout();
        logger.info("Cart Verification Successful");

    }

    // STEP 4: CHECKOUT FLOW

    @Step("Complete checkout process")
    private void completeCheckoutFlow(String firstName, String lastName, String country, String city, String address, String zip, String phone) {
        logger.info("Step 4: Completing Checkout Flow");

        CheckoutPage checkoutPage =
                new CheckoutPage(driver, config.getTimeout());

        checkoutPage.selectNewBillingAddress();

        checkoutPage.fillBillingAddress(
                firstName,
                lastName,
                config.getEmail(),
                country,
                city,
                address,
                zip,
                phone
        );

        checkoutPage.clickBillingContinue();
        checkoutPage.clickShippingAddressContinue();
        checkoutPage.clickShippingMethodContinue();
        checkoutPage.clickPaymentMethodContinue();
        checkoutPage.clickPaymentInfoContinue();
        checkoutPage.clickConfirmOrder();
        logger.info("Checkout Flow Completed");
    }


    // STEP 5: VERIFY ORDER

    @Step("Verify order success")
    private void verifyOrderSuccess() {

        logger.info("Step 5: Verifying Order Success");
        OrderSuccessPage orderSuccess =
                new OrderSuccessPage(driver, config.getTimeout());

        Assert.assertTrue(
                orderSuccess.validateOrderSuccessMessage(),
                "Order was not placed successfully"
        );
        logger.info("Order Placed Successfully");
    }
}
