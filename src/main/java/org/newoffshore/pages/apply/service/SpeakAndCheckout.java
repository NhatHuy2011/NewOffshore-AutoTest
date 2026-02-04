package org.newoffshore.pages.apply.service;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpeakAndCheckout extends BasePage {
    public SpeakAndCheckout(WebDriver driver) {
        super(driver);
    }

    private final By checkOutButton = By.id("check-out");

    private final By speakButton = By.id("speak");

    private final By nextButton = By.id("singapore-apply-form-next");

    public void selectCheckOutButton(){
        click(checkOutButton);
    }

    public void selectSpeakButton(){
        click(speakButton);
    }

    public void selectNextButton(){
        click(nextButton);
    }

    public void selectCheckOut(){
        selectCheckOutButton();
        selectNextButton();
    }
}
