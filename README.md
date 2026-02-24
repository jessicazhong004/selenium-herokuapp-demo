# Selenium Herokuapp Demo

Small Java + Selenium WebDriver demo project against [the-internet.herokuapp.com](https://the-internet.herokuapp.com/login).

This repo is part of my QA automation demo portfolio, focused on a clean, minimal Selenium + Java setup.

## Tech Stack

- Java 17
- Selenium WebDriver 4
- WebDriverManager
- JUnit 5
- Maven

## Scenarios covered

Form Authentication flow on `https://the-internet.herokuapp.com/login`:

- **Positive**:
    - Login with valid credentials (`tomsmith` / `SuperSecretPassword!`)
    - Verify success flash message
    - Logout and verify redirect back to login page

- **Negative**:
    - Login with valid username and invalid password
    - Verify “Your password is invalid!” error message

## Test structure

- `BaseTest`
    - JUnit 5 `@BeforeEach` / `@AfterEach` for WebDriver setup and teardown
    - Uses WebDriverManager to resolve `chromedriver`
    - Applies basic timeouts and window size

- `LoginPage` (Page Object)
    - Encapsulates locators and interactions for the login page
    - Methods: `open()`, `login(username, password)`, `getFlashMessage()`, `logout()`

- `LoginTest`
    - Extends `BaseTest`
    - Contains positive + negative login tests using `LoginPage`

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

## Next steps (TODO)
- Add more negative scenarios (invalid username, empty fields)
- Add a `SecureAreaPage` object instead of asserting directly on the driver
- Add GitHub Actions workflow to run tests on push (Ubuntu + headless Chrome)