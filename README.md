# TestNG Automation Project for LambdaTest Selenium Playground

This project demonstrates automated testing of the LambdaTest Selenium Playground using TestNG with Selenium WebDriver.

## Project Overview

The project contains test scenarios that validate different functionalities of the LambdaTest Selenium Playground website.

## Project Overview
First Test Case - DW4SV-GLGXP-HYYVG-M4T65
Second Test Case - QVOF4-LEKHF-FW46U-5ISON
Third Test Case - 9G5MU-SDUQM-R1Y20-N12HB

## Pre-Conditions

1. Test setup uses `@BeforeMethod` annotation to:
    - Launch a browser
    - Navigate to `https://www.lambdatest.com/selenium-playground/`
2. Browser name and URL are parameterized and passed from TestNG XML suite
3. All test scenarios use the same base URL
4. Browser cleanup is handled by `@AfterMethod` annotation

## Test Scenarios

### Test Scenario 1: Page Title Validation

1. Performs explicit wait until all DOM elements are available
2. Uses SoftAssert to validate page title against "LambdaTest"
    - Expects assertion failure but continues execution
    - Demonstrates soft assertion behavior

### Test Scenario 2: Checkbox Demo Validation

1. Clicks "Checkbox Demo" link
2. Interacts with checkbox under "Single Checkbox Demo" section:
    - Clicks the checkbox and validates it's selected
    - Clicks again and validates it's unselected

### Test Scenario 3: JavaScript Alert Validation

1. Launches the same browser and URL
2. Clicks "Javascript Alerts" link
3. Interacts with alert:
    - Clicks "Click Me" button
    - Validates alert message text "I am an alert box!"
    - Accepts the alert