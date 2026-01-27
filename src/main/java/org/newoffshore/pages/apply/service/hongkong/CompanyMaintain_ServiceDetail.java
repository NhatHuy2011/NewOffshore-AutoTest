package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyMaintain_ServiceDetail {
    private final WebDriverWait wait;

    public CompanyMaintain_ServiceDetail(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void sendCustomRequest(String label, String text){
        WebElement customRequestElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("label['"+ label +"'] textarea")
        ));
        customRequestElement.sendKeys(text);
    }

    public void selectCompanyMaintain(){
        selectButton("singapore-apply-form-next");
        selectButton("one_time_change_standard_company_resolutions");
        selectButton("appointment_of_director_1_member");
        selectButton("resignation_director");
        selectButton("share_capital_increase");
        selectButton("share_transfer");
        selectButton("additional_kyc_kyb_per_member_business");
        selectButton("change_business_activities_on_business_register");
        selectButton("registration_brand_name_and_update_business_register");
        selectButton("change_company_name");
        selectButton("12_month_of_unlimited_mail_scan_services");
        selectButton("company_chop_seal");
        selectButton("courier_dispatch_service");
        sendCustomRequest("courier_dispatch_service", "Text");
        selectButton("custom_request");
        sendCustomRequest("custom_request", "Text");
        selectButton("singapore-apply-form-next");
    }
}
