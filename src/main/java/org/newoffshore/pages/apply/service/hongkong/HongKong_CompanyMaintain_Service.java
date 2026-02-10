package org.newoffshore.pages.apply.service.hongkong;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HongKong_CompanyMaintain_Service extends BasePage {
    public HongKong_CompanyMaintain_Service(WebDriver driver) {
        super(driver);
    }

    private final By cancelButton = By.xpath("//button[normalize-space() = 'Cancel']");

    public void clickCancel(){
        click(cancelButton);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for='"+ label +"'] textarea"), text);
    }

    public void selectCompanyMaintain(){
        selectButton("singapore-apply-form-next");
        selectButton("one_time_change_standard_company_resolutions");
        //selectButton("appointment_of_director_1_member");
        //selectButton("resignation_director");
        selectButton("share_capital_increase");
        //selectButton("share_transfer");
        selectButton("additional_kyc_kyb_per_member_business");
        selectButton("change_business_activities_on_business_register");
        selectButton("registration_brand_name_and_update_business_register");
        selectButton("change_company_name");
        selectButton("amendment_of_company_constitution");
        clickCancel();
        selectButton("12_month_of_unlimited_mail_scan_services");
        selectButton("company_chop_seal");
        selectButton("courier_dispatch_service");
        sendCustomRequest("courier_dispatch_service", "Text");
        selectButton("custom_request");
        sendCustomRequest("custom_request", "Text");
        selectButton("singapore-apply-form-next");
    }
}
