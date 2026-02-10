package org.newoffshore.pages.apply.service.hongkong;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HongKong_CompanyRestoration_Service extends BasePage {
    public HongKong_CompanyRestoration_Service(WebDriver driver) {
        super(driver);
    }

    private final By continueButton = By.xpath("//button[normalize-space() = 'Cancel']");

    private final By textAreaCustom = By.xpath("//textarea[@placeholder = 'Please enter a description here']");

    private final By nextButton = By.id("singapore-apply-form-next");

    public void clickCancel(){
        click(continueButton);
    }

    public void sendKeyCustomRequest(String text){
        input(textAreaCustom, text);
    }

    public void clickNextButton(){
        click(nextButton);
    }

    public void selectCompanyRestoration(){
        clickCancel();
        sendKeyCustomRequest("Test");
        clickNextButton();
    }
}
