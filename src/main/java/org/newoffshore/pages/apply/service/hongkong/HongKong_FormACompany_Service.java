package org.newoffshore.pages.apply.service.hongkong;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HongKong_FormACompany_Service extends BasePage {
    public HongKong_FormACompany_Service(WebDriver driver) {
        super(driver);
    }

    private final By termOKButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectTerm(){
        click(termOKButton);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectIncorp_No_Accounting(){
        selectButton("singapore-apply-form-next");
        selectTerm();
        selectButton("no_skip_this_option");
        selectButton("singapore-apply-form-next");
        selectButton("urgent_filing_report_preparation");
        selectButton("employer_return_per_employee");
        selectButton("planning_optimization_advice_via_video_call");
        selectButton("dedicated_accountant_support_via_email_whatsapp");
        selectButton("singapore-apply-form-next");
    }

    public void selectIncorp_Has_Accounting(){
        selectButton("singapore-apply-form-next");
        selectTerm();
        selectButton("yes_include_it");
        selectButton("singapore-apply-form-next");
        selectButton("bookkeeping");
        selectButton("51_200");
        selectButton("singapore-apply-form-next");
        selectButton("revenue_smaller_1_million_hkd");
        selectButton("101_300_transactions");
        selectButton("singapore-apply-form-next");
        selectButton("urgent_filing_report_preparation");
        selectButton("employer_return_per_employee");
        selectButton("planning_optimization_advice_via_video_call");
        selectButton("dedicated_accountant_support_via_email_whatsapp");
        selectButton("singapore-apply-form-next");
    }
}
