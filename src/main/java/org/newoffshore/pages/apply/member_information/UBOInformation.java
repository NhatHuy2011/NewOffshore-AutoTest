package org.newoffshore.pages.apply.member_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UBOInformation {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public UBOInformation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        WebElement fullnameInputElement = wait.until(ExpectedConditions.elementToBeClickable(fullnameUBOInput));
        fullnameInputElement.sendKeys(fullname);
    }

    public void sendKeyEmailUBO(String email){
        WebElement emailInputElement = wait.until(ExpectedConditions.elementToBeClickable(emailUBOInput));
        emailInputElement.sendKeys(email);
    }

    public void sendKeyPhoneNumberUBO(String phoneNumber){
        WebElement phoneInputElement = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInput));
        phoneInputElement.sendKeys(phoneNumber);
    }

    public void sendKeyPercentage(int percentage){
        WebElement percentageInputElement = wait.until(ExpectedConditions.elementToBeClickable(percentageInput));
        percentageInputElement.sendKeys(String.valueOf(percentage));
    }

    public void sendKeyPassportUpload(String path){
        WebElement passPortUploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(passportUploadInput));
        passPortUploadElement.sendKeys(path);
    }

    public void sendKeyAddressProofUpload(String path){
        WebElement addressProofUploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(addressProofUploadInput));
        addressProofUploadElement.sendKeys(path);
    }

    public void sendKeySelfieImageUpload(String path){
        WebElement selfieUploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(selfieUploadInput));
        selfieUploadElement.sendKeys(path);
    }

    public void clickNextButton(){
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButtonElement.click();
    }

    public void fillUBOInformation() throws InterruptedException {
        sendKeyFullnameUBO("Nhat Huy");
        sendKeyEmailUBO("huydt04082003@gmail.com");
        sendKeyPhoneNumberUBO("201-555-0123");
        sendKeyPercentage(100);
        Thread.sleep(1000);
        sendKeyPassportUpload("C:\\Users\\ADMIN\\Desktop\\2.pdf");
        Thread.sleep(1000);
        sendKeyAddressProofUpload("C:\\Users\\ADMIN\\Desktop\\2.pdf");
        Thread.sleep(1000);
        sendKeySelfieImageUpload("C:\\Users\\ADMIN\\Desktop\\2.pdf");
        Thread.sleep(1000);
        clickNextButton();
    }
}
