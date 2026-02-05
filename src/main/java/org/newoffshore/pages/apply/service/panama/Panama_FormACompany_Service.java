package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_FormACompany_Service extends BasePage {
    public Panama_FormACompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectIncorp(){
        selectButton("extra_nominee_director_position_at_incorp");
        selectButton("dedicated_account_manager_priority_support");
        selectButton("apostilled_of_company_document_at_incorp");
        selectButton("certified_true_copy_notary_of_1_kyc_document");
        selectButton("singapore-apply-form-next");
    }
}
