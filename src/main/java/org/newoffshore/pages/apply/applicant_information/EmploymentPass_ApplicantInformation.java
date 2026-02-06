package org.newoffshore.pages.apply.applicant_information;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.BasePage;
import org.newoffshore.pages.apply.company_information.CompanyDocument;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class EmploymentPass_ApplicantInformation extends BasePage {
    public EmploymentPass_ApplicantInformation(WebDriver driver) {
        super(driver);
    }

    //Employment Pass
    private final By inputPassport = By.id("passport_path-upload");

    private final By inputAddressProof = By.id("address_proof_path-upload");

    private final By inputBachelorDegree = By.id("bachelors_degree_path-upload");

    private final By submitEmploymentPassButton = By.id("employment-next");

    public void selectButton(String id){
        click(By.id(id));
    }

    public void setInputPassport(String path){
        inputFile(inputPassport, path);
    }

    public void setInputAddressProof(String path){
        inputFile(inputAddressProof, path);
    }

    public void setInputBachelorDegree(String path){
        inputFile(inputBachelorDegree, path);
    }

    public void clickSubmitEmploymentPassButton(){
        scrollToElementAndClick(submitEmploymentPassButton);
    }


    public void waitForFileAppear(String id, String fileName){
        By uploadedFileName = By.xpath(
                "//div[@id='" + id + "']" +
                        "//p[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileName));
    }

    public void fillEmploymentPass(){
        selectButton("yes-alreadyCompany");
        selectButton("select-already-company-next");
        SelectCompany companySingapore = new SelectCompany(driver);
        companySingapore.selectCompanyOption("The One Digi Singapore");
        selectButton("yes-annualTaxReturn");
        selectButton("select-company-next");
        CompanyDocument companyDocument = new CompanyDocument(driver);
        companyDocument.fillCompanyDocument();

        String passportPath = ConfigReader.getResourceFilePath(Constant.PASSPORT_IMAGE_PATH);
        File passPortFile = new File(passportPath);
        setInputPassport(passportPath);
        waitForFileAppear("passport_path", passPortFile.getName());

        String addressProofPath = ConfigReader.getResourceFilePath(Constant.ADDRESS_PROOF_PATH);
        File addressProofFile = new File(addressProofPath);
        setInputAddressProof(addressProofPath);
        waitForFileAppear("address_proof_path", addressProofFile.getName());

        String bachelorDegreePath = ConfigReader.getResourceFilePath(Constant.BACHELOR_DEGREE_PATH);
        File bachelorFile = new File(bachelorDegreePath);
        setInputBachelorDegree(bachelorDegreePath);
        waitForFileAppear("bachelors_degree_path", bachelorFile.getName());

        clickSubmitEmploymentPassButton();
    }
}
