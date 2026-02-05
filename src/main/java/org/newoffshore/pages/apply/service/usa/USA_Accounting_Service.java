package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_Accounting_Service extends BasePage {
    public USA_Accounting_Service(WebDriver driver) {
        super(driver);
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectTerm(){
        click(okTermButton);
    }

    public void selectAccoutingService(){
        selectTerm();
        selectButton("standard_annual_compliance_fillings");
        selectButton("singapore-apply-form-next");
    }
}
