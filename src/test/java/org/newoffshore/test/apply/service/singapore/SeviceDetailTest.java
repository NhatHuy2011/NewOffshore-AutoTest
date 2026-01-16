package org.newoffshore.test.apply.service.singapore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.pages.apply.service.singapore.ServiceDetail;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeviceDetailTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(ConfigReader.getUrlOffer());
        driver.navigate().refresh();
    }

    //Form A Company
    @Test
    public void selectIncorp_For_Local() {
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupFormACompany();

        serviceDetail.selectButton("yes_local_director_for_incorporation");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    @Test
    public void selectIncorp_For_NoLocal() {
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupFormACompany();

        serviceDetail.selectButton("no_local_director_for_incorporation");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("yes_2_foreign_directors");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("standard_compliance");
        serviceDetail.selectButton("51_200");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    //Company Management Transfer
    @Test
    public void selectTransfer_For_Local_NoAccounting(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupCompanyManagementTransfer();

        serviceDetail.selectButton("yes_local_director_for_switch");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("no_use_accounting_service");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    @Test
    public void selectTransfer_For_Local_HasAccounting() {
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupCompanyManagementTransfer();

        serviceDetail.selectButton("yes_local_director_for_switch");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("yes_use_accounting_service");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("standard_compliance");
        serviceDetail.selectButton("51_200");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    @Test
    public void selectTransfer_For_NoLocal(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupCompanyManagementTransfer();

        serviceDetail.selectButton("no_local_director_for_switch");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("1_foreign_director");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("switch_1_director_2_shareholder");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("standard_compliance");
        serviceDetail.selectButton("51_200");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    //Company Maintenance
    @Test
    public void selectMaintain_For_Local_NoAccounting(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupCompanyMaintainance();

        serviceDetail.selectButton("yes_local_director_for_renew");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("appointment_director");
        serviceDetail.selectButton("resignation_director");
        serviceDetail.selectButton("appointment_auditor");
        serviceDetail.selectButton("resignation_auditor");
        serviceDetail.selectButton("update_director_shareholder_information");
        serviceDetail.selectButton("change_business_activity");
        serviceDetail.selectButton("change_company_name");
        serviceDetail.selectButton("change_office_address");
        serviceDetail.selectButton("increase_share_capital");
        serviceDetail.selectButton("transfer_shares");
        serviceDetail.selectButton("extra_kyc_requirement");
        serviceDetail.selectButton("custom_request");
        serviceDetail.sendKeyCustomRequestMaintain("Test");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("close_company");
        serviceDetail.selectCancel();
        serviceDetail.selectButton("restore_company");
        serviceDetail.selectCancel();
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    //Nominee Directorship
    @Test
    public void selectNomineeDirectorship(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupNomineeDirectorship();

        serviceDetail.selectButton("physical_bank_visit");
        serviceDetail.selectButton("sing_pass_auth");
        serviceDetail.selectButton("nominee_director_signature");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("standard_compliance");
        serviceDetail.selectButton("51_200");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    //Accounting
    @Test
    public void selectAccouting(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupAccounting();

        serviceDetail.selectButton("standard_compliance");
        serviceDetail.selectButton("51_200");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    //Business Banking
    @Test
    public void selectBusinessBanking(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupBusinessBank();

        serviceDetail.selectButton("digital");
        serviceDetail.selectButton("traditional");
        serviceDetail.selectButton("payment_gateway");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    //Employment Pass
    @Test
    public void selectEmploymentPass(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupEmploymentPass();

        serviceDetail.selectButton("employment_pass_for_owner_company");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("rmi_degree_verification");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    @Test
    public void selectDependantPass(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupEmploymentPass();

        serviceDetail.selectButton("dependent_pass_for_family_bundle");
        serviceDetail.selectCancel();
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    //Commercial Contract
    @Test
    public void selectCommercialContract_Custom() throws InterruptedException {
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupCommercialContract();

        serviceDetail.selectButton("drafting_and_review_custom_contract");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectOptionContractCustom();
        serviceDetail.sendKeyContractCustom("Test");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    @Test
    public void selectCommercialContract_Templates(){
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupCommercialContract();

        serviceDetail.selectButton("specific_commercial_contract_templates");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("sales_purchase_agreement");
        serviceDetail.selectButton("distribution_reseller_agreement");
        serviceDetail.selectButton("supply_agreement");
        serviceDetail.selectButton("agency_agreement");
        serviceDetail.selectButton("singapore-apply-form-next");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
