package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_BusinessBanking_Service {
    private final WebDriver driver;

    public Singapore_BusinessBanking_Service(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectBusinessBanking(){
        selectButton("digital");
        selectButton("traditional");
        selectButton("payment_gateway");
        selectButton("singapore-apply-form-next");
    }
}
