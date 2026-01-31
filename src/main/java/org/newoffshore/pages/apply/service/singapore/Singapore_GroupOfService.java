package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_GroupOfService {
    private final WebDriverWait wait;

    public Singapore_GroupOfService(WebDriver driver) {
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
        selectGroupService("form_a_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Management Transfer
    public void selectGroupCompanyManagementTransfer() {
        selectGroupService("company_management_transfer");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Maintenance
    public void selectGroupCompanyMaintenance(){
        selectGroupService("company_maintenance");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Nominee Directorship
    public void selectGroupNomineeDirectorship(){
        selectGroupService("nominee_directorship");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Accounting
    public void selectGroupAccounting(){
        selectGroupService("accounting");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Business Bank
    public void selectGroupBusinessBank(){
        selectGroupService("business_banking");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Employment Pass
    public void selectGroupEmploymentPass(){
        selectGroupService("employment_pass");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Commercial Contract
    public void selectGroupCommercialContract(){
        selectGroupService("commercial_contracts");
        selectButton("singapore-apply-form-next");
    }
}
