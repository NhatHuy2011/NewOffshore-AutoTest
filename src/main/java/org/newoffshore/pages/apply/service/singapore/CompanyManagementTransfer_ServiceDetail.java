package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyManagementTransfer_ServiceDetail {
    private final WebDriver driver;

    public CompanyManagementTransfer_ServiceDetail(WebDriver driver) {
        this.driver = driver;
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectTerm(){
        driver.findElement(okTermButton).click();
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
