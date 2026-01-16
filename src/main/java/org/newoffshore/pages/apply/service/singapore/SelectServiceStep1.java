package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectServiceStep1 {
    private final WebDriver driver;

    public SelectServiceStep1(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutButton = By.id("check-out");
    private final By speakOurExpertButton = By.id("speak");
    private final By singaporeApplyNextButton = By.id("singapore-apply-form-next");

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public void clickSpeakOurExpertButton(){
        driver.findElement(singaporeApplyNextButton).click();
    }

    public void clickSingaporeApplyNextButton(){
        driver.findElement(singaporeApplyNextButton).click();
    }
}
