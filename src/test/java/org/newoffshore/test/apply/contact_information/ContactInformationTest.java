package org.newoffshore.test.apply.contact_information;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ContactInformationTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(ConfigReader.getUrlOffer());
        driver.navigate().refresh();
    }

    @Test
    public void validateStep1() throws InterruptedException {
        ContactInformation contactInformationPage = new ContactInformation(driver);

        contactInformationPage.setFullnameInput("Nhat Huy");
        Thread.sleep(1000);
        contactInformationPage.setEmailInput("huydt04082003@gmail.com");
        Thread.sleep(1000);
        contactInformationPage.setPhoneInput(2015550123);
        Thread.sleep(1000);
        contactInformationPage.setBusinessDescription("Tourism");
        Thread.sleep(1000);
        contactInformationPage.clickNext();
        Thread.sleep(1000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
