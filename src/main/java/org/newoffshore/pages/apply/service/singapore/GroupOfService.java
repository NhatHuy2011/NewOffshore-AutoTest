package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupOfService {
    private final WebDriver driver;

    public GroupOfService(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectGroupService(String id){
        driver.findElement(By.cssSelector("label[for='"+ id +"']")).click();
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
