package org.newoffshore.pages.apply.member_information.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormACompany_DirectorInformation {
    private final WebDriver driver;

    public FormACompany_DirectorInformation(WebDriver driver) {
        this.driver = driver;
    }

    private final By typeOfDirectorButton = By.id("directors.0.type");

    private final By fullnameDirectorInput = By.name("directors.0.name");

    private final By emailDirectorInput = By.name("directors.0.email");

    private final By phoneNumberInput = By.xpath(
            "//div[@id='directors.0.phone']//input[@type='tel']"
    );

    private final By passportUploadInput = By.id("directors.0.passport_path-upload");

    private final By addressProofUploadInput = By.id("directors.0.address_proof_path-upload");

    private final By selfieUploadInput = By.id("directors.0.selfie_path-upload");

    private final By nextButton = By.id("company-principals-next");

    public void selectTypeOfDirector(String type){
        driver.findElement(typeOfDirectorButton).click();
        driver.findElement(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='" + type +"']]")).click();
    }

    public void sendKeyFullnameDirector(String fullname){
        driver.findElement(fullnameDirectorInput).sendKeys(fullname);
    }

    public void sendKeyEmailDirector(String email){
        driver.findElement(emailDirectorInput).sendKeys(email);
    }

    public void sendKeyPhoneNumberDirector(String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
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

    public void fillDirectorInformation() throws InterruptedException {
        selectTypeOfDirector("Individual");
        sendKeyFullnameDirector("Nhat Huy");
        sendKeyEmailDirector("huydt04082003@gmail.com");
        sendKeyPhoneNumberDirector("201-555-0123");
        sendKeyPassportUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        sendKeyAddressProofUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        sendKeySelfieImageUpload("C:\\Users\\Admin\\OneDrive\\Desktop\\avatar.jpg");
        Thread.sleep(1000);
        selectNextButton();
    }
}
