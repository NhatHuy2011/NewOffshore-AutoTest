package org.newoffshore.pages.apply.member_information;

import org.newoffshore.constant.Constant;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DirectorInformation {
    private final WebDriverWait wait;

    public DirectorInformation(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        WebElement typeElementButton = wait.until(ExpectedConditions.elementToBeClickable(typeOfDirectorButton));
        typeElementButton.click();

        WebElement typeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='" + type +"']]")));
        typeElement.click();
    }

    public void sendKeyFullnameDirector(String fullname){
        WebElement fullnameInputElement = wait.until(ExpectedConditions.elementToBeClickable(fullnameDirectorInput));
        fullnameInputElement.sendKeys(fullname);
    }

    public void sendKeyEmailDirector(String email){
        WebElement emailInputElement = wait.until(ExpectedConditions.elementToBeClickable(emailDirectorInput));
        emailInputElement.sendKeys(email);
    }

    public void sendKeyPhoneNumberDirector(String phoneNumber){
        WebElement phoneInputElement = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInput));
        phoneInputElement.sendKeys(phoneNumber);
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

    public void fillDirectorInformation() throws InterruptedException {
        selectTypeOfDirector("Individual");
        sendKeyFullnameDirector("Nhat Huy");
        sendKeyEmailDirector("huydt04082003@gmail.com");
        sendKeyPhoneNumberDirector("201-555-0123");
        sendKeyPassportUpload(ConfigReader.getResourceFilePath(Constant.IMAGE_PATH));
        sendKeyAddressProofUpload(ConfigReader.getResourceFilePath(Constant.IMAGE_PATH));
        sendKeySelfieImageUpload(ConfigReader.getResourceFilePath(Constant.IMAGE_PATH));
        Thread.sleep(2000);
        clickNextButton();
    }
}
