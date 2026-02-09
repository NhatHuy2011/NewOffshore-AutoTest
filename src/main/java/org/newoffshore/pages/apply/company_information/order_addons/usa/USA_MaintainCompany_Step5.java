package org.newoffshore.pages.apply.company_information.order_addons.usa;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.BasePage;
import org.newoffshore.pages.apply.company_information.CompanyDocument;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class USA_MaintainCompany_Step5 extends BasePage {
    public USA_MaintainCompany_Step5(WebDriver driver) {
        super(driver);
    }

    private final By noteTextArea = By.name("notes");

    private final By apostilleDocumentInput = By.id("apostille_doc.company_document-upload");

    private final By certifiedTrueCopyCPAInput = By.id("certified_copy_by_cpa.company_document-upload");

    private final By certifiedTrueCopySecretaryInput = By.id("certified_cert_by_state.company_document-upload");

    private final By sumitStep5Button = By.id("document-list-next");

    public void setNoteTextArea(String text){
        input(noteTextArea, text);
    }

    public void setApostilleDocumentInput(String path){
        inputFile(apostilleDocumentInput, path);
    }

    public void setCertifiedTrueCopyCPAInput(String path){
        inputFile(certifiedTrueCopyCPAInput, path);
    }

    public void setCertifiedTrueCopySecretaryInput(String path){
        inputFile(certifiedTrueCopySecretaryInput, path);
    }

    public void waitForFileAppear(String id, String fileName){
        By uploadedFileName = By.xpath(
                "//div[@id='" + id + "']" +
                        "//p[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileName));
    }

    public void clickNextButton(){
        List<WebElement> buttons = driver.findElements(sumitStep5Button);
        buttons.get(1).click();
    }

    public void selectButton(String id){
        scrollToElementAndClick(By.id(id));
    }

    public void setUSACompanyMaintainStep5() throws InterruptedException {
        selectButton("yes-changeStructure");
        setNoteTextArea("Test");
        selectButton("change-structure-company-next");
        selectButton("yes-hasUSOperations");
        selectButton("select-hasUSOperations-next");
        CompanyDocument companyDocument = new CompanyDocument(driver);
        companyDocument.fillCompanyDocument();

        String apostillePath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File apostilleFile = new File(apostillePath);
        setApostilleDocumentInput(apostillePath);
        waitForFileAppear("apostille_doc.company_document", apostilleFile.getName());
        Thread.sleep(1000);

        String certifiedCPAPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File certifiedCPAFile = new File(certifiedCPAPath);
        setCertifiedTrueCopyCPAInput(certifiedCPAPath);
        waitForFileAppear("certified_copy_by_cpa.company_document", certifiedCPAFile.getName());
        Thread.sleep(1000);

        String certifiedSecretaryPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File certifiedSecretaryFile = new File(certifiedSecretaryPath);
        setCertifiedTrueCopySecretaryInput(certifiedSecretaryPath);
        waitForFileAppear("certified_cert_by_state.company_document", certifiedSecretaryFile.getName());
        Thread.sleep(1000);

        clickNextButton();
        selectButton("member-info-next");
    }
}
