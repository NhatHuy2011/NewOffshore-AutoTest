package org.newoffshore.test.apply.service.singapore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.pages.apply.contact.ContactInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.*;
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
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupFormACompany();

        FormACompany formACompany = new FormACompany(driver);
        formACompany.selectIncorp_For_Local();
    }

    @Test
    public void selectIncorp_For_NoLocal() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupFormACompany();

        FormACompany formACompany = new FormACompany(driver);
        formACompany.selectIncorp_For_NoLocal();
    }

    //Company Management Transfer
    @Test
    public void selectTransfer_For_Local_NoAccounting(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCompanyManagementTransfer();

        CompanyManagementTransfer companyManagementTransfer = new CompanyManagementTransfer(driver);
        companyManagementTransfer.selectTransfer_For_Local_NoAccounting();
    }

    @Test
    public void selectTransfer_For_Local_HasAccounting() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCompanyManagementTransfer();

        CompanyManagementTransfer companyManagementTransfer = new CompanyManagementTransfer(driver);
        companyManagementTransfer.selectTransfer_For_Local_HasAccounting();
    }

    @Test
    public void selectTransfer_For_NoLocal(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCompanyManagementTransfer();

        CompanyManagementTransfer companyManagementTransfer = new CompanyManagementTransfer(driver);
        companyManagementTransfer.selectTransfer_For_NoLocal();
    }

    //Company Maintenance
    @Test
    public void selectMaintain_For_Local_NoAccounting(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCompanyMaintainance();

        CompanyMaintenance companyMaintenance = new CompanyMaintenance(driver);
        companyMaintenance.selectMaintain_For_Local_NoAccounting();
    }

    //Nominee Directorship
    @Test
    public void selectNomineeDirectorship(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupNomineeDirectorship();

        NomineeDirectorship nomineeDirectorship = new NomineeDirectorship(driver);
        nomineeDirectorship.selectNomineeDirectorship();
    }

    //Accounting
    @Test
    public void selectAccouting(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupAccounting();

        Accounting accounting = new Accounting(driver);
        accounting.selectAccouting();
    }

    //Business Banking
    @Test
    public void selectBusinessBanking(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupBusinessBank();

        BusinessBanking businessBanking = new BusinessBanking(driver);
        businessBanking.selectBusinessBanking();
    }

    //Employment Pass
    @Test
    public void selectEmploymentPass(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupEmploymentPass();

        EmploymentPass employmentPass = new EmploymentPass(driver);
        employmentPass.selectEmploymentPass();
    }

    @Test
    public void selectDependantPass(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupEmploymentPass();

        EmploymentPass employmentPass = new EmploymentPass(driver);
        employmentPass.selectDependantPass();
    }

    //Commercial Contract
    @Test
    public void selectCommercialContract_Custom(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCommercialContract();

        CommercialContract commercialContract = new CommercialContract(driver);
        commercialContract.selectCommercialContract_Custom();
    }

    @Test
    public void selectCommercialContract_Templates(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCommercialContract();

        CommercialContract commercialContract = new CommercialContract(driver);
        commercialContract.selectCommercialContract_Templates();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
