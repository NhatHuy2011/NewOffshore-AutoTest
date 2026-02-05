package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_BusinessBanking_Service extends BasePage {
    public Panama_BusinessBanking_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectBusinessBanking(){
        selectButton("pa_digital");
        selectButton("pa_traditional");
        selectButton("singapore-apply-form-next");
    }
}
