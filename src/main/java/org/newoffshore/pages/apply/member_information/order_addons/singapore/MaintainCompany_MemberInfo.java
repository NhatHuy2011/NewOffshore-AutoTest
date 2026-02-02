package org.newoffshore.pages.apply.member_information.order_addons.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MaintainCompany_MemberInfo {
    private final WebDriverWait wait;

    public MaintainCompany_MemberInfo(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By memberInfoNextButton = By.id("member-info-next");

    private final By typeOfDirectorButton = By.cssSelector("#appointment_director\\.director\\.type button");

    private final By inputFullnameDirector = By.name("appointment_director.director.name");

    private final By inputEmailDirector = By.name("appointment_director.director.email");

    private final By inputPhoneNumberDirector = By.cssSelector("#appointment_director\\.director\\.phone input[type='tel']");

    private final By passportDirector = By.id("appointment_director.director.passport_path-upload");

    private final By addressProofDirector = By.id("appointment_director.director.address_proof_path-upload");

    private final By selfieImageDirector = By.id("appointment_director.director.selfie_path-upload");

    private final By resignationDirector = By.cssSelector("#resignation_director\\.resignation_of_director input");

    private final By updateExistingDirector = By.cssSelector("#update_director_shareholder_information\\.note textarea");

    private final By existingShareHolderButton = By.id("existing_shareholder");

    private final By customRequestExistingShareholder = By.cssSelector("#transfer_shares\\.shareholder\\.custom_request textarea");

    private final By nextButton = By.id("additional-services-next");

    public void clickMemberNextInfoButton(){
        WebElement memberInfoElement = wait.until(ExpectedConditions.elementToBeClickable(memberInfoNextButton));
        memberInfoElement.click();
    }

    public void selectTypeOfDirector(String type){
        WebElement typeDirectorElement = wait.until(ExpectedConditions.elementToBeClickable(typeOfDirectorButton));
        typeDirectorElement.click();

        WebElement typeOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='" + type +"']]")));
        typeOptionElement.click();
    }

    public void setInputFullnameDirector(String fullname){
        WebElement inputFullnameElement = wait.until(ExpectedConditions.elementToBeClickable(inputFullnameDirector));
        inputFullnameElement.sendKeys(fullname);
    }

    public void setInputEmailDirector(String email){
        WebElement inputEmailElement = wait.until(ExpectedConditions.elementToBeClickable(inputEmailDirector));
        inputEmailElement.sendKeys(email);
    }

    public void setInputPhoneNumberDirector(String phone){
        WebElement inputPhoneElement = wait.until(ExpectedConditions.elementToBeClickable(inputPhoneNumberDirector));
        inputPhoneElement.sendKeys(phone);
    }

    public void setPassportDirector(){
        WebElement passportElement = wait.until(ExpectedConditions.presenceOfElementLocated(passportDirector));
        passportElement.sendKeys(ConfigReader.getResourceFilePath(Constant.IMAGE_PATH));
    }

    public void setAddressProofDirector(){
        WebElement addressProofElement = wait.until(ExpectedConditions.presenceOfElementLocated(addressProofDirector));
        addressProofElement.sendKeys(ConfigReader.getResourceFilePath(Constant.IMAGE_PATH));
    }

    public void setSelfieImageDirector(){
        WebElement selfieImageElement = wait.until(ExpectedConditions.presenceOfElementLocated(selfieImageDirector));
        selfieImageElement.sendKeys(ConfigReader.getResourceFilePath(Constant.IMAGE_PATH));
    }

    public void setResignationDirector(String directorName){
        WebElement resignDirectorElement = wait.until(ExpectedConditions.elementToBeClickable(resignationDirector));
        resignDirectorElement.sendKeys(directorName);
    }

    public void setUpdateExistingDirector(String directorName){
        WebElement updateDirectorElement = wait.until(ExpectedConditions.elementToBeClickable(updateExistingDirector));
        updateDirectorElement.sendKeys(directorName);
    }

    public void setExistingShareHolder(String shareHolderName){
        WebElement existButtonElement = wait.until(ExpectedConditions.elementToBeClickable(existingShareHolderButton));
        existButtonElement.click();

        WebElement customRequestElement = wait.until(ExpectedConditions.elementToBeClickable(customRequestExistingShareholder));
        customRequestElement.sendKeys(shareHolderName);
    }

    public void clickNextButton(){
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButtonElement.click();
    }

    public void setCompanyMemberChange(){
        clickMemberNextInfoButton();
        selectTypeOfDirector("Individual");
        setInputFullnameDirector("Nhat Huy");
        setInputEmailDirector("huydt04082003@gmail.com");
        setInputPhoneNumberDirector("2550122345");
        setPassportDirector();
        setAddressProofDirector();
        setSelfieImageDirector();
        setResignationDirector("Nhat Huy");
        setUpdateExistingDirector("Nhat Huy");
        setExistingShareHolder("Nhat Huy");
        clickNextButton();
    }
}
