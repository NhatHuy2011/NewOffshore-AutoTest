package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_GroupOfService extends BasePage {
    public USA_GroupOfService(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectGroupService(String id){
        click(By.cssSelector(("label[for='"+ id +"']")));
    }

    //Select Group Of Service - Form A Company
    public void selectGroupFormACompany(){
        selectGroupService("us_form_a_company");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Management Transfer
    public void selectGroupCompanyManagementTransfer(){
        selectGroupService("us_company_management_transfer");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Company Maintenance
    public void selectGroupCompanyMaintenance(){
        selectGroupService("us_company_maintenance");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Accounting Service
    public void selectGroupAccounting(){
        selectGroupService("us_accounting_services");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Close your company
    public void selectGroupCloseCompany(){
        selectGroupService("us_close_us_llc_delaware");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Revive Company
    public void selectGroupReviveCompany(){
        selectGroupService("us_revive_us_llc_delaware");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Business Banking
    public void selectGroupBusinessBanking(){
        selectGroupService("us_business_bank_account_opening");
        selectButton("singapore-apply-form-next");
    }

    //Select Group Of Service - Conversion Of Other US LLC
    public void selectGroupConversionOfUSLLC(){
        selectGroupService("us_conversion_other_us_llc_delaware");
        selectButton("singapore-apply-form-next");
    }
}
