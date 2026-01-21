package org.newoffshore.pages.apply.member_information;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShareHolderInformation {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ShareHolderInformation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(typeOfShareHolderButton)
        );
        button.click();

        By optionLocator = By.xpath(
                "//div[@data-slot='select-item' and .//span[normalize-space()='" + type + "']]"
        );

        WebElement option = wait.until(
                ExpectedConditions.presenceOfElementLocated(optionLocator)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", option);

        wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
        option.click();
    }

    public void sendKeyFullnameShareHolder(String fullname){
        WebElement fullnameInputElement = wait.until(ExpectedConditions.elementToBeClickable(fullnameShareHolderInput));
        fullnameInputElement.sendKeys(fullname);
    }

    public void sendKeyEmailshareholder(String email){
        WebElement emailInputElement = wait.until(ExpectedConditions.elementToBeClickable(emailShareHolderInput));
        emailInputElement.sendKeys(email);
    }

    public void sendKeyPhoneNumbershareholder(String phoneNumber){
        WebElement phoneInputElement = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInput));
        phoneInputElement.sendKeys(phoneNumber);
    }

    public void sendKeyShare(int share){
        WebElement shareInputElement = wait.until(ExpectedConditions.elementToBeClickable(shareInput));
        shareInputElement.sendKeys(String.valueOf(share));
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

    public void fillShareHolderInformation() throws InterruptedException {
        selectTypeOfShareHolder("Individual");
        sendKeyFullnameShareHolder("Nhat Huy");
        sendKeyEmailshareholder("huydt04082003@gmail.com");
        sendKeyPhoneNumbershareholder("201-555-0123");
        sendKeyShare(10000);
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
