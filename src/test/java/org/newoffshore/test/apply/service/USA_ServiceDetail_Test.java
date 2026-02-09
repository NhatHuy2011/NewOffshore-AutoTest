package org.newoffshore.test.apply.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.usa.*;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class USA_ServiceDetail_Test {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(ConfigReader.getUrlOffer(Constant.USA));
        driver.navigate().refresh();
    }

    @Test
    public void selectIncorp(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupFormACompany();

        USA_FormACompany_Service usaFormACompanyService = new USA_FormACompany_Service(driver);
        usaFormACompanyService.selectIncorp();
    }

    //Company Management Transfer
    @Test
    public void selectCompanyManagemenTransfer(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupCompanyManagementTransfer();

        USA_CompanyManagementTransfer_Service usaCompanyManagementTransferService = new USA_CompanyManagementTransfer_Service(driver);
        usaCompanyManagementTransferService.selectCompanyManagementTransfer();
    }

    @Test
    public void selectCompanyMaintenance(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupCompanyMaintenance();

        USA_CompanyMaintenance_Service usaCompanyMaintenanceService = new USA_CompanyMaintenance_Service(driver);
        usaCompanyMaintenanceService.selectCompanyMaintenance();
    }

    @Test
    public void selectAccountingService(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupAccounting();

        USA_Accounting_Service usaAccountingService = new USA_Accounting_Service(driver);
        usaAccountingService.selectAccoutingService();
    }

    @Test
    public void selectCloseCompany(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupCloseCompany();

        USA_CloseCompany_Service usaCloseCompanyService = new USA_CloseCompany_Service(driver);
        usaCloseCompanyService.selectCloseCompany();
    }

    @Test
    public void selectReviveCompany(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupReviveCompany();

        USA_ReviveCompany_Service usaReviveCompanyService = new USA_ReviveCompany_Service(driver);
        usaReviveCompanyService.selectReviveCompany();
    }

    @Test
    public void selectBusinessBank(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupBusinessBanking();

        USA_BusinessBanking_Service usaBusinessBankingService = new USA_BusinessBanking_Service(driver);
        usaBusinessBankingService.selectBusinessBanking();
    }

    @Test
    public void selectConversionToDelaware(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        USA_GroupOfService usaGroupOfService = new USA_GroupOfService(driver);
        usaGroupOfService.selectGroupConversionOfUSLLC();

        USA_ConversionToDelaware_Service usaConversionToDelawareService = new USA_ConversionToDelaware_Service(driver);
        usaConversionToDelawareService.selectConversionToDelaware();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
