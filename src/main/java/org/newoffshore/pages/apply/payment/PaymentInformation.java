package org.newoffshore.pages.apply.payment;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentInformation extends BasePage {
    public PaymentInformation(WebDriver driver) {
        super(driver);
    }

    private final By termAndPrivacyButton = By.id("accept");

    private final By proceedToPaymentButton = By.cssSelector("button[type='submit']");

    private final By completePaymentButton = By.xpath("//button[normalize-space() = 'I’ve Completed the Payment']");

    public void selectPaymentMethod(String id){
        click(By.cssSelector("label[for='" + id + "']"));
    }

    public void selectTermAndPrivacy(){
        click(termAndPrivacyButton);
    }

    public void selectProceedToPayment(){
        click(proceedToPaymentButton);
    }

    public void selectCompletedPayment(){
        click(completePaymentButton);
    }

    public void fillPaymentInformation(){
        selectPaymentMethod("transfer");
        selectTermAndPrivacy();
        selectProceedToPayment();
        selectCompletedPayment();
    }
}
