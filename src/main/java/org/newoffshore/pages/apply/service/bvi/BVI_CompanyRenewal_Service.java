package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_CompanyRenewal_Service extends BasePage {
    public BVI_CompanyRenewal_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void sendCustomRequest(String label, String text){
        input(By.cssSelector("label[for = '" + label + "'] textarea"), text);
    }

    public void selectCompanyRenewal(){
        selectButton("vg_courier_dispatch_services");
        sendCustomRequest("vg_courier_dispatch_services", "Text");
        selectButton("vg_custom_request");
        sendCustomRequest("vg_custom_request", "Text");
        selectButton("certificate_of_incumbency");
        selectButton("certificate_of_good_standing_digital");
        selectButton("apostille_notarised_of_1_company_document");
        selectButton("notary_of_1_company_document_by_notary_public");
        selectButton("certified_true_copy_of_1_company_document_by_cpa");
        selectButton("certified_true_copy_of_1_company_document_the_registered_agent");
        selectButton("certified_true_copy_of_1_company_certificate_by_the_registry_of_certificates");
        selectButton("certified_true_copy_of_1_company_m_a_by_the_registry_of_m_a_and_registers");
        selectButton("company_seal");
        selectButton("preparing_change_of_director_documents_and_filing_the_updated_rod");
        selectButton("preparing_change_of_shareholder_documents_and_filing_the_updated_rom");
        selectButton("preparing_change_of_ubo_documents_and_filing_the_updated_rob");
        selectButton("package_of_preparing_filling_rod_rom_rob");
        selectButton("additional_member_compliance_for_company_structure_change");
        selectButton("increase_in_authorised_share");
        selectButton("vg_change_of_company_name");
        selectButton("singapore-apply-form-next");
    }
}
