package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_EmploymentPass_Service {
    private final WebDriver driver;

    public Singapore_EmploymentPass_Service(WebDriver driver) {
        this.driver = driver;
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");
    private final By cancelGoogleCalendarButton = By.xpath("//button[normalize-space() = 'Cancel']");

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectTerm(){
        driver.findElement(okTermButton).click();
    }

    public void selectCancel(){
        driver.findElement(cancelGoogleCalendarButton).click();
    }

    public void selectEmploymentPass(){
        selectTerm();
        selectButton("employment_pass_for_owner_company");
        selectButton("singapore-apply-form-next");
        selectButton("rmi_degree_verification");
        selectButton("singapore-apply-form-next");
    }

    public void selectDependantPass(){
        selectTerm();
        selectButton("dependent_pass_for_family_bundle");
        selectCancel();
        selectButton("singapore-apply-form-next");
    }
}
