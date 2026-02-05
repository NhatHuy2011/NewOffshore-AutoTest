package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_CommercialContract_Service extends BasePage {
    public Singapore_CommercialContract_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectOptionContractCustom(){
        click(By.cssSelector("button[data-slot='select-trigger']"));
        click(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='5']]"));
    }

    public void sendKeyContractCustom(String text){
        input(By.xpath("//textarea[@data-slot='textarea' and @placeholder='']"), text);
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
