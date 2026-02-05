package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_FormACompany_Service extends BasePage {
    public Singapore_FormACompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
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
