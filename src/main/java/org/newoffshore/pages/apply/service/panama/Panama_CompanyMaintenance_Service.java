package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_CompanyMaintenance_Service extends BasePage {
    public Panama_CompanyMaintenance_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for = '" + label + "'] textarea"), text);
    }

    public void selectCompanyMaintenance(){
        selectButton("local_panama_nominee_director");
        selectButton("custom_amendment_to_company_m_and_a");
        sendCustomRequest("custom_amendment_to_company_m_and_a", "Test");
        selectButton("increase_of_authorized_capitals");
        selectButton("courier_dispatch_services");
        sendCustomRequest("courier_dispatch_services", "Test");
        selectButton("pa_custom_request");
        sendCustomRequest("pa_custom_request", "Test");
        selectButton("certificate_of_good_standing_without_apostilled");
        selectButton("certificate_of_good_standing_apostilled_by_registry");
        selectButton("certificate_of_incumbency_without_apostille");
        selectButton("certificate_of_incumbency_apostilled_notarised");
        selectButton("apostilled_notarised_per_company_document");
        selectButton("certified_true_copy_of_1_company_certificate_by_the_registry");
        selectButton("certified_true_copy_of_1_company_document_by_register_agent");
        selectButton("certified_true_copy_of_1_company_document_by_cpa");
        selectButton("change_of_director_filling_amendment_to_articles_of_incorportions_apostilled_certified");
        selectButton("change_of_director_filling_amendment_to_articles_of_incorportions_without_apostilled");
        selectButton("change_of_shareholder_filling_amendment_to_articles_of_incorportions_apostilled_certified");
        selectButton("change_of_shareholder_filling_amendment_to_articles_of_incorportions_without_apostilled");
        selectButton("change_of_ubo_filling_amendment_to_articles_of_incorportions_without_apostilled");
        selectButton("additional_member_compliance_for_company_structure_change");
        selectButton("update_m_and_a_without_apostilled");
        selectButton("update_article_of_incorporations_without_apostilled");
        selectButton("update_article_of_incorporation_with_apostilled");
        selectButton("singapore-apply-form-next");
    }
}
