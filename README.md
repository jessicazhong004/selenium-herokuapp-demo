# Selenium Herokuapp Demo

Small Java + Selenium WebDriver demo project against [the-internet.herokuapp.com](https://the-internet.herokuapp.com/login).

## Tech Stack

- Java 17
- Selenium WebDriver 4
- WebDriverManager
- JUnit 5
- Maven

## What this demo covers

- Form Authentication login flow:
    - Open login page
    - Login with valid credentials
    - Verify success flash message
    - Logout and verify redirect back to login page

## How to run locally

```bash
mvn test
```
## Next steps (TODO)

- Add negative login tests (invalid username/password)
- Add GitHub Actions workflow to run tests on push (Ubuntu + headless Chrome)
- Extract BaseTest class for WebDriver setup/teardown

