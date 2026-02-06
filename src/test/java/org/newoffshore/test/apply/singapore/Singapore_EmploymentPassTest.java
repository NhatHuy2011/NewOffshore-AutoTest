package org.newoffshore.test.apply.singapore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.applicant_information.DependentPass_ApplicantInformation;
import org.newoffshore.pages.apply.applicant_information.EmploymentPass_ApplicantInformation;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.Singapore_EmploymentPass_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Singapore_EmploymentPassTest {
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
    public void selectEmploymentPass(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupEmploymentPass();

        Singapore_EmploymentPass_Service singaporeEmploymentPassService = new Singapore_EmploymentPass_Service(driver);
        singaporeEmploymentPassService.selectEmploymentPass();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        EmploymentPass_ApplicantInformation employmentPassApplicantInformation = new EmploymentPass_ApplicantInformation(driver);
        employmentPassApplicantInformation.fillEmploymentPass();
    }

    @Test
    public void selectDependentPass(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupEmploymentPass();

        Singapore_EmploymentPass_Service singaporeEmploymentPassService = new Singapore_EmploymentPass_Service(driver);
        singaporeEmploymentPassService.selectDependantPass();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentNotSelectMethod();

        DependentPass_ApplicantInformation dependentPassApplicantInformation = new DependentPass_ApplicantInformation(driver);
        dependentPassApplicantInformation.fillDependentPass();
    }
}
