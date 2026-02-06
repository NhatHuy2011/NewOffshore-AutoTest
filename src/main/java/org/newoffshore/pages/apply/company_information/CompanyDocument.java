package org.newoffshore.pages.apply.company_information;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.BasePage;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class CompanyDocument extends BasePage {
    public CompanyDocument(WebDriver driver) {
        super(driver);
    }

    private final By documentInput = By.cssSelector("input[type='file']");

    private final By nextButton = By.id("document-list-next");

    public void uploadDocumentCompany(String path){
        inputFile(documentInput, path);
    }

    public void waitForFileAppearInTable(String fileName) {
        By fileNameCell = By.xpath(
                "//tr[@data-slot='table-row']//td[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(fileNameCell));
    }

    public void clickNextButton(){
        click(nextButton);
    }

    public void fillCompanyDocument() {
        String path = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File file = new File(path);

        uploadDocumentCompany(path);
        waitForFileAppearInTable(file.getName());

        clickNextButton();
    }
}
