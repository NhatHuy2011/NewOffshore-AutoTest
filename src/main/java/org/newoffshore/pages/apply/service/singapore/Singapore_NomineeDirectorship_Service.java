package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_NomineeDirectorship_Service {
    private final WebDriver driver;

    public Singapore_NomineeDirectorship_Service(WebDriver driver) {
        this.driver = driver;
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectTerm(){
        driver.findElement(okTermButton).click();
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
