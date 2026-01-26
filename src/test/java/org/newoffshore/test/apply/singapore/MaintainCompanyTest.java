package org.newoffshore.test.apply.singapore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.CompanyMaintenance_ServiceDetail;
import org.newoffshore.pages.apply.service.singapore.GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MaintainCompanyTest {
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

    //Maintain Company
    @Test
    public void selectMaintain_For_Local_NoAccounting() throws InterruptedException {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCompanyMaintainance();

        CompanyMaintenance_ServiceDetail companyMaintenanceServiceDetail = new CompanyMaintenance_ServiceDetail(driver);
        companyMaintenanceServiceDetail.selectMaintain_For_Local_NoAccounting();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        //Select Company
        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompany("The One Digi");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
