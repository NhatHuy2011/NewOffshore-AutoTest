package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_CompanyManagementTransfer_Service extends BasePage {
    public USA_CompanyManagementTransfer_Service(WebDriver driver) {
        super(driver);
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectTerm(){
        click(okTermButton);
    }

    public void selectCompanyManagementTransfer(){
        selectTerm();
        selectButton("federal_ein_registration_foreigner");
        selectButton("beneficial_ownership_report");
        selectButton("standard");
        selectButton("singapore-apply-form-next");
    }
}
