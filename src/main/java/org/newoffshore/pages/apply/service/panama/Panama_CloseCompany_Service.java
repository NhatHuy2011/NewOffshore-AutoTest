package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_CloseCompany_Service extends BasePage {
    public Panama_CloseCompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectCloseCompany(){
        selectButton("apostilled_notarised_per_company_certificate");
        selectButton("singapore-apply-form-next");
    }
}
