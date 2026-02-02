package org.newoffshore.pages.apply.company_information.order_addons.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URISyntaxException;
import java.time.Duration;

public class MaintainCompany_CompanyInfo {
    private final WebDriverWait wait;

    public MaintainCompany_CompanyInfo(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By inputCompanyNameChange = By.name("change_company_name.company_name");

    private final By inputBusinessActivityChange = By.name("change_business_activity.business_activity");

    private final By inputSSICCodeChange = By.name("change_business_activity.ssic_code");

    private final By inputOfficeAddressChange = By.name("change_office_address.office_address");

    private final By inputProofOfAddressChange = By.id("change_office_address.proof_of_address-upload");

    private final By inputIncreaseShareChange = By.cssSelector("#increase_share_capital\\.share_capital input");

    private final By nextButton = By.id("document-list-next");

    public void setInputCompanyNameChange(String companyName){
        WebElement companyNameChangeElement = wait.until(ExpectedConditions.elementToBeClickable(inputCompanyNameChange));
        companyNameChangeElement.sendKeys(companyName);
    }

    public void setInputBusinessActivityChange(String businessActivity){
        WebElement businessActivityElement = wait.until(ExpectedConditions.elementToBeClickable(inputBusinessActivityChange));
        businessActivityElement.sendKeys(businessActivity);
    }

    public void setInputSSICCodeChange(String ssicCode){
        WebElement ssicCodeElement = wait.until(ExpectedConditions.elementToBeClickable(inputSSICCodeChange));
        ssicCodeElement.sendKeys(ssicCode);
    }

    public void setInputOfficeAddressChange(String officeAddress){
        WebElement officeAddressElement = wait.until(ExpectedConditions.elementToBeClickable(inputOfficeAddressChange));
        officeAddressElement.sendKeys(officeAddress);
    }

    public void setInputProofOfAddressChange(String path){
        WebElement proofOfAddressElement = wait.until(ExpectedConditions.presenceOfElementLocated(inputProofOfAddressChange));
        proofOfAddressElement.sendKeys(path);
    }

    public void setInputIncreaseShareChange(int share){
        WebElement increaseShareElement = wait.until(ExpectedConditions.elementToBeClickable(inputIncreaseShareChange));
        increaseShareElement.sendKeys(String.valueOf(share));
    }

    public void clickNextButton(){
        WebElement nextElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextElement.click();
    }

    public void setCompanyInfoChangeMaintain() throws InterruptedException {
        setInputCompanyNameChange("The One Digi");
        setInputBusinessActivityChange("Tourism");
        setInputSSICCodeChange("1234, 2345");
        setInputOfficeAddressChange("40 Thien Phuoc");
        setInputProofOfAddressChange(ConfigReader.getResourceFilePath(Constant.IMAGE_PATH));
        Thread.sleep(1000);
        setInputIncreaseShareChange(10000);
        clickNextButton();
        Thread.sleep(1000);
    }
}
