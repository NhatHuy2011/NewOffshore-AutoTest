package org.newoffshore.pages.apply.service.hongkong;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HongKong_BusinessBank_Service extends BasePage {
    public HongKong_BusinessBank_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectBusinessBank(){
        selectButton("digital");
        selectButton("traditional");
        selectButton("payment_gateway");
        selectButton("singapore-apply-form-next");
    }
}
