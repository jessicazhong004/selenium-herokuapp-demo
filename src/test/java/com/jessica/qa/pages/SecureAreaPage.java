package com.jessica.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {

    private final WebDriver driver;

    private final By header = By.cssSelector("#content h2");
    private final By flashMessage = By.id("flash");
    private final By logoutLink = By.cssSelector("a[href='/logout']");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        WebElement headerElement = driver.findElement(header);
        return headerElement.getText();
    }

    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }
}