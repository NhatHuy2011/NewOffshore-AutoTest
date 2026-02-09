package org.newoffshore.pages.apply.service.usa;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class USA_CompanyMaintenance_Service extends BasePage {
    public USA_CompanyMaintenance_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for='"+ label +"'] textarea"), text);
    }

    public void selectCompanyMaintenance(){
        selectButton("certificate_good_standing_short_form");
        selectButton("certified_true_copy_1_company_document_by_cpa");
        selectButton("apostille_of_1_company_document");
        selectButton("expedite_service_of_company_document");
        selectButton("certified_true_copy_1_company_certificate_by_secretary_of_state");
        selectButton("expedite_1_day_service_of_company_document");
        //selectButton("preparing_change_member_documents_and_filing_article_of_amendment");
        //selectButton("additional_member_compliance_for_llc_structure_change");
        selectButton("expedite_service_of_company_certificate");
        selectButton("expedite_1_day_service_of_company_certificate");
        selectButton("custom_amendments_to_operating_agreements");
        sendCustomRequest("custom_amendments_to_operating_agreements", "Text");
        selectButton("singapore-apply-form-next");
    }
}
