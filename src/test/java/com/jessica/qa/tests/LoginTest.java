package com.jessica.qa.tests;

import com.jessica.qa.pages.LoginPage;
import com.jessica.qa.pages.SecureAreaPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void validLoginShouldSucceed() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);

        String headerText = secureAreaPage.getHeaderText();
        assertEquals("Secure Area", headerText, "Expected to be on Secure Area page after login.");

        String successMessage = secureAreaPage.getFlashMessage();
        assertTrue(
                successMessage.contains("You logged into a secure area!"),
                "Expected success login message, but got: " + successMessage
        );

        secureAreaPage.logout();

        assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Expected to be back on login page after logout."
        );
    }

    @Test
    void invalidPasswordShouldShowError() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("tomsmith", "WrongPassword!");

        String message = loginPage.getFlashMessage();
        assertTrue(
                message.contains("Your password is invalid!"),
                "Expected invalid password message, but got: " + message
        );
    }
}