package org.newoffshore.pages.apply.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpeakAndCheckout {
    private final WebDriver driver;

    public SpeakAndCheckout(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkOutButton = By.id("check-out");

    private final By speakButton = By.id("speak");

    private final By nextButton = By.id("singapore-apply-form-next");

    public void selectCheckOutButton(){
        driver.findElement(checkOutButton).click();
    }

    public void selectSpeakButton(){
        driver.findElement(speakButton).click();
    }

    public void selectNextButton(){
        driver.findElement(nextButton).click();
    }
}
