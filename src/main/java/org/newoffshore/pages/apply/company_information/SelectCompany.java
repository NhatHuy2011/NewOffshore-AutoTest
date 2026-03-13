package org.newoffshore.pages.apply.company_information;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SelectCompany extends BasePage {
    public SelectCompany(WebDriver driver) {
        super(driver);
    }

    private final By selectCompanyButton = By.cssSelector("#company button");

    private final By nextButton = By.id("select-company-next");

    public void selectCompanyOption(String companyName){
        click(selectCompanyButton);
        List<WebElement> elements = driver.findElements(By.xpath("(//div[@data-slot='select-item'])[1]"));
        System.out.println(">>>>>> COMPANY OPTION: " + elements.size());
        scrollToElementAndClick(By.xpath("(//div[@data-slot='select-item']//span)[1]"));
    }

    public void clickNextButton(){
        click(nextButton);
    }

    public void selectCompanyAndNext(String companyName) {
        selectCompanyOption(companyName);
        clickNextButton();
    }

    public void selectCompanyNotNext(String companyName){
        selectCompanyOption(companyName);
    }
}
