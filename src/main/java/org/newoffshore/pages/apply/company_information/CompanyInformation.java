package org.newoffshore.pages.apply.company_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyInformation {
    private final WebDriver driver;

    public CompanyInformation(WebDriver driver) {
        this.driver = driver;
    }

    private final By companyNameInput = By.cssSelector("#company_name input");

    private final By businessDescriptionInput = By.cssSelector("#business_description input");

    private final By shareCapitalInput = By.cssSelector("#share_capital input");

    private final By countryOfOperationButton = By.cssSelector("#country_of_operation button");

    private final By ssicCodeInput = By.name("ssic_code");

    private final By companyInfoNextButton = By.id("company-info-next");

    public void sendKeyCompanyName(String companyName){
        driver.findElement(companyNameInput).sendKeys(companyName);
    }

    public void sendKeyBusinessDescription(String businessDescription){
        driver.findElement(businessDescriptionInput).sendKeys(businessDescription);
    }

    public void sendKeyShareCapital(int shareCaptital){
        driver.findElement(shareCapitalInput).sendKeys(String.valueOf(shareCaptital));
    }

    public void selectCountryOfOperation(String country){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
        driver.findElement(ssicCodeInput).sendKeys(code);
    }

    public void selectNextButton(){
        driver.findElement(companyInfoNextButton).click();
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
