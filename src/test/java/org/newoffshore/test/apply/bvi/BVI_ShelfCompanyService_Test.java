package org.newoffshore.test.apply.bvi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.bvi.BVI_GroupOfService;
import org.newoffshore.pages.apply.service.bvi.BVI_ShelfCompany_Service;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BVI_ShelfCompanyService_Test {
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
    public void selectShelfCompanyService(){
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        BVI_GroupOfService bviGroupOfService = new BVI_GroupOfService(driver);
        bviGroupOfService.selectGroupShelfCompany();

        BVI_ShelfCompany_Service bviShelfCompanyService = new BVI_ShelfCompany_Service(driver);
        bviShelfCompanyService.selectShelfCompanyService();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
