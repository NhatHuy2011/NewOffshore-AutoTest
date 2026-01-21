package org.newoffshore.test.apply.singapore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.CompanyDocument;
import org.newoffshore.pages.apply.company_information.CompanyInformation;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.member_information.DirectorInformation;
import org.newoffshore.pages.apply.member_information.ShareHolderInformation;
import org.newoffshore.pages.apply.member_information.UBOInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.CompanyManagementTransfer_ServiceDetail;
import org.newoffshore.pages.apply.service.singapore.GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CompanyManagementTransferTest {
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

    @Test
    public void selectTransfer_For_Local_HasAccounting() throws InterruptedException {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOutButton();
        speakAndCheckout.selectNextButton();

        //Select Group Of Service
        GroupOfService groupOfService = new GroupOfService(driver);
        groupOfService.selectGroupCompanyManagementTransfer();

        CompanyManagementTransfer_ServiceDetail companyManagementTransferServiceDetail = new CompanyManagementTransfer_ServiceDetail(driver);
        companyManagementTransferServiceDetail.selectTransfer_For_Local_HasAccounting();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        //Fill Company Information
        CompanyDocument companyDocument = new CompanyDocument(driver);
        companyDocument.fillCompanyDocument();

        //Member Information
        DirectorInformation directorInformation = new DirectorInformation(driver);
        directorInformation.fillDirectorInformation();
        ShareHolderInformation shareHolderInformation = new ShareHolderInformation(driver);
        shareHolderInformation.fillShareHolderInformation();
        UBOInformation uboInformation = new UBOInformation(driver);
        uboInformation.fillUBOInformation();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
