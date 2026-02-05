package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_ConversionToDelaware_Service extends BasePage {
    public USA_ConversionToDelaware_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectConversionToDelaware(){
        selectButton("singapore-apply-form-next");
    }
}
