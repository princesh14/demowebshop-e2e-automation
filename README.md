# Demo Web Shop – End-to-End Automation Framework

## 📖 Overview

This repository contains a production-style End-to-End automation framework built using:

- Java 21
- Selenium WebDriver 4
- TestNG
- Maven
- WebDriverManager
- Log4j2
- Allure Reporting

The framework automates the complete purchase workflow on:

https://demowebshop.tricentis.com

It follows the **Page Object Model (POM)** design pattern with emphasis on modularity, scalability, configurability, structured logging, and reporting integration.

---

## 🏗 Framework Architecture

The framework is structured with clear separation of concerns:

- **BaseTest** → Manages test lifecycle (setup / teardown)
- **DriverFactory** → Centralized browser initialization & parameterization
- **Page Classes** → Encapsulate UI interactions using POM
- **Utility Classes** → Explicit wait handling & configuration management
- **ConfigReader** → Externalized runtime configuration
- **Log4j2** → Structured execution logging
- **Allure** → Reporting with automatic failure screenshot attachment

This design ensures:

- Reusable components
- Clean test orchestration
- Maintainable locator strategy
- Scalable structure for future test expansion
- Production-ready reporting setup

---

## 🧪 Automated Test Scenario

The implemented E2E flow includes:

- Application launch
- Login with valid credentials
- Product search
- Product selection
- Add to cart
- Cart item validation
- Checkout process (billing, shipping, payment)
- Order confirmation validation

### Strategic Assertions

Assertions are placed at:

- Login success validation
- Product addition confirmation
- Cart item verification
- Order success message validation

---

## ⚙ Configuration Management

Runtime configuration is externalized in:

src/main/resources/config.properties


### Supported Configuration Keys

- `baseURL`
- `browser`
- `email`
- `password`
- `timeout`

### Example Configuration

baseURL=https://demowebshop.tricentis.com
browser=chrome
email=qa.user123@mailinator.com
password=Engineer009876
timeout=10


This allows environment-level changes without modifying code and supports browser parameterization.

---

## 📊 Logging

Log4j2 is integrated for structured logging.

- Execution logs capture major business steps
- Page-level actions are traceable
- Logs are generated under:

/logs/


This improves debuggability and execution trace validation.

---

## 📈 Reporting

Allure reporting is integrated at framework level.

### Features

- Automatic result generation
- Failure screenshot attachment
- Execution summary & step traceability
- Status distribution & diagnostics

### Generate Allure Report

mvn clean test
allure serve allure-results


Allure results are generated inside:

/allure-results/


---

## 🚀 Test Execution

### Prerequisites

- Java 21+
- Maven 3.8+
- Allure CLI installed

### Run Entire Test Suite

mvn clean test


### Run Specific TestNG Suite

mvn clean test -DsuiteXmlFile=testng.xml

---

## AI Usage Disclosure

GenAI tools were used to accelerate architecture validation, and reporting integration refinement.  
All architectural decisions, structuring, and implementation logic were reviewed and aligned with automation best practices.

### Example Prompts Used

- Design a scalable Selenium TestNG framework using POM.
- Integrate Allure reporting with TestNG including screenshot attachment.
- Implement structured Log4j2 logging for Selenium framework.
- Suggest modular orchestration for E2E checkout flow.
- Externalize configuration using properties file.

### Tools Leveraged

- ChatGPT (architecture refinement & reporting integration)
- GitHub Copilot (IDE-level scaffolding assistance)

GenAI tools were used as development accelerators, not substitutes for design ownership.

---

## Design Considerations

- Clean separation of concerns
- Centralized driver management
- Explicit wait strategy
- Externalized configuration
- Structured logging
- Production-grade reporting integration
- Parameterization support
- Maintainable and scalable architecture
