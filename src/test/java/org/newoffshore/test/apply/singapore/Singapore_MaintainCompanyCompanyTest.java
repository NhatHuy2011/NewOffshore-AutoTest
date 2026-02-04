package org.newoffshore.test.apply.singapore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newoffshore.constant.Constant;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.company_information.order_addons.singapore.MaintainCompany_CompanyInfo;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.member_information.order_addons.singapore.MaintainCompany_MemberInfo;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.Singapore_CompanyMaintenance_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Singapore_MaintainCompanyCompanyTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());

        Cookie userSession = new Cookie(ConfigReader.getCookiesAccessTọkenName(), ConfigReader.getCookiesAccessTọkenValue());

        driver.manage().addCookie(userSession);

        driver.get("https://global-offshore.org/en/singapore/company-info/OD_4FTG9PY");
        driver.navigate().refresh();
    }

    //Maintain Company
    @Test
    public void selectMaintain_For_Local_NoAccounting() throws InterruptedException {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
        singaporeGroupOfService.selectGroupCompanyMaintenance();

        Singapore_CompanyMaintenance_Service companyMaintenanceServiceDetail = new Singapore_CompanyMaintenance_Service(driver);
        companyMaintenanceServiceDetail.selectMaintain_For_Local_NoAccounting();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        //Select Company
        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompany("The One Digi Singapore");

        //Fill Company Info
        MaintainCompany_CompanyInfo maintainCompanyCompanyInfo = new MaintainCompany_CompanyInfo(driver);
        maintainCompanyCompanyInfo.setCompanyInfoChangeMaintain();
    }

    @Test
    public void testCompanyMember() throws InterruptedException {
        //Select Company
        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompany("The One Digi Singapore");

        //Fill Company Info
        MaintainCompany_CompanyInfo maintainCompanyCompanyInfo = new MaintainCompany_CompanyInfo(driver);
        maintainCompanyCompanyInfo.setCompanyInfoChangeMaintain();

        //Fill Company Member
        MaintainCompany_MemberInfo maintainCompanyMemberInfo = new MaintainCompany_MemberInfo(driver);
        maintainCompanyMemberInfo.setCompanyMemberChange();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
