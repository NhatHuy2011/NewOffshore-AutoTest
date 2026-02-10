package org.newoffshore.pages.apply.company_information.order_addons.panama;

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

public class Panama_MaintainCompany_Step5 extends BasePage {
    public Panama_MaintainCompany_Step5(WebDriver driver) {
        super(driver);
    }

    private final By aspostilleDocumentInput = By.id("apostilled_notarised.company_document-upload");

    private final By certifiedRegistryInput = By.id("certified_by_registry.company_document-upload");

    private final By certifiedRegistAgentInput = By.id("certified_by_agent.company_document-upload");

    private final By certifiedCPAInput = By.id("certified_of_copy_by_cpa.company_document-upload");

    private final By companyNameInput = By.name("pa_change_company_name.company_name");

    private final By increaseShareInput = By.cssSelector("#increase_of_authorized_capitals\\.amount_to_increase input");

    private final By courierFullNameInput = By.name("courier_dispatch_services.full_name");

    private final By courierPhoneInput = By.name("courier_dispatch_services.phone_number");

    private final By courierAddressInput = By.name("courier_dispatch_services.delivery_address");

    private final By nextButton = By.id("document-list-next");

    public void setAspostilleDocumentInput(String path){
        inputFile(aspostilleDocumentInput, path);
    }

    public void setCertifiedRegistryInput(String path){
        inputFile(certifiedRegistryInput, path);
    }

    public void setCertifiedRegistAgentInput(String path){
        inputFile(certifiedRegistAgentInput, path);
    }

    public void setCertifiedCPAInput(String path){
        inputFile(certifiedCPAInput, path);
    }

    public void setCompanyNameInput(String companyName){
        input(companyNameInput, companyName);
    }

    public void setIncreaseShareInput(String share){
        input(increaseShareInput, share);
    }

    public void setCourierFullNameInput(String fullname){
        input(courierFullNameInput, fullname);
    }

    public void setCourierPhoneInput(String phone){
        input(courierPhoneInput, phone);
    }

    public void setCourierAddressInput(String address){
        input(courierAddressInput, address);
    }

    public void waitForFileAppear(String id, String fileName){
        By uploadedFileName = By.xpath(
                "//div[@id='" + id + "']" +
                        "//p[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileName));
    }

    public void clickNextButton(){
        List<WebElement> buttons = driver.findElements(nextButton);
        buttons.get(1).click();
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void setPanamaMaintainCompanyStep5() throws InterruptedException {
        CompanyDocument companyDocument = new CompanyDocument(driver);
        companyDocument.fillCompanyDocumentAndNext();

        String aspostillePath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File aspostilleFile = new File(aspostillePath);
        setAspostilleDocumentInput(aspostillePath);
        waitForFileAppear("apostilled_notarised.company_document", aspostilleFile.getName());
        Thread.sleep(1000);

        String certifiedRegistryPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File certifiedRegistryFile = new File(certifiedRegistryPath);
        setCertifiedRegistryInput(certifiedRegistryPath);
        waitForFileAppear("certified_by_registry.company_document", certifiedRegistryFile.getName());
        Thread.sleep(1000);

        String certifiedRegisAgentPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File certifiedRegisAgentFile = new File(certifiedRegisAgentPath);
        setCertifiedRegistAgentInput(certifiedRegistryPath);
        waitForFileAppear("certified_by_agent.company_document", certifiedRegisAgentFile.getName());
        Thread.sleep(1000);

        String certifiedCPAPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File certifiedCPAFile = new File(certifiedCPAPath);
        setCertifiedCPAInput(certifiedCPAPath);
        waitForFileAppear("certified_of_copy_by_cpa.company_document", certifiedCPAFile.getName());
        Thread.sleep(1000);

        setCompanyNameInput("The One VietNam");
        setIncreaseShareInput("10000");
        setCourierFullNameInput("Nhat Huy");
        setCourierPhoneInput("2015550123");
        setCourierAddressInput("40 Thien Phuoc");
        clickNextButton();
        scrollToElementAndClick(By.id("member-info-next"));
    }
}
