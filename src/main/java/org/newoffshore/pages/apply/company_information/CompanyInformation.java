package org.newoffshore.pages.apply.company_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyInformation {
    private final WebDriverWait wait;

    public CompanyInformation(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By companyNameInput = By.cssSelector("#company_name input");

    private final By businessDescriptionInput = By.cssSelector("#business_description input");

    private final By shareCapitalInput = By.cssSelector("#share_capital input");

    private final By countryOfOperationButton = By.cssSelector("#country_of_operation button");

    private final By ssicCodeInput = By.name("ssic_code");

    private final By companyInfoNextButton = By.id("company-info-next");

    public void sendKeyCompanyName(String companyName){
        WebElement companyNameElement = wait.until(ExpectedConditions.elementToBeClickable(companyNameInput));
        companyNameElement.sendKeys(companyName);
    }

    public void sendKeyBusinessDescription(String businessDescription){
        WebElement businessDescriptionElement = wait.until(ExpectedConditions.elementToBeClickable(businessDescriptionInput));
        businessDescriptionElement.sendKeys(businessDescription);
    }

    public void sendKeyShareCapital(int shareCaptital){
        WebElement shareCapitalElement = wait.until(ExpectedConditions.elementToBeClickable(shareCapitalInput));
        shareCapitalElement.sendKeys(String.valueOf(shareCaptital));
    }

    public void selectCountryOfOperation(String country){
        WebElement select = wait.until(ExpectedConditions.elementToBeClickable(countryOfOperationButton));
        select.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@data-slot='select-item']//span[normalize-space()='" + country + "']")
                )
        );
        option.click();
    }

    public void sendKeySSICCode(String code){
        WebElement ssicCodeElement = wait.until(ExpectedConditions.elementToBeClickable(ssicCodeInput));
        ssicCodeElement.sendKeys(code);
    }

    public void selectNextButton(){
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(companyInfoNextButton));
        nextButtonElement.click();
    }

    public void fillCompanyInformation() {
        sendKeyCompanyName("Cong Ty Co Phan The One Digi");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital(10000);
        selectCountryOfOperation("Vietnam");
        sendKeySSICCode("1234, 2345");
        selectNextButton();
    }
}
