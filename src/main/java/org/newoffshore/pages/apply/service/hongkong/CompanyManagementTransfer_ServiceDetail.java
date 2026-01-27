package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyManagementTransfer_ServiceDetail {
    private final WebDriverWait wait;

    private final WebDriver driver;

    public CompanyManagementTransfer_ServiceDetail(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    private final By termOKButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectTerm() throws InterruptedException {
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(termOKButton));
        termElement.click();
        Thread.sleep(2000);
    }

    public void selectButton(String id) throws InterruptedException {
//        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
//        buttonElement.click();
        driver.findElement(By.id(id)).click();
        Thread.sleep(2000);
    }

//    public void selectCompanyManagementTransfer_No_Accounting(){
//        selectTerm();
//        selectButton("singapore-apply-form-next");
//        selectTerm();
//        selectButton("no_skip_this_option");
//        selectButton("singapore-apply-form-next");
//    }

    public void selectCompanyManagementTransfer_Has_Accounting() throws InterruptedException {
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
