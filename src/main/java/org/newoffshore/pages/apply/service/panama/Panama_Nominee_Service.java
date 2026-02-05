package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_Nominee_Service extends BasePage {
    public Panama_Nominee_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for = '" + label + "'] textarea"), text);
    }

    public void selectNomineeService(){
        selectButton("nominee_director_panama_citizen");
        selectButton("nominee_shareholder_panama_citzen");
        selectButton("utility_bill_of_nominee");
        selectButton("bank_reference_from_nominees");
        selectButton("passport_copy_of_nominee_apostilled");
        selectButton("nominee_signature_per_document");
        selectButton("nominee_custom_request");
        sendCustomRequest("nominee_custom_request", "Test");
        selectButton("singapore-apply-form-next");
    }
}
