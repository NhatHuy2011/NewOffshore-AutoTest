package org.newoffshore.pages.apply.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactInformation {
    private final WebDriver driver;

    public ContactInformation(WebDriver driver) {
        this.driver = driver;
    }

    private final By fullnameInput = By.name("full_name");
    private final By emailInput = By.name("email");
    private final By phoneInput = By.cssSelector("input[data-intl-tel-input-id='0']");
    private final By businessDescriptionTextArea = By.name("business_description");
    private final By nextButton = By.xpath("//button[normalize-space()='Next']");

    public void setFullnameInput(String fullname){
        driver.findElement(fullnameInput).sendKeys(fullname);
    }

    public void setEmailInput(String email){
        WebElement emailInPut = driver.findElement(emailInput);
        emailInPut.sendKeys(Keys.CONTROL + "a");
        emailInPut.sendKeys(Keys.DELETE);
        emailInPut.sendKeys(email);
    }

    public void setPhoneInput(int phone){
        driver.findElement(phoneInput).sendKeys(String.valueOf(phone));
    }

    public void setBusinessDescription(String businessDescription){
        driver.findElement(businessDescriptionTextArea).sendKeys(businessDescription);
    }

    public void clickNext(){
        driver.findElement(nextButton).click();
    }

    public void runContact() {
        ContactInformation contactInformationPage = new ContactInformation(driver);

        contactInformationPage.setFullnameInput("Nhat Huy");
        contactInformationPage.setEmailInput("nhathuy20110408@gmail.com");
        contactInformationPage.setPhoneInput(2015550123);
        contactInformationPage.setBusinessDescription("Tourism");
        contactInformationPage.clickNext();
    }
}
