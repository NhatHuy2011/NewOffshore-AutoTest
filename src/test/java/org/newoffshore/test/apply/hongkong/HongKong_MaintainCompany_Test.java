package org.newoffshore.test.apply.hongkong;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.company_information.order_addons.hongkong.HongKong_MaintainCompany_Step5;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.hongkong.HongKong_CompanyMaintain_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HongKong_MaintainCompany_Test {
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

    @Test
    public void testStep5HongKong() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupCompanyMaintenance();

        HongKong_CompanyMaintain_Service companyMaintainServiceDetail = new HongKong_CompanyMaintain_Service(driver);
        companyMaintainServiceDetail.selectCompanyMaintain();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompanyAndNext();

        HongKong_MaintainCompany_Step5 hongKongStep5 = new HongKong_MaintainCompany_Step5(driver);
        hongKongStep5.setHongKongMaintainCompanyStep5();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
