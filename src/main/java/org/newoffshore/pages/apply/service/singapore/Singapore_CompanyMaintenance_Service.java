package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_CompanyMaintenance_Service extends BasePage {
    public Singapore_CompanyMaintenance_Service(WebDriver driver) {
        super(driver);
    }

    private final By customRequestTextArea = By.xpath("//textarea[@data-slot='textarea' and @placeholder='Please enter a description here']");

    public void selectByLabel(String label){
        click(By.cssSelector("label[for='" + label +"']"));
    }

    public void selectById(String id){
        click(By.id(id));
    }

    public void sendKeyCustomRequestMaintain(String text){
        input(customRequestTextArea, text);
    }

    public void selectMaintain_For_Local_NoAccounting(){
        selectById("yes_local_director_for_renew");
        selectById("singapore-apply-form-next");
        //selectButton("appointment_director");
        //selectButton("resignation_director");
        //selectButton("update_director_shareholder_information");
        selectByLabel("change_business_activity");
        selectByLabel("change_company_name");
        selectByLabel("change_office_address");
        selectByLabel("increase_share_capital");
        //selectButton("transfer_shares");
        selectByLabel("extra_kyc_requirement");
        selectByLabel("custom_request");
        sendKeyCustomRequestMaintain("Test");
        selectByLabel("singapore-apply-form-next");
        selectByLabel("singapore-apply-form-next");
    }
}
