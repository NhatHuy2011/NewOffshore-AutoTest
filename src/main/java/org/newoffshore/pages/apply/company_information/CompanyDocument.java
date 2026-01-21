package org.newoffshore.pages.apply.company_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyDocument {
    private final WebDriver driver;

    public CompanyDocument(WebDriver driver) {
        this.driver = driver;
    }

    private final By documentInput = By.cssSelector("input[type='file']");

    private final By nextButton = By.id("document-list-next");

    public void uploadDocumentCompany(String path){
        driver.findElement(documentInput).sendKeys(path);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    public void fillCompanyDocument() throws InterruptedException {
        uploadDocumentCompany("C:\\Users\\Admin\\Downloads\\image1.jpg");
        Thread.sleep(1000);
        clickNextButton();
    }
}
