package org.newoffshore.pages.apply.applicant_information;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.BasePage;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class DependentPass_ApplicantInformation extends BasePage {
    public DependentPass_ApplicantInformation(WebDriver driver) {
        super(driver);
    }

    private final By inputEmploymentPass = By.id("employment_pass_path-upload");

    private final By inputPassportUpload = By.id("dependent.passport_path-upload");

    private final By inputAddressProofUpload = By.id("dependent.address_proof_path-upload");

    private final By inputMarriageCertificate = By.id("dependent.marriage_certificate_path-upload");

    private final By inputBachelorDegree = By.id("dependent.bachelors_degree_path-upload");

    private final By nextButton = By.id("employment-next");

    public void setInputEmploymentPass(String path){
        inputFile(inputEmploymentPass, path);
    }

    public void selectOptionRelationship(){
        click(By.cssSelector("#dependent\\.relationship button"));
        click(By.xpath("//div[@data-slot='select-item' and .//span[normalize-space()='Spouse']]"));
    }

    public void setInputPassportUpload(String path){
        inputFile(inputPassportUpload, path);
    }

    public void setInputAddressProofUpload(String path){
        inputFile(inputAddressProofUpload, path);
    }

    public void setInputMarriageCertificate(String path){
        inputFile(inputMarriageCertificate, path);
    }

    public void setInputBachelorDegree(String path){
        inputFile(inputBachelorDegree, path);
    }

    public void waitForFileAppear(String id, String fileName){
        By uploadedFileName = By.xpath(
                "//div[@id='" + id + "']" +
                        "//p[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileName));
    }

    public void clickNextButton(){
        scrollToElementAndClick(nextButton);
    }

    public void fillDependentPass(){
        String employmentPassPath = ConfigReader.getResourceFilePath(Constant.EMPLOYMENT_PASS_PATH);
        File employmentPassFile = new File(employmentPassPath);
        setInputEmploymentPass(employmentPassPath);
        waitForFileAppear("employment_pass_path", employmentPassFile.getName());

        selectOptionRelationship();

        String passportPath = ConfigReader.getResourceFilePath(Constant.PASSPORT_IMAGE_PATH);
        File passPortFile = new File(passportPath);
        setInputPassportUpload(passportPath);
        waitForFileAppear("dependent.passport_path", passPortFile.getName());

        String addressProofPath = ConfigReader.getResourceFilePath(Constant.ADDRESS_PROOF_PATH);
        File addressProofFile = new File(addressProofPath);
        setInputAddressProofUpload(addressProofPath);
        waitForFileAppear("dependent.address_proof_path", addressProofFile.getName());

        String marriageCertificatePath = ConfigReader.getResourceFilePath(Constant.MARRIAGE_CERTIFICATE_PATH);
        File marriageCertificateFile = new File(marriageCertificatePath);
        setInputMarriageCertificate(marriageCertificatePath);
        waitForFileAppear("dependent.marriage_certificate_path", marriageCertificateFile.getName());

        String bachelorDegreePath = ConfigReader.getResourceFilePath(Constant.BACHELOR_DEGREE_PATH);
        File bachelorFile = new File(bachelorDegreePath);
        setInputBachelorDegree(bachelorDegreePath);
        waitForFileAppear("dependent.bachelors_degree_path", bachelorFile.getName());

        clickNextButton();
    }
}
