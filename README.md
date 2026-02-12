
# Demo Web Shop – End-to-End Automation Framework



# Overview :

This repository contains an end-to-end automation framework developed using Java, Selenium WebDriver, TestNG, and Maven. The framework automates the complete purchase workflow on the Demo Web Shop application at https://demowebshop.tricentis.com
.The implementation follows the Page Object Model design pattern with emphasis on modularity, maintainability, configurability, and reporting integration.



# Technology Stack :

Java 21, Selenium WebDriver 4, TestNG, Maven, WebDriverManager, Allure Reporting, Log4j2 Logging.



# Framework Architecture : 

The framework is structured with clear separation of concerns. BaseTest handles test lifecycle management including driver initialization and teardown, DriverFactory centralizes browser configuration, Page classes encapsulate UI interactions using Page Object Model, utility classes manage waits and configuration reading, the test layer orchestrates business flow steps, configuration is externalized via properties file, logging is centralized through Log4j2, reporting is integrated using Allure.

The design ensures scalability, clean test orchestration, reusable components, maintainable locator strategy, and production-ready reporting structure.



# Automated Test Scenario : 

The implemented end-to-end flow includes launching the application, performing login with valid credentials, searching for a product, adding the product to cart, validating cart contents against selected item, proceeding to checkout, filling billing and shipping details, completing shipping and payment steps, confirming the order, validating order success message.

Assertions are placed at strategic validation points including login success, product added confirmation, cart verification, and order completion verification.



# Configuration Management :

Runtime configuration is externalized in src/test/resources/config.properties. The configuration file contains baseURL, browser, email, password, timeout. This enables environment-level changes without modifying source code and supports browser-level parameterization.

Example configuration:

baseURL=https://demowebshop.tricentis.com

browser=chrome
email=qa.user123@mailinator.com

password=Engineer@09876
timeout=10



# Logging :

Log4j2 is integrated to provide structured execution logging. Logging is implemented at test orchestration level and critical page action levels to ensure traceability of business steps. Logs are generated in the logs directory and help in debugging and execution trace validation.



# Reporting :

Allure reporting is integrated at the framework level. Test execution generates result files in target/allure-results. Failure screenshots are captured automatically and attached to the Allure report. The report provides execution summary, step traceability, status distribution, and failure diagnostics.



# Test Execution :

Prerequisites include Java 21 or higher, Maven 3.8 or higher, Allure CLI installed and configured.

To execute the test suite:

mvn clean test

To generate and view the Allure report:

allure serve target/allure-results



# Data-Driven and Parameterization Support :

The framework supports parameterization via TestNG DataProvider and configuration-based browser selection. Test data such as credentials and environment configuration are externalized. The checkout flow supports dynamic test data injection through parameterized methods.



# Use of Generative AI Tools :

Generative AI tools were used selectively to accelerate development and validate architectural decisions. AI assistance was leveraged for refining the Page Object Model structure, improving modular test orchestration, validating locator strategies, enhancing reporting integration (Allure), and reviewing logging configuration patterns.

ChatGPT was used for framework-level design validation, refactoring suggestions, and reviewing best practices around TestNG lifecycle management, reporting, and modular utilities. GitHub Copilot was used within the IDE to assist with boilerplate code generation, method scaffolding, and improving code readability. All AI-generated suggestions were critically reviewed, adjusted where necessary, and aligned with the intended framework design before integration.

AI usage was focused on development acceleration and structural validation. Final implementation decisions, architecture design, and business validation logic were curated, consolidated, and verified manually.


# Tools leveraged :

ChatGPT, GitHub Copilot, IntelliJ IDEA.



# Conclusion :

This solution demonstrates a scalable automation framework aligned with senior SDET practices, including modular design, externalized configuration, structured logging, reporting integration, clean assertion strategy, and maintainable code architecture. The framework is extensible and suitable for CI/CD integration with minimal structural adjustments.