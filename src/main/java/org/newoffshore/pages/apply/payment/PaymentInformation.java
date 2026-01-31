package org.newoffshore.pages.apply.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentInformation {
    private final WebDriverWait wait;

    public PaymentInformation(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By termAndPrivacyButton = By.id("accept");

    private final By proceedToPaymentButton = By.cssSelector("button[type='submit']");

    private final By completePaymentButton = By.xpath("//button[normalize-space() = 'I’ve Completed the Payment']");

    public void selectPaymentMethod(String id){
        WebElement paymentMethodElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='" + id + "']")));
        paymentMethodElement.click();
    }

    public void selectTermAndPrivacy(){
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(termAndPrivacyButton));
        termElement.click();
    }

    public void selectProceedToPayment(){
        WebElement proceedToPaymentElement = wait.until(ExpectedConditions.elementToBeClickable(proceedToPaymentButton));
        proceedToPaymentElement.click();
    }

    public void selectCompletedPayment(){
        WebElement completedElement = wait.until(ExpectedConditions.elementToBeClickable(completePaymentButton));
        completedElement.click();
    }

    public void fillPaymentInformation(){
        selectPaymentMethod("transfer");
        selectTermAndPrivacy();
        selectProceedToPayment();
        selectCompletedPayment();
    }
}
