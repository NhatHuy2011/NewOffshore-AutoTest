package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_CompanyMaintenance_Service {
    private final WebDriverWait wait;

    public Singapore_CompanyMaintenance_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By customRequestTextArea = By.xpath("//textarea[@data-slot='textarea' and @placeholder='Please enter a description here']");

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void sendKeyCustomRequestMaintain(String text){
        WebElement customRequestElement = wait.until(ExpectedConditions.elementToBeClickable(customRequestTextArea));
        customRequestElement.sendKeys(text);
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
