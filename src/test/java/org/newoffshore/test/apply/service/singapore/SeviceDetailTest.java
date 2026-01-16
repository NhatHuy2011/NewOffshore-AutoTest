package org.newoffshore.test.apply.service.singapore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.pages.apply.service.singapore.ServiceDetail;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeviceDetailTest {
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
    public void selectIncorpForLocal() throws InterruptedException {
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupFormACompany();

        serviceDetail.selectButton("yes_local_director_for_incorporation");
        //serviceDetail.selectButton("singapore-apply-form-next");
    }

    @Test
    public void selectNoLocalDirector() throws InterruptedException {
        ServiceDetail serviceDetail = new ServiceDetail(driver);
        serviceDetail.selectGroupFormACompany();

        serviceDetail.selectButton("no_local_director_for_incorporation");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("yes_2_foreign_directors");
        serviceDetail.selectButton("singapore-apply-form-next");
        serviceDetail.selectButton("standard_compliance");
        serviceDetail.selectButton("51_200");
        //serviceDetail.selectButton("singapore-apply-form-next");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
