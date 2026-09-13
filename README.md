# SauceDemo Automation Framework 🚀

A robust, scalable, and secure UI automation framework built for [SauceDemo](https://www.saucedemo.com/). This project implements Behavior-Driven Development (BDD) utilizing Java, Selenium WebDriver, and Cucumber, structured around a clean Page Object/Action architecture.

## 🛠️ Tech Stack
* **Language:** Java 22
* **UI Automation:** Selenium WebDriver 4.x
* **BDD Framework:** Cucumber
* **Test Runner / Assertions:** TestNG
* **Build Tool:** Maven

## 🏗️ Architecture & Design Patterns
This framework strictly adheres to the **Separation of Concerns** principle:
* `locators/`: Contains String Templates and dynamic XPath locators.
* `actions/`: Contains UI interactions and WebDriver commands.
* `stepdefinitions/`: Glues Cucumber Gherkin steps to Java actions.
* `utils/`: Houses utility classes like `ConfigReader` for secure data handling.

## 🔒 Security & Configuration
Sensitive data (credentials, URLs) are externally managed and intentionally excluded from this repository. 

**To run this project locally, you must create a configuration file:**
1. Navigate to `src/test/resources/`
2. Create a file named `config.properties`
3. Add the following keys and populate them with your valid SauceDemo credentials:
   ```properties
   url=[https://www.saucedemo.com/](https://www.saucedemo.com/)
   valid_username=your_username
   valid_password=your_password
