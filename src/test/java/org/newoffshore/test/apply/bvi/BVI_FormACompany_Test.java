package org.newoffshore.test.apply.bvi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.CompanyInformation;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.member_information.MemberInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.bvi.BVI_FormACompany_Service;
import org.newoffshore.pages.apply.service.bvi.BVI_GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BVI_FormACompany_Test {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(ConfigReader.getUrlOffer(Constant.BVI));
        driver.navigate().refresh();
    }

    @Test
    public void selectFormACompanyService(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Service Detail
        BVI_GroupOfService bviGroupOfService = new BVI_GroupOfService(driver);
        bviGroupOfService.selectGroupFormACompany();

        BVI_FormACompany_Service bviFormACompanyService = new BVI_FormACompany_Service(driver);
        bviFormACompanyService.selectFormACompany();

        //Payment
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        //Company Information
        CompanyInformation companyInformation = new CompanyInformation(driver);
        companyInformation.fillCompanyInformation_BVI();

        //Member Information
        MemberInformation memberInformation = new MemberInformation(driver);
        memberInformation.fillMemberInformation();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
