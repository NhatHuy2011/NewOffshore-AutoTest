package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_CloseCompany_Service extends BasePage {
    public USA_CloseCompany_Service(WebDriver driver) {
        super(driver);
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectTerm(){
        click(okTermButton);
    }

    public void selectCloseCompany(){
        selectTerm();
        selectButton("standard_certificate_of_cancellation");
        selectButton("singapore-apply-form-next");
    }
}
