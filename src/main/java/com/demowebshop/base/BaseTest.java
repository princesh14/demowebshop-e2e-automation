package com.demowebshop.base;

import com.demowebshop.factory.DriverFactory;
import com.demowebshop.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Attachment;


public class BaseTest {

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected ConfigReader config;
    protected DriverFactory driverFactory;

    @BeforeMethod
    public void setup() {

        logger.info("Initializing ConfigReader");
        config = new ConfigReader();

        logger.info("Initializing DriverFactory");
        driverFactory = new DriverFactory();

        logger.info("Launching browser");
        driver = driverFactory.initDriver();

        logger.info("Navigating to URL: {}", config.getBaseUrl());
        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot();
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}
