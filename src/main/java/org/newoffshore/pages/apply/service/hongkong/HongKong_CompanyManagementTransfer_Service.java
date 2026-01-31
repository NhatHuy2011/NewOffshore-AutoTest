package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HongKong_CompanyManagementTransfer_Service {
    private final WebDriverWait wait;

    public HongKong_CompanyManagementTransfer_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By termOKButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectTerm() {
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(termOKButton));
        termElement.click();
    }

    public void selectButton(String id) {
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectCompanyManagementTransfer_No_Accounting() {
        selectTerm();
        selectButton("singapore-apply-form-next");
        selectTerm();
        selectButton("no_skip_this_option");
        selectButton("singapore-apply-form-next");
    }

    public void selectCompanyManagementTransfer_Has_Accounting() {
        selectTerm();
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
    }
}
