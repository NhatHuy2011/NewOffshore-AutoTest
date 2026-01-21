package org.newoffshore.pages.apply.member_information;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DirectorInformation {
    private final WebDriver driver;

    public DirectorInformation(WebDriver driver) {
        this.driver = driver;
    }

    private final By typeOfDirectorButton = By.id("directors.0.type");

    private final By fullnameDirectorInput = By.name("directors.0.name");

    private final By emailDirectorInput = By.name("directors.0.email");

    private final By phoneNumberInput = By.xpath("//div[@id='directors.0.phone']//input[@type='tel']");

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
        if(path != null && !path.isEmpty()){
            driver.findElement(passportUploadInput).sendKeys(path);
        } else {
            System.out.println("Not Found File Upload");
        }
    }

    public void sendKeyAddressProofUpload(String path){
        if(path != null && !path.isEmpty()){
            driver.findElement(addressProofUploadInput).sendKeys(path);
        }else {
            System.out.println("Not Found File Upload");
        }
    }

    public void sendKeySelfieImageUpload(String path){
        if (path != null && !path.isEmpty()){
            driver.findElement(selfieUploadInput).sendKeys(path);
        }else {
            System.out.println("Not Found File Upload");
        }
    }

    public void selectNextButton(){
        driver.findElement(nextButton).click();
    }

    public void fillDirectorInformation() throws InterruptedException {
        selectTypeOfDirector("Individual");
        sendKeyFullnameDirector("Nhat Huy");
        sendKeyEmailDirector("huydt04082003@gmail.com");
        sendKeyPhoneNumberDirector("201-555-0123");
        Thread.sleep(1000);
        sendKeyPassportUpload("C:\\Users\\Admin\\Downloads\\image1.jpg");
        Thread.sleep(1000);
        sendKeyAddressProofUpload("C:\\Users\\Admin\\Downloads\\image1.jpg");
        Thread.sleep(1000);
        sendKeySelfieImageUpload("C:\\Users\\Admin\\Downloads\\image1.jpg");
        Thread.sleep(1000);
        selectNextButton();
    }
}
