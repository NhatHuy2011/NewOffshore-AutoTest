package org.newoffshore.test.apply.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.hongkong.*;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HongKong_ServiceDetailTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(ConfigReader.getUrlOffer(Constant.HONGKONG));
        driver.navigate().refresh();
    }

    //Form A Company
    @Test
    public void selectIncorp_Has_Accounting() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupFormACompany();

        HongKong_FormACompany_Service formACompanyServiceDetail = new HongKong_FormACompany_Service(driver);
        formACompanyServiceDetail.selectIncorp_Has_Accounting();
    }

    //Company Management Transfer
    @Test
    public void selectCompanyManagementTransfer_Has_Accounting() throws InterruptedException {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupAccounting();

        HongKong_CompanyManagementTransfer_Service transferService = new HongKong_CompanyManagementTransfer_Service(driver);
        transferService.selectCompanyManagementTransfer_Has_Accounting();
    }

    //Company Maintenance
    @Test
    public void selectCompanyMaintenance(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupCompanyMaintenance();

        HongKong_CompanyMaintain_Service companyMaintainServiceDetail = new HongKong_CompanyMaintain_Service(driver);
        companyMaintainServiceDetail.selectCompanyMaintain();
    }

    //Company Restoration
    @Test
    public void selectCompanyRestoration(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupCompanyRestoration();

        HongKong_CompanyRestoration_Service companyRestorationServiceDetail = new HongKong_CompanyRestoration_Service(driver);
        companyRestorationServiceDetail.selectCompanyRestoration();
    }

    //Accouting
    @Test
    public void selectAccounting(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupAccounting();

        HongKong_Accounting_Service accountingServiceDetail = new HongKong_Accounting_Service(driver);
        accountingServiceDetail.selectAccounting();
    }

    //Business Bank
    @Test
    public void selectBusinessBank(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupBusinessBank();

        HongKong_BusinessBank_Service businessBankServiceDetail = new HongKong_BusinessBank_Service(driver);
        businessBankServiceDetail.selectBusinessBank();
    }

    //Close Company
    @Test
    public void selectCloseCompany(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupCloseCompany();

        HongKong_CloseCompany_Service closeCompanyServiceDetail = new HongKong_CloseCompany_Service(driver);
        closeCompanyServiceDetail.selectCloseCompany();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
