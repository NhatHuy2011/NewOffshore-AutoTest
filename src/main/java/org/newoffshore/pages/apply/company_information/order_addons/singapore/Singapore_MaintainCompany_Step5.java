package org.newoffshore.pages.apply.company_information.order_addons.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.BasePage;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class Singapore_MaintainCompany_Step5 extends BasePage {
    public Singapore_MaintainCompany_Step5(WebDriver driver) {
        super(driver);
    }

    private final By inputCompanyNameChange = By.name("change_company_name.company_name");

    private final By inputBusinessActivityChange = By.name("change_business_activity.business_activity");

    private final By inputSSICCodeChange = By.name("change_business_activity.ssic_code");

    private final By inputOfficeAddressChange = By.name("change_office_address.office_address");

    private final By inputProofOfAddressChange = By.id("change_office_address.proof_of_address-upload");

    private final By inputIncreaseShareChange = By.cssSelector("#increase_share_capital\\.share_capital input");

    private final By nextButton = By.id("document-list-next");

    public void setInputCompanyNameChange(String companyName){
        input(inputCompanyNameChange, companyName);
    }

    public void setInputBusinessActivityChange(String businessActivity){
        input(inputBusinessActivityChange, businessActivity);
    }

    public void setInputSSICCodeChange(String ssicCode){
        input(inputSSICCodeChange, ssicCode);
    }

    public void setInputOfficeAddressChange(String officeAddress){
        input(inputOfficeAddressChange, officeAddress);
    }

    public void setInputProofOfAddressChange(String path){
        inputFile(inputProofOfAddressChange, path);
    }

    public void waitForFileAppear(String fileName){
        By uploadedFileName = By.xpath(
                "//div[@id='change_office_address.proof_of_address']" +
                        "//p[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileName));
    }

    public void setInputIncreaseShareChange(String share){
        input(inputIncreaseShareChange, share);
    }

    public void clickNextButton(){
        click(nextButton);
    }

    public void setSingaporeMaintainCompanyStep5() {
        setInputCompanyNameChange("The One Digi");
        setInputBusinessActivityChange("Tourism");
        setInputSSICCodeChange("1234, 2345");
        setInputOfficeAddressChange("40 Thien Phuoc");

        String path = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File file = new File(path);
        setInputProofOfAddressChange(path);
        waitForFileAppear(file.getName());

        setInputIncreaseShareChange("10000");
        clickNextButton();
    }
}
