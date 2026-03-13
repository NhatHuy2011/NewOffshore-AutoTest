package org.newoffshore.flow;

import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseFlow {
    protected WebDriver driver;

    public void setUp(String url, String countryUrl){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get(countryUrl);
        driver.navigate().refresh();

        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();
    }

    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
