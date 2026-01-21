package org.newoffshore.pages.apply.company_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyDocument {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CompanyDocument(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By documentInput = By.cssSelector("input[type='file']");

    private final By nextButton = By.id("document-list-next");

    public void uploadDocumentCompany(String path){
        WebElement documentInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(documentInput));
        documentInputElement.sendKeys(path);
    }

    public void clickNextButton(){
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButtonElement.click();
    }

    public void fillCompanyDocument() throws InterruptedException {
        uploadDocumentCompany("C:\\Users\\ADMIN\\Desktop\\2.pdf");

        Thread.sleep(2000);

        clickNextButton();
    }
}
