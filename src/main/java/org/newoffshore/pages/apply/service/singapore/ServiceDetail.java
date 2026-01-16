package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.apply.contact.ContactInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServiceDetail {
    private final WebDriver driver;

    public ServiceDetail(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectGroupService(String id){
        driver.findElement(By.cssSelector("label[for='"+ id +"']")).click();
    }

    //Select Group Of Service - Form A Company
    public void selectGroupFormACompany() throws InterruptedException {
        //Run Contact
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.runContact();

        //Step 1
        selectButton("check-out");
        selectButton("singapore-apply-form-next");
        selectGroupService("form_a_company");
        selectButton("singapore-apply-form-next");
    }
}
