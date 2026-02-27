package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_GroupOfService extends BasePage {
    public BVI_GroupOfService(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectGroupService(String id){
        click((By.cssSelector(("label[for='"+ id +"']"))));
    }

    //Select Group Of Service - Form A Company
    public void selectGroupFormACompany() {
        selectGroupService("vg_form_a_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Nominee Directorship
    public void selectGroupNomineeDirectorship(){
        selectGroupService("vg_nominee_services");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Management Transfer
    public void selectGroupCompanyManagementTransfer() {
        selectGroupService("vg_company_management_transfer");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Maintenance
    public void selectGroupCompanyMaintenance(){
        selectGroupService("vg_company_maintenance");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Close Company
    public void selectGroupCloseCompany(){
        selectGroupService("vg_close_company_dissolution");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Restoration
    public void selectGroupCompanyRestoration(){
        selectGroupService("vg_restore_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Shelf Company Purchase
    public void selectGroupShelfCompany(){
        selectGroupService("vg_shelf_company_purchase");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Business Bank
    public void selectGroupBusinessBank(){
        selectGroupService("vg_business_bank_account_opening");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Continuation/Discontinuation Service
    public void selectGroupContinuation_DiscontinuationService(){
        selectGroupService("vg_continuation_discontinuation_service");
        selectButton("singapore-apply-form-next");
    }
}
