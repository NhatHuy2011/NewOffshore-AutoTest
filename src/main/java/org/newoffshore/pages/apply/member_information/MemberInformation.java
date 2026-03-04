package org.newoffshore.pages.apply.member_information;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MemberInformation extends BasePage {
    public MemberInformation(WebDriver driver) {
        super(driver);
    }

    private final By typeOfMemberButton = By.id("members.0.type");

    private final By positionDirectorButton = By.xpath("//h5[text()='Director']/following::button[@role='checkbox'][1]");

    private final By positionShareholderButton = By.xpath("//h5[text()='Shareholder']/following::button[@role='checkbox'][1]");

    private final By positionUBOButton = By.xpath("//h5[text()='Owner']/following::button[@role='checkbox'][1]");

    private final By fullNameInput = By.name("members.0..member.name");

    private final By emailInput = By.name("members.0..member.email");

    private final By phoneInput = By.xpath("//div[@id='members.0..member.phone']//input[@type='tel']");

    private final By shareInput = By.name("members.0..member.shares");

    private final By percentageInput = By.name("members.0..member.percentage");

    private final By submitButton = By.id("select-already-company-next");

    public void selectTypeOfMember(String type){
        click(typeOfMemberButton);
        click(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='" + type +"']]"));
    }

    public void selectPositionDirector(){
        click(positionDirectorButton);
    }

    public void selectPositionShareholder(){
        click(positionShareholderButton);
    }

    public void selectPositionUBO(){
        click(positionUBOButton);
    }

    public void setFullNameInput(String text){
        input(fullNameInput, text);
    }

    public void setEmailInput(String text){
        input(emailInput, text);
    }

    public void setPhoneInput(String text){
        input(phoneInput, text);
    }

    public void setShareInput(String text){
        input(shareInput, text);
    }

    public void setPercentageInput(String text){
        input(percentageInput, text);
    }

    public void clickSubmitButton(){
        List<WebElement> submitButtons = driver.findElements(submitButton);
        submitButtons.get(1).click();
    }

    public void fillMemberInformation(){
        selectTypeOfMember("Individual");
        selectPositionDirector();
        selectPositionShareholder();
        selectPositionUBO();
        setFullNameInput("Nhat Huy");
        setEmailInput("huydt04082003@gmail.com");
        setPhoneInput("2015550123");
        setShareInput("10000");
        setPercentageInput("100");
        clickSubmitButton();
    }
}
