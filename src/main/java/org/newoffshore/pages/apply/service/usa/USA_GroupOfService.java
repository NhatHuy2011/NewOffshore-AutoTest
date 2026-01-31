package org.newoffshore.pages.apply.service.usa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class USA_GroupOfService {
    private final WebDriverWait wait;

    public USA_GroupOfService(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectGroupService(String id){
        WebElement groupServiceElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(("label[for='"+ id +"']"))));
        groupServiceElement.click();
    }

    //Select Group Of Service - Form A Company
    public void selectGroupFormACompany(){
        selectGroupService("us_form_a_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Management Transfer
    public void selectGroupCompanyManagementTransfer(){
        selectButton("us_company_management_transfer");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Maintenance
    public void selectGroupCompanyMaintenance(){
        selectButton("us_company_maintenance");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Accounting Service
    public void selectGroupAccounting(){
        selectButton("us_accounting_services");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Close your company
    public void selectGroupCloseCompany(){
        selectButton("us_close_us_llc_delaware");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Revive Company
    public void selectGroupReviveCompany(){
        selectButton("us_revive_us_llc_delaware");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Business Banking
    public void selectGroupBusinessBanking(){
        selectButton("us_business_bank_account_opening");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Conversion Of Other US LLC
    public void selectGroupConversionOfUSLLC(){
        selectButton("us_conversion_other_us_llc_delaware");
        selectButton("singapore-apply-form-next");
    }
}
