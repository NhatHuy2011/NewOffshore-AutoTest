package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.apply.contact.ContactInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormCompany {
    private final WebDriver driver;

    public FormCompany(WebDriver driver) {
        this.driver = driver;
    }

    private final By singaporeApplyNextButton = By.id("singapore-apply-form-next");

    public void clickSingaporeApplyNextButton(){
        driver.findElement(singaporeApplyNextButton).click();
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectGroupFormACompany() throws InterruptedException {
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Select Button Checkout
        SelectServiceStep1 selectServiceStep1 = new SelectServiceStep1(driver);
        selectServiceStep1.clickCheckoutButton();
        selectServiceStep1.clickSingaporeApplyNextButton();

        //Select Group Form A Company
        SelectServiceStep2 selectServiceStep2 = new SelectServiceStep2(driver);
        selectServiceStep2.selectGroupService("form_a_company");
        selectServiceStep1.clickSingaporeApplyNextButton();
    }
}
