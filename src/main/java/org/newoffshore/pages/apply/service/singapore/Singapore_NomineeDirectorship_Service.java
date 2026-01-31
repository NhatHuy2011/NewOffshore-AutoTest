package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_NomineeDirectorship_Service {
    private final WebDriverWait wait;

    public Singapore_NomineeDirectorship_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectTerm(){
        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(okTermButton));
        termElement.click();
    }

    public void selectNomineeDirectorship(){
        selectTerm();
        selectButton("physical_bank_visit");
        selectButton("sing_pass_auth");
        selectButton("nominee_director_signature");
        selectButton("singapore-apply-form-next");
        selectButton("standard_compliance");
        selectButton("51_200");
        selectButton("singapore-apply-form-next");
    }
}
