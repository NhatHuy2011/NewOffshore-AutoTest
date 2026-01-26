package org.newoffshore.pages.apply.company_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectCompany {
    private final WebDriverWait wait;

    public SelectCompany(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By selectCompanyButton = By.cssSelector("#company button");

    private final By nextButton = By.id("select-company-next");

    public void selectCompanyOption(String companyName){
        WebElement selectCompanyButtonElement = wait.until(ExpectedConditions.elementToBeClickable(selectCompanyButton));
        selectCompanyButtonElement.click();

        WebElement companyOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@data-slot='select-item']//span[normalize-space()='" + companyName + "']")
                )
        );
        companyOption.click();
    }

    public void clickNextButton(){
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButtonElement.click();
    }

    public void selectCompany(String companyName) {
        selectCompanyOption("The One Digi");
        clickNextButton();
    }
}
