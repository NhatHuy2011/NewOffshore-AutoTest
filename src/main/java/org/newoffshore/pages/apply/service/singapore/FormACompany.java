package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormACompany {
    private final WebDriver driver;

    public FormACompany(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
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
