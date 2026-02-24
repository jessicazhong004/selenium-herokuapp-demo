# Selenium Herokuapp Demo

![Selenium Tests](https://github.com/jessicazhong004/selenium-herokuapp-demo/actions/workflows/tests.yml/badge.svg)

Small Java + Selenium WebDriver demo project against [the-internet.herokuapp.com](https://the-internet.herokuapp.com/login).

This repo is part of my QA automation demo portfolio, focused on a clean, minimal Selenium + Java setup with CI.

## Tech Stack

- Java 17
- Selenium WebDriver 4
- WebDriverManager
- JUnit 5
- Maven
- GitHub Actions (CI)

## Scenarios covered

Form Authentication flow on `https://the-internet.herokuapp.com/login`:

- **Positive**
    - Login with valid credentials (`tomsmith` / `SuperSecretPassword!`)
    - Land on the secure area page
    - Verify success flash message
    - Logout and verify redirect back to login page

- **Negative**
    - Login with valid username and invalid password
    - Verify the “Your password is invalid!” error message on the login page

## Test structure

- `BaseTest`
    - JUnit 5 `@BeforeEach` / `@AfterEach` for WebDriver setup and teardown
    - Uses WebDriverManager to resolve `chromedriver`
    - Runs Chrome headed locally, headless in CI (controlled via `CI` env var)

- `LoginPage` (Page Object)
    - Encapsulates locators and interactions for the login page
    - Methods: `open()`, `login(username, password)`, `getFlashMessage()`

- `SecureAreaPage` (Page Object)
    - Represents the authenticated “Secure Area” page
    - Methods: `getHeaderText()`, `getFlashMessage()`, `logout()`

- `LoginTest`
    - Extends `BaseTest`
    - Contains positive + negative login tests using the Page Objects

## How to run locally

Requirements:

- Java 17+
- Maven

From the project root:

```bash
mvn test
```
Maven will download dependencies and run the JUnit tests.
Chrome is started via WebDriverManager; no manual driver download is needed.

## Continuous Integration

GitHub Actions workflow (`.github/workflows/tests.yml`) runs the Maven tests on:
- every push to `main`
- every pull request targeting `main`

The workflow:
- checks out the code
- installs Java 17
- installs Chrome + ChromeDriver
- runs `mvn test` in headless mode

## Next steps (TODO)
- Add more negative scenarios (invalid username, empty fields)
- Add data-driven tests for multiple credential sets
- Extend Page Objects for other pages in the-internet.herokuapp app