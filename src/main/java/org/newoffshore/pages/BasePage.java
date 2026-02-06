package org.newoffshore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void input(By locator, String text){
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        inputElement.sendKeys(Keys.CONTROL + "a");
        inputElement.sendKeys(Keys.DELETE);
        inputElement.sendKeys(text);
    }

    public void click(By locator){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        buttonElement.click();
    }

    public void scrollToElementAndClick(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Actions(driver).scrollToElement(element).click(element).perform();
    }
}
