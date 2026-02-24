package org.newoffshore.pages.apply.member_information;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MemberInformation extends BasePage {
    public MemberInformation(WebDriver driver) {
        super(driver);
    }

    private final By typeOfMemberButton = By.id("members.0.type");

    private final By positionDirectorButton = By.id("members.0.director");

    private final By positionShareholderButton = By.id("members.0.shareholder");

    private final By positionUBOButton = By.id("members.0.owner");

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
        scrollToElementAndClick(submitButton);
    }

    public void selectGroupService(String id){
        click((By.cssSelector(("label[for='"+ id +"']"))));
    }

    public void fillMemberInformation(){
        selectTypeOfMember("Individual");
        selectGroupService("members.0.director");
        selectGroupService("members.0.shareholder");
        selectGroupService("members.0.owner");
//        selectPositionDirector();
//        selectPositionShareholder();
//        selectPositionUBO();
        setFullNameInput("Nhat Huy");
        setEmailInput("huydt04082003@gmail.com");
        setPhoneInput("2015550123");
        setShareInput("10000");
        setPercentageInput("100");
        clickSubmitButton();
    }
}
