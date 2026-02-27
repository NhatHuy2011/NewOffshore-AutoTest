package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_Nominee_Service extends BasePage {
    public BVI_Nominee_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectNomineeService(){
        selectButton("nominee_director");
        selectButton("nominee_shareholder");
        selectButton("signing_documents_by_nominee");
        selectButton("nominee_director_online_id_verification");
        selectButton("professional_reference_of_nominee");
        selectButton("bank_reference_of_nominee");
        selectButton("singapore-apply-form-next");
    }
}
