package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_Continuation_Discontinuation_Service extends BasePage {
    public BVI_Continuation_Discontinuation_Service(WebDriver driver) {
        super(driver);
    }

    public void sendKeyCustomRequest(String text){
        input(By.xpath("//textarea[@data-slot='form-control' and @placeholder='Please enter a description here']"), text);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectContinuation_Discontinuation_Service(){
        sendKeyCustomRequest("Text");
        selectButton("singapore-apply-form-next");
    }
}
