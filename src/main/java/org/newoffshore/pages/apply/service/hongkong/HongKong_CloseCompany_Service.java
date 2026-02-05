package org.newoffshore.pages.apply.service.hongkong;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HongKong_CloseCompany_Service extends BasePage {
    public HongKong_CloseCompany_Service(WebDriver driver) {
        super(driver);
    }

    private final By cancelButton = By.xpath("//button[normalize-space() = 'Cancel']");

    private final By textAreaCustom = By.xpath("//textarea[@placeholder = 'Please enter a description here']");

    public void selectCancelButton(){
        click(cancelButton);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendKeyCustomRequest(String text){
        input(textAreaCustom, text);
    }

    public void selectCloseCompany(){
        selectCancelButton();
        sendKeyCustomRequest("Test");
        selectButton("singapore-apply-form-next");
    }
}
