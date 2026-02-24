package org.newoffshore.pages.apply.company_information;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyInformation extends BasePage {
    public CompanyInformation(WebDriver driver) {
        super(driver);
    }

    private final By companyNameInput = By.cssSelector("#company_name input");

    private final By businessDescriptionInput = By.cssSelector("#business_description input");

    private final By shareCapitalInput = By.cssSelector("#share_capital input");

    private final By countryOfOperationButton = By.cssSelector("#country_of_operation button");

    private final By ssicCodeInput = By.name("ssic_code");

    private final By companyInfoNextButton = By.id("company-info-next");

    public void sendKeyCompanyName(String companyName){
        input(companyNameInput, companyName);
    }

    public void sendKeyBusinessDescription(String businessDescription){
        input(businessDescriptionInput, businessDescription);
    }

    public void sendKeyShareCapital(String shareCaptital){
        input(shareCapitalInput, shareCaptital);
    }

    public void selectCountryOfOperation(String country){
        click(countryOfOperationButton);
        scrollToElementAndClick(By.xpath("//div[@data-slot='select-item']//span[normalize-space()='" + country + "']"));
    }

    public void sendKeySSICCode(String code){
        input(ssicCodeInput, code);
    }

    public void selectNextButton(){
        click(companyInfoNextButton);
    }

    public void fillCompanyInformation_Singapore() {
        sendKeyCompanyName("The One Digi Singapore");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        sendKeySSICCode("1234, 2345");
        selectNextButton();
    }

    public void fillCompanyInformation_HongKong() {
        sendKeyCompanyName("The One Digi HongKong");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }

    public void fillCompanyInformation_USA() {
        sendKeyCompanyName("The One Digi USA");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }

    public void fillCompanyInformation_BVI() {
        sendKeyCompanyName("The One Digi BVI");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }

    public void fillCompanyInformation_Seychelles() {
        sendKeyCompanyName("The One Digi Seychelles");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }

    public void fillCompanyInformation_Cayman() {
        sendKeyCompanyName("The One Digi Cayman");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }

    public void fillCompanyInformation_Marshall() {
        sendKeyCompanyName("The One Digi Marshall");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }

    public void fillCompanyInformation_Panama() {
        sendKeyCompanyName("The One Digi Panama");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }

    public void fillCompanyInformation_Nevis() {
        sendKeyCompanyName("The One Digi Nevis");
        sendKeyBusinessDescription("Tourism, Retail");
        sendKeyShareCapital("10000");
        selectCountryOfOperation("Vietnam");
        selectNextButton();
    }
}
