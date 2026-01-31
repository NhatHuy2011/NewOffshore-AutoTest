package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_FormACompany_Service {
    private final WebDriverWait wait;

    public Singapore_FormACompany_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectIncorp_For_Local(){
        selectButton("yes_local_director_for_incorporation");
        selectButton("singapore-apply-form-next");
    }

    public void selectIncorp_For_NoLocal(){
        selectButton("no_local_director_for_incorporation");
        selectButton("singapore-apply-form-next");
        selectButton("yes_2_foreign_directors");
        selectButton("singapore-apply-form-next");
        selectButton("standard_compliance");
        selectButton("51_200");
        selectButton("singapore-apply-form-next");
    }
}
