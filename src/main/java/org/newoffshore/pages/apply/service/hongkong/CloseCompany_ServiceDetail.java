package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloseCompany_ServiceDetail {
    private final WebDriverWait wait;

    public CloseCompany_ServiceDetail(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By cancelButton = By.xpath("//button[normalize-space() = 'Cancel']");

    private final By textAreaCustom = By.xpath("//textarea[@placeholder = 'Please enter a description here]");

    public void selectCancelButton(){
        WebElement cancelButtonElement = wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButtonElement.click();
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void sendKeyCustomRequest(String text){
        WebElement textAreaElement = wait.until(ExpectedConditions.elementToBeClickable(textAreaCustom));
        textAreaElement.sendKeys(text);
    }

    public void selectCloseCompany(){
        selectCancelButton();
        sendKeyCustomRequest("Test");
        selectButton("singapore-apply-form-next");
    }
}
