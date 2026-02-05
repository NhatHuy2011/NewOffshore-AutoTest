package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_ReviveCompany_Service extends BasePage {
    public USA_ReviveCompany_Service(WebDriver driver) {
        super(driver);
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectTerm(){
        click(okTermButton);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for='"+ label +"'] textarea"), text);
    }

    public void selectReviveCompany(){
        selectTerm();
        selectButton("us_llc_company_business_address");
        selectButton("us_custom_request");
        sendCustomRequest("us_custom_request", "Test");
        selectButton("singapore-apply-form-next");
    }
}
