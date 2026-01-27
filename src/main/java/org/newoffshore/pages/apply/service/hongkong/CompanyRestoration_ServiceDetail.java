package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyRestoration_ServiceDetail {
    private final WebDriverWait wait;

    public CompanyRestoration_ServiceDetail(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By continueButton = By.xpath("//button[normalize-space() = 'Cancel']");

    private final By textAreaCustom = By.xpath("//textarea[@placeholder = 'Please enter a description here]");

    public void clickCancel(){
        WebElement cancelElement = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        cancelElement.click();
    }

    public void sendKeyCustomRequest(String text){
        WebElement customRequestElement = wait.until(ExpectedConditions.elementToBeClickable(textAreaCustom));
        customRequestElement.sendKeys(text);
    }

    public void selectCompanyRestoration(){
        clickCancel();
        sendKeyCustomRequest("Test");
    }
}
