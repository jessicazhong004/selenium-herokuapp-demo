package com.jessica.qa.tests;

import com.jessica.qa.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1280, 800));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void validLoginShouldSucceed() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        String message = loginPage.getFlashMessage();
        assertTrue(
                message.contains("You logged into a secure area!"),
                "Expected success login message, but got: " + message
        );

        loginPage.logout();
        assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Expected to be back on login page after logout."
        );
    }
}