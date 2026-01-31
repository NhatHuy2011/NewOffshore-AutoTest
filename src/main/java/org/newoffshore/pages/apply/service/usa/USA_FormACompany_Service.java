package org.newoffshore.pages.apply.service.usa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class USA_FormACompany_Service {
    private final WebDriverWait wait;

    public USA_FormACompany_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectTerm(){
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(okTermButton));
        termElement.click();
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectIncorp(){
        selectTerm();
        selectButton("delaware");
        selectButton("singapore-apply-form-next");
        selectButton("standard_formation_us_llc_foreigner_delaware");
        selectButton("beneficial_ownership_report");
        selectButton("name_reservation");
        selectButton("us_llc_company_business_address");
        selectButton("federal_ein_registration_foreigner");
        selectButton("singapore-apply-form-next");
    }
}
