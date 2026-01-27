package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormACompany_ServiceDetail {
    private final WebDriverWait wait;

    public FormACompany_ServiceDetail(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By termOKButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectTerm(){
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(termOKButton));
        termElement.click();
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
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
