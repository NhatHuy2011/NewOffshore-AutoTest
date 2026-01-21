package org.newoffshore.pages.apply.member_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UBOInformation {
    private final WebDriver driver;

    public UBOInformation(WebDriver driver) {
        this.driver = driver;
    }

    private final By fullnameUBOInput = By.name("owners.0.name");

    private final By emailUBOInput = By.name("owners.0.email");

    private final By phoneNumberInput = By.xpath(
            "//div[@id='owners.0.phone']//input[@type='tel']"
    );

    private final By percentageInput = By.name("owners.0.percentage");

    private final By passportUploadInput = By.id("owners.0.passport_path-upload");

    private final By addressProofUploadInput = By.id("owners.0.address_proof_path-upload");

    private final By selfieUploadInput = By.id("owners.0.selfie_path-upload");

    private final By nextButton = By.id("company-principals-next");

    public void sendKeyFullnameUBO(String fullname){
        driver.findElement(fullnameUBOInput).sendKeys(fullname);
    }

    public void sendKeyEmailUBO(String email){
        driver.findElement(emailUBOInput).sendKeys(email);
    }

    public void sendKeyPhoneNumberUBO(String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void sendKeyPercentage(int share){
        driver.findElement(percentageInput).sendKeys(String.valueOf(share));
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

    public void fillUBOInformation() throws InterruptedException {
        sendKeyFullnameUBO("Nhat Huy");
        sendKeyEmailUBO("huydt04082003@gmail.com");
        sendKeyPhoneNumberUBO("201-555-0123");
        sendKeyPercentage(100);
        Thread.sleep(1000);
        sendKeyPassportUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        Thread.sleep(1000);
        sendKeyAddressProofUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        Thread.sleep(1000);
        sendKeySelfieImageUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        Thread.sleep(1000);
        selectNextButton();
    }
}
