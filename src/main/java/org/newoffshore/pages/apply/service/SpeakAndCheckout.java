package org.newoffshore.pages.apply.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpeakAndCheckout {
    private final WebDriverWait wait;

    public SpeakAndCheckout(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By checkOutButton = By.id("check-out");

    private final By speakButton = By.id("speak");

    private final By nextButton = By.id("singapore-apply-form-next");

    public void selectCheckOutButton(){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        buttonElement.click();
    }

    public void selectSpeakButton(){
        WebElement speakElement = wait.until(ExpectedConditions.elementToBeClickable(speakButton));
        speakElement.click();
    }

    public void selectNextButton(){
        WebElement nextElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextElement.click();
    }
}
