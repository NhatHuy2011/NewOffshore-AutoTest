package org.newoffshore.pages.apply.company_information;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectCompany extends BasePage {
    public SelectCompany(WebDriver driver) {
        super(driver);
    }

    private final By selectCompanyButton = By.cssSelector("#company button");

    private final By nextButton = By.id("select-company-next");

    public void selectCompanyOption(){
        click(selectCompanyButton);
        scrollToElementAndClick(
                By.xpath("(//div[@role='option']//span[normalize-space()])[1]")
        );
    }

    public void clickNextButton(){
        click(nextButton);
    }

    public void selectCompanyAndNext() {
        selectCompanyOption();
        clickNextButton();
    }

    public void selectCompanyNotNext(){
        selectCompanyOption();
    }
}
