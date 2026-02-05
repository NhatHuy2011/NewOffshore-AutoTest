package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_GroupOfService extends BasePage {
    public Panama_GroupOfService(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectGroupService(String id){
        click(By.cssSelector(("label[for='"+ id +"']")));
    }

    //Select Group Of Service - Form A Company
    public void selectGroupFormACompany() {
        selectGroupService("pa_form_a_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Transfer In
    public void selectGroupTransferIn() {
        selectGroupService("pa_transfer_company_to_us");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Maintenance
    public void selectGroupCompanyMaintenance(){
        selectGroupService("pa_company_maintenance");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Nominee Service
    public void selectGroupNomineeService(){
        selectGroupService("pa_nominee_services");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Close Company
    public void selectGroupCloseCompany(){
        selectGroupService("pa_close_company_dissolution");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Restoration
    public void selectGroupCompanyRestoration(){
        selectGroupService("pa_restore_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Business Bank
    public void selectGroupBusinessBank(){
        selectGroupService("pa_business_bank_account_opening");
        selectButton("singapore-apply-form-next");
    }
}
