package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_CompanyManagementTransfer_Service {
    private final WebDriverWait wait;

    public Singapore_CompanyManagementTransfer_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectTerm(){
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(okTermButton));
        termElement.click();
    }

    public void selectTransfer_For_Local_NoAccounting(){
        selectTerm();
        selectButton("yes_local_director_for_switch");
        selectButton("singapore-apply-form-next");
        selectButton("no_use_accounting_service");
        selectButton("singapore-apply-form-next");
    }

    public void selectTransfer_For_Local_HasAccounting(){
        selectTerm();
        selectButton("yes_local_director_for_switch");
        selectButton("singapore-apply-form-next");
        selectButton("yes_use_accounting_service");
        selectButton("singapore-apply-form-next");
        selectButton("standard_compliance");
        selectButton("51_200");
        selectButton("singapore-apply-form-next");
    }

    public void selectTransfer_For_NoLocal(){
        selectTerm();
        selectButton("no_local_director_for_switch");
        selectButton("singapore-apply-form-next");
        selectButton("1_foreign_director");
        selectButton("singapore-apply-form-next");
        selectButton("switch_1_director_2_shareholder");
        selectButton("singapore-apply-form-next");
        selectButton("standard_compliance");
        selectButton("51_200");
        selectButton("singapore-apply-form-next");
    }
}
