package org.newoffshore.test.apply.company_information.singapore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.pages.apply.company_information.singapore.FormACompany_CompanyInfo;
import org.newoffshore.pages.apply.member_information.singapore.FormACompany_DirectorInformation;
import org.newoffshore.pages.apply.member_information.singapore.FormACompany_ShareHolderInformation;
import org.newoffshore.pages.apply.member_information.singapore.FormACompany_UBOInformation;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FormACompany_CompanyInfoTest {
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
    public void fillCompanyInformation() throws InterruptedException {
        FormACompany_CompanyInfo formACompanyCompanyInfo = new FormACompany_CompanyInfo(driver);
        formACompanyCompanyInfo.fillCompanyInformation();

        FormACompany_DirectorInformation formACompanyMemberInformation = new FormACompany_DirectorInformation(driver);
        formACompanyMemberInformation.fillDirectorInformation();

        FormACompany_ShareHolderInformation formACompanyShareHolderInformation = new FormACompany_ShareHolderInformation(driver);
        formACompanyShareHolderInformation.fillShareHolderInformation();

        FormACompany_UBOInformation formACompanyUboInformation = new FormACompany_UBOInformation(driver);
        formACompanyUboInformation.fillUBOInformation();
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
