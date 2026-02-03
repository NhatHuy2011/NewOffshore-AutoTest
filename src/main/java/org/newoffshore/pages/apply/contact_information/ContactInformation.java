package org.newoffshore.pages.apply.contact_information;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactInformation extends BasePage {
    public ContactInformation(WebDriver driver) {
        super(driver);
    }

    private final By fullnameInput = By.name("full_name");
    private final By emailInput = By.name("email");
    private final By phoneInput = By.cssSelector("input[data-intl-tel-input-id='0']");
    private final By businessDescriptionTextArea = By.name("business_description");
    private final By nextButton = By.xpath("//button[normalize-space()='Next']");

    public void setFullnameInput(String fullname){
        input(fullnameInput, fullname);
    }

    public void setEmailInput(String email){
        input(emailInput, email);
    }

    public void setPhoneInput(int phone){
        input(phoneInput, String.valueOf(phone));
    }

    public void setBusinessDescription(String businessDescription){
        input(businessDescriptionTextArea, businessDescription);
    }

    public void clickNext(){
        click(nextButton);
    }

    public void fillContactInformation() {
        setFullnameInput("Nhat Huy");
        setEmailInput("huydt0408@gmail.com");
        setPhoneInput(2015550123);
        setBusinessDescription("Tourism");
        clickNext();
    }
}
