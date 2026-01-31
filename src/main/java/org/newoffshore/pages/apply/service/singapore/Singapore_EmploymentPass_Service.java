package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_EmploymentPass_Service {
    private final WebDriverWait wait;

    public Singapore_EmploymentPass_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");
    private final By cancelGoogleCalendarButton = By.xpath("//button[normalize-space() = 'Cancel']");

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectTerm(){
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(okTermButton));
        termElement.click();
    }

    public void selectCancel(){
        WebElement cancelElement = wait.until(ExpectedConditions.elementToBeClickable(cancelGoogleCalendarButton));
        cancelElement.click();
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
