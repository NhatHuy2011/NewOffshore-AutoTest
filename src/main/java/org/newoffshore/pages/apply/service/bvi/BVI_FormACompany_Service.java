package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_FormACompany_Service extends BasePage {
    public BVI_FormACompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectFormACompany(){
        selectButton("dedicated_account_manager_priority_support");
        selectButton("apostilled_notarised_per_company_document_at_incorp");
        selectButton("certified_true_copy_notary_of_kyc_document_by_cpa");
        selectButton("name_approval_of_restricted_word");
        selectButton("vg_name_reservation");
        selectButton("singapore-apply-form-next");
    }
}
