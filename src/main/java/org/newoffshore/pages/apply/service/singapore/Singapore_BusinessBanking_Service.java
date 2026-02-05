package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_BusinessBanking_Service extends BasePage {
    public Singapore_BusinessBanking_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectBusinessBanking(){
        selectButton("digital");
        selectButton("traditional");
        selectButton("payment_gateway");
        selectButton("singapore-apply-form-next");
    }
}
