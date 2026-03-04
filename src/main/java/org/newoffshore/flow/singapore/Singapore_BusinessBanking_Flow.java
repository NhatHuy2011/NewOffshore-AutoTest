package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.Singapore_BusinessBanking_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Singapore_BusinessBanking_Flow {
    private WebDriver driver;

    public void run(){
        driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(ConfigReader.getUrl());

            Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

            driver.manage().addCookie(userSession);

            driver.get(ConfigReader.getUrlOffer(Constant.SINGAPORE));
            driver.navigate().refresh();

            selectBusinessBanking();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    public void selectBusinessBanking(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupBusinessBank();

        Singapore_BusinessBanking_Service businessBankingServiceDetail = new Singapore_BusinessBanking_Service(driver);
        businessBankingServiceDetail.selectBusinessBanking();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        //Select Company
        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompanyAndNext("The One Digi Singapore");
    }
}
