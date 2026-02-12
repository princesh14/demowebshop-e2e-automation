package com.demowebshop.testdata;

import org.testng.annotations.DataProvider;

public class CheckoutDataProvider {
    @DataProvider(name = "checkoutData")
    public static Object[][] checkoutData() {

        return new Object[][]{

                {"Prem", "Sharma", "India", "Delhi", "#122, sector-61, Chandigarh", "110001", "9999999999"},
                {"Test", "XYZ", "India", "Mumbai", "#122, sector-61, Chandigarh", "400001", "8888888888"}

        };
    }
}