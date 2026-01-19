package org.newoffshore.pages.apply.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentInformation {
    private final WebDriver driver;

    public PaymentInformation(WebDriver driver) {
        this.driver = driver;
    }

    private final By termAndPrivacyButton = By.id("accept");

    private final By proceedToPaymentButton = By.cssSelector("button[type='submit']");

    public void selectPaymentMethod(String id){
        driver.findElement(By.cssSelector("label[for='" + id + "']")).click();
    }

    public void selectTermAndPrivacy(){
        driver.findElement(termAndPrivacyButton).click();
    }

    public void selectProceedToPayment(){
        driver.findElement(proceedToPaymentButton).click();
    }
}
