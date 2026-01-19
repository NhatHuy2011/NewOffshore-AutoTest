package org.newoffshore.pages.apply.member_information.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormACompany_ShareHolderInformation {
    private final WebDriver driver;

    public FormACompany_ShareHolderInformation(WebDriver driver) {
        this.driver = driver;
    }

    private final By typeOfShareHolderButton = By.id("shareholders.0.type");

    private final By fullnameShareHolderInput = By.name("shareholders.0.name");

    private final By emailShareHolderInput = By.name("shareholders.0.email");

    private final By phoneNumberInput = By.xpath(
            "//div[@id='shareholders.0.phone']//input[@type='tel']"
    );

    private final By shareInput = By.name("shareholders.0.shares");

    private final By passportUploadInput = By.id("shareholders.0.passport_path-upload");

    private final By addressProofUploadInput = By.id("shareholders.0.address_proof_path-upload");

    private final By selfieUploadInput = By.id("shareholders.0.selfie_path-upload");

    private final By nextButton = By.id("company-principals-next");

    public void selectTypeOfShareHolder(String type){
        driver.findElement(typeOfShareHolderButton).click();
        driver.findElement(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='" + type +"']]")).click();
    }

    public void sendKeyFullnameShareHolder(String fullname){
        driver.findElement(fullnameShareHolderInput).sendKeys(fullname);
    }

    public void sendKeyEmailshareholder(String email){
        driver.findElement(emailShareHolderInput).sendKeys(email);
    }

    public void sendKeyPhoneNumbershareholder(String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void sendKeyShare(int share){
        driver.findElement(shareInput).sendKeys(String.valueOf(share));
    }

    public void sendKeyPassportUpload(String path){
        driver.findElement(passportUploadInput).sendKeys(path);
    }

    public void sendKeyAddressProofUpload(String path){
        driver.findElement(addressProofUploadInput).sendKeys(path);
    }

    public void sendKeySelfieImageUpload(String path){
        driver.findElement(selfieUploadInput).sendKeys(path);
    }

    public void selectNextButton(){
        driver.findElement(nextButton).click();
    }

    public void fillShareHolderInformation() throws InterruptedException {
        selectTypeOfShareHolder("Individual");
        sendKeyFullnameShareHolder("Nhat Huy");
        sendKeyEmailshareholder("huydt04082003@gmail.com");
        sendKeyPhoneNumbershareholder("201-555-0123");
        sendKeyShare(10000);
        sendKeyPassportUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        sendKeyAddressProofUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        sendKeySelfieImageUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        Thread.sleep(1000);
        selectNextButton();
    }
}
