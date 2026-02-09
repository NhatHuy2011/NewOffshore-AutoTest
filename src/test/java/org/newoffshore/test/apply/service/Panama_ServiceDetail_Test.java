package org.newoffshore.test.apply.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.panama.*;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Panama_ServiceDetail_Test {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(ConfigReader.getUrlOffer(Constant.PANAMA));
        driver.navigate().refresh();
    }

    //Form A Company
    @Test
    public void selectFormACompany(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Panama_GroupOfService panamaGroupOfService = new Panama_GroupOfService(driver);
        panamaGroupOfService.selectGroupFormACompany();

        Panama_FormACompany_Service panamaFormACompanyService = new Panama_FormACompany_Service(driver);
        panamaFormACompanyService.selectIncorp();
    }

    //Transfer In
    @Test
    public void selectTransferIn(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Panama_GroupOfService panamaGroupOfService = new Panama_GroupOfService(driver);
        panamaGroupOfService.selectGroupTransferIn();

        Panama_TransferIn_Service panamaTransferInService = new Panama_TransferIn_Service(driver);
        panamaTransferInService.selectTransferIn();
    }

    //Company Maintenance
    @Test
    public void selectCompanyMaintenance(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Panama_GroupOfService panamaGroupOfService = new Panama_GroupOfService(driver);
        panamaGroupOfService.selectGroupCompanyMaintenance();

        Panama_CompanyMaintenance_Service panamaCompanyMaintenanceService = new Panama_CompanyMaintenance_Service(driver);
        panamaCompanyMaintenanceService.selectCompanyMaintenance();
    }

    //Nominee Service
    @Test
    public void selectNomineeService(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Panama_GroupOfService panamaGroupOfService = new Panama_GroupOfService(driver);
        panamaGroupOfService.selectGroupNomineeService();

        Panama_Nominee_Service panamaNomineeService = new Panama_Nominee_Service(driver);
        panamaNomineeService.selectNomineeService();
    }

    //Close Company
    @Test
    public void selectCloseCompany(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Panama_GroupOfService panamaGroupOfService = new Panama_GroupOfService(driver);
        panamaGroupOfService.selectGroupCloseCompany();

        Panama_CloseCompany_Service panamaCloseCompanyService = new Panama_CloseCompany_Service(driver);
        panamaCloseCompanyService.selectCloseCompany();
    }

    //Restore Company
    @Test
    public void selectRestoreCompany(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Panama_GroupOfService panamaGroupOfService = new Panama_GroupOfService(driver);
        panamaGroupOfService.selectGroupCompanyRestoration();

        Panama_RestoreCompany_Service panamaRestoreCompanyService = new Panama_RestoreCompany_Service(driver);
        panamaRestoreCompanyService.selectRestoreCompany();
    }

    //Business Banking
    @Test
    public void selectBusinessBankingCompany(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Panama_GroupOfService panamaGroupOfService = new Panama_GroupOfService(driver);
        panamaGroupOfService.selectGroupBusinessBank();

        Panama_BusinessBanking_Service panamaBusinessBankingService = new Panama_BusinessBanking_Service(driver);
        panamaBusinessBankingService.selectBusinessBanking();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
