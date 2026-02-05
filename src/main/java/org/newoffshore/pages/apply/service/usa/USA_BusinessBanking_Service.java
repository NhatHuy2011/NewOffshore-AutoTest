package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_BusinessBanking_Service extends BasePage {
    public USA_BusinessBanking_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectBusinessBanking(){
        selectButton("us_digital");
        selectButton("us_traditional");
        selectButton("us_payment_acceptance");
        selectButton("singapore-apply-form-next");
    }
}
