package org.newoffshore.pages.apply.service.singapore;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_RestoreCompany_Service extends BasePage {
    public Singapore_RestoreCompany_Service(WebDriver driver) {
        super(driver);
    }

    private final By cancelTermButton = By.xpath("//button[normalize-space() = 'Cancel']");

    private final By textArea = By.tagName("textarea");

    private final By nextButton = By.id("singapore-apply-form-next");

    public void clickCancelTerm(){
        click(cancelTermButton);
    }

    public void inputRequest(String text){
        input(textArea, text);
    }

    public void clickNextButton(){
        click(nextButton);
    }

    public void selectRestoreCompany(){
        clickCancelTerm();
        inputRequest("Test");
        clickNextButton();
    }
}
