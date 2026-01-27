package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupOfService {
    private final WebDriverWait wait;

    public GroupOfService(WebDriver driver) {
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
    public void selectGroupFormACompany() {
        selectGroupService("hk_form_a_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Management Transfer
    public void selectGroupCompanyManagementTransfer() {
        selectGroupService("hk_company_management_transfer");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Maintenance
    public void selectGroupCompanyMaintenance(){
        selectGroupService("hk_company_maintenance");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Restoration
    public void selectGroupCompanyRestoration(){
        selectGroupService("hk_company_restoration");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Accounting
    public void selectGroupAccounting(){
        selectGroupService("hk_accounting_services");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Business Bank
    public void selectGroupBusinessBank(){
        selectGroupService("hk_business_bank_account_opening");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Close Company
    public void selectGroupCloseCompany(){
        selectGroupService("hk_close_your_company_deregistration");
        selectButton("singapore-apply-form-next");
    }
}
