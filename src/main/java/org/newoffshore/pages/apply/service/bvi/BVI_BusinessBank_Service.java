package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_BusinessBank_Service extends BasePage {
    public BVI_BusinessBank_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectBusinessBankService(){
        selectButton("vg_digital");
        selectButton("vg_traditional");
        selectButton("singapore-apply-form-next");
    }
}
