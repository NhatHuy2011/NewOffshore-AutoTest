package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_CompanyManagementTransfer_Service extends BasePage {
    public BVI_CompanyManagementTransfer_Service(WebDriver driver) {
        super(driver);
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectTerm(){
        click(okTermButton);
    }

    public void selectCompanyManagementTransferService(){
        selectTerm();
        selectButton("administration_transfer_in");
        selectButton("singapore-apply-form-next");
    }
}
