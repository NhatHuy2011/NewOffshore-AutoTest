package org.newoffshore.test.apply.hongkong;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.company_information.order_addons.hongkong.HongKong_RestoreCompany_Step5;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.hongkong.HongKong_CompanyRestoration_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HongKong_RestoreCompany_Test {
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
    public void selectCompanyRestoration() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
        hongKongGroupOfService.selectGroupCompanyRestoration();

        HongKong_CompanyRestoration_Service companyRestorationServiceDetail = new HongKong_CompanyRestoration_Service(driver);
        companyRestorationServiceDetail.selectCompanyRestoration();

        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentNotSelectMethod();

        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompanyAndNext("The One Digi HongKong");

        HongKong_RestoreCompany_Step5 hongKongRestoreStep5 = new HongKong_RestoreCompany_Step5(driver);
        hongKongRestoreStep5.setHongKongRestoreCompany();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
