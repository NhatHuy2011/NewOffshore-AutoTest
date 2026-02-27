package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_RestoreCompany_Service extends BasePage {
    public BVI_RestoreCompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for = '" + label + "'] textarea"), text);
    }

    public void selectRestoreCompanyService(){
        selectButton("restoration_filing_fee");
        sendCustomRequest("restoration_filing_fee", "Text");
        selectButton("singapore-apply-form-next");
    }
}
