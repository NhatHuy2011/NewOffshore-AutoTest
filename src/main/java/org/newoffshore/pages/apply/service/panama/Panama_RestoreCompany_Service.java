package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_RestoreCompany_Service extends BasePage {
    public Panama_RestoreCompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for = '" + label + "'] textarea"), text);
    }

    public void selectRestoreCompany(){
        selectButton("struck_off_status_less_6_months");
        sendCustomRequest("struck_off_status_less_6_months", "Test");
        selectButton("singapore-apply-form-next");
    }
}
