package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_CompanyMaintenance_Service {
    private final WebDriver driver;

    public Singapore_CompanyMaintenance_Service(WebDriver driver) {
        this.driver = driver;
    }

    private final By customRequestTextArea = By.xpath("//textarea[@data-slot='textarea' and @placeholder='Please enter a description here']");

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void sendKeyCustomRequestMaintain(String text){
        driver.findElement(customRequestTextArea).sendKeys(text);
    }

    public void selectMaintain_For_Local_NoAccounting(){
        selectButton("yes_local_director_for_renew");
        selectButton("singapore-apply-form-next");
        selectButton("appointment_director");
        selectButton("resignation_director");
        selectButton("appointment_auditor");
        selectButton("resignation_auditor");
        selectButton("update_director_shareholder_information");
        selectButton("change_business_activity");
        selectButton("change_company_name");
        selectButton("change_office_address");
        selectButton("increase_share_capital");
        selectButton("transfer_shares");
        selectButton("extra_kyc_requirement");
        selectButton("custom_request");
        sendKeyCustomRequestMaintain("Test");
        selectButton("singapore-apply-form-next");
        selectButton("singapore-apply-form-next");
    }
}
