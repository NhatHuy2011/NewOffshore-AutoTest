package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommercialContract_ServiceDetail {
    private final WebDriver driver;

    public CommercialContract_ServiceDetail(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectOptionContractCustom(){
        driver.findElement(By.cssSelector("button[data-slot='select-trigger']")).click();
        driver.findElement(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='5']]")).click();
    }

    public void sendKeyContractCustom(String text){
        driver.findElement(By.xpath("//textarea[@data-slot='textarea' and @placeholder='']")).sendKeys(text);
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
