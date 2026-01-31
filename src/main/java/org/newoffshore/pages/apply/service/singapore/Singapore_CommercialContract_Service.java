package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_CommercialContract_Service {
    private final WebDriverWait wait;

    public Singapore_CommercialContract_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectOptionContractCustom(){
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-slot='select-trigger']")));
        optionElement.click();
        WebElement quantityElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='5']]")));
        quantityElement.click();
    }

    public void sendKeyContractCustom(String text){
        WebElement customRequestElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@data-slot='textarea' and @placeholder='']")));
        customRequestElement.sendKeys(text);
    }

    public void selectCommercialContract_Custom(){
        selectButton("drafting_and_review_custom_contract");
        selectButton("singapore-apply-form-next");
        selectOptionContractCustom();
        sendKeyContractCustom("Test");
        selectButton("singapore-apply-form-next");
    }

    public void selectCommercialContract_Templates(){
        selectButton("specific_commercial_contract_templates");
        selectButton("singapore-apply-form-next");
        selectButton("sales_purchase_agreement");
        selectButton("distribution_reseller_agreement");
        selectButton("supply_agreement");
        selectButton("agency_agreement");
        selectButton("singapore-apply-form-next");
    }
}
