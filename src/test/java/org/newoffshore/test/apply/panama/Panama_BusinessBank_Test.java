package org.newoffshore.test.apply.panama;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.panama.Panama_BusinessBanking_Service;
import org.newoffshore.pages.apply.service.panama.Panama_GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Panama_BusinessBank_Test {
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

        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompanyAndNext("The One Digi Panama");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
