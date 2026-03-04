package com.jessica.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureAreaPage {

    private final WebDriver driver;

    private final By header = By.cssSelector("#content h2");
    private final By flashMessage = By.id("flash");
    private final By logoutLink = By.cssSelector("a[href='/logout']");

    // 可以按需调整等待时间
    private final Duration DEFAULT_WAIT = Duration.ofSeconds(5);

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        WebElement headerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return headerElement.getText();
    }

    public String getFlashMessage() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        WebElement flashElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return flashElement.getText();
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        WebElement logout =
                wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logout.click();
    }
}