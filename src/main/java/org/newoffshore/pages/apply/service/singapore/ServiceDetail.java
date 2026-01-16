package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.apply.contact.ContactInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServiceDetail {
    private final WebDriver driver;

    public ServiceDetail(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectTerm(){
        driver.findElement(By.xpath("//button[normalize-space() = 'OK']")).click();
    }

    public void selectCancel(){
        driver.findElement(By.xpath("//button[normalize-space() = 'Cancel']")).click();
    }

    public void sendKeyCustomRequestMaintain(String text){
        driver.findElement(By.xpath("//textarea[@data-slot='textarea' and @placeholder='Please enter a description here']")).sendKeys(text);
    }

    public void selectOptionContractCustom(){
        driver.findElement(By.cssSelector("button[data-slot='select-trigger']")).click();
        driver.findElement(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='5']]")).click();
    }

    public void sendKeyContractCustom(String text){
        driver.findElement(By.xpath("//textarea[@data-slot='textarea' and @placeholder='']")).sendKeys(text);
    }

    public void selectGroupService(String id){
        driver.findElement(By.cssSelector("label[for='"+ id +"']")).click();
    }

    //Select Group Of Service - Form A Company
    public void selectGroupFormACompany() {
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("form_a_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Management Transfer
    public void selectGroupCompanyManagementTransfer() {
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("company_management_transfer");
        selectButton("singapore-apply-form-next");
        selectTerm();
    }

    //Select Group Of Service - Company Maintainance
    public void selectGroupCompanyMaintainance(){
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("company_maintenance");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Nominee Directorship
    public void selectGroupNomineeDirectorship(){
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("nominee_directorship");
        selectButton("singapore-apply-form-next");
        selectTerm();
    }

    //Select Group Of Service - Accounting
    public void selectGroupAccounting(){
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("accounting");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Business Bank
    public void selectGroupBusinessBank(){
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("business_banking");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Employment Pass
    public void selectGroupEmploymentPass(){
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("employment_pass");
        selectButton("singapore-apply-form-next");
        selectTerm();
    }

    //Select Group Of Service - Commercial Contract
    public void selectGroupCommercialContract(){
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("commercial_contracts");
        selectButton("singapore-apply-form-next");
    }
}
