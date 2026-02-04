package org.newoffshore.test.apply.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.*;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Singapore_SeviceDetailTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(ConfigReader.getUrlOffer(Constant.SINGAPORE));
        driver.navigate().refresh();
    }

    //Form A Company
    @Test
    public void selectIncorp_For_Local() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupFormACompany();

        Singapore_FormACompany_Service formACompanyServiceDetail = new Singapore_FormACompany_Service(driver);
        formACompanyServiceDetail.selectIncorp_For_Local();
    }

    @Test
    public void selectIncorp_For_NoLocal() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupFormACompany();

        Singapore_FormACompany_Service formACompanyServiceDetail = new Singapore_FormACompany_Service(driver);
        formACompanyServiceDetail.selectIncorp_For_NoLocal();
    }

    //Company Management Transfer
    @Test
    public void selectTransfer_For_Local_NoAccounting(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupCompanyManagementTransfer();

        Singapore_CompanyManagementTransfer_Service companyManagementTransferServiceDetail = new Singapore_CompanyManagementTransfer_Service(driver);
        companyManagementTransferServiceDetail.selectTransfer_For_Local_NoAccounting();
    }

    @Test
    public void selectTransfer_For_Local_HasAccounting() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupCompanyManagementTransfer();

        Singapore_CompanyManagementTransfer_Service companyManagementTransferServiceDetail = new Singapore_CompanyManagementTransfer_Service(driver);
        companyManagementTransferServiceDetail.selectTransfer_For_Local_HasAccounting();
    }

    @Test
    public void selectTransfer_For_NoLocal(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupCompanyManagementTransfer();

        Singapore_CompanyManagementTransfer_Service companyManagementTransferServiceDetail = new Singapore_CompanyManagementTransfer_Service(driver);
        companyManagementTransferServiceDetail.selectTransfer_For_NoLocal();
    }

    //Company Maintenance
    @Test
    public void selectMaintain_For_Local_NoAccounting(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupCompanyMaintenance();

        Singapore_CompanyMaintenance_Service companyMaintenanceServiceDetail = new Singapore_CompanyMaintenance_Service(driver);
        companyMaintenanceServiceDetail.selectMaintain_For_Local_NoAccounting();
    }

    //Nominee Directorship
    @Test
    public void selectNomineeDirectorship(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupNomineeDirectorship();

        Singapore_NomineeDirectorship_Service nomineeDirectorshipServiceDetail = new Singapore_NomineeDirectorship_Service(driver);
        nomineeDirectorshipServiceDetail.selectNomineeDirectorship();
    }

    //Accounting
    @Test
    public void selectAccouting(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupAccounting();

        Singapore_Accounting_Service accountingServiceDetail = new Singapore_Accounting_Service(driver);
        accountingServiceDetail.selectAccouting();
    }

    //Business Banking
    @Test
    public void selectBusinessBanking(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupBusinessBank();

        Singapore_BusinessBanking_Service businessBankingServiceDetail = new Singapore_BusinessBanking_Service(driver);
        businessBankingServiceDetail.selectBusinessBanking();
    }

    //Employment Pass
    @Test
    public void selectEmploymentPass(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupEmploymentPass();

        Singapore_EmploymentPass_Service employmentPassServiceDetail = new Singapore_EmploymentPass_Service(driver);
        employmentPassServiceDetail.selectEmploymentPass();
    }

    @Test
    public void selectDependantPass(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupEmploymentPass();

        Singapore_EmploymentPass_Service employmentPassServiceDetail = new Singapore_EmploymentPass_Service(driver);
        employmentPassServiceDetail.selectDependantPass();
    }

    //Commercial Contract
    @Test
    public void selectCommercialContract_Custom(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupCommercialContract();

        Singapore_CommercialContract_Service commercialContractServiceDetail = new Singapore_CommercialContract_Service(driver);
        commercialContractServiceDetail.selectCommercialContract_Custom();
    }

    @Test
    public void selectCommercialContract_Templates(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupCommercialContract();

        Singapore_CommercialContract_Service commercialContractServiceDetail = new Singapore_CommercialContract_Service(driver);
        commercialContractServiceDetail.selectCommercialContract_Templates();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
