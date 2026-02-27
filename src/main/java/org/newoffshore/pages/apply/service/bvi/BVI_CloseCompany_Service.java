package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_CloseCompany_Service extends BasePage {
    public BVI_CloseCompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for = '" + label + "'] textarea"), text);
    }

    public void selectCloseCompanyService(){
        selectButton("dissolution_internally");
        sendCustomRequest("dissolution_internally", "Text");
        selectButton("singapore-apply-form-next");
    }
}
