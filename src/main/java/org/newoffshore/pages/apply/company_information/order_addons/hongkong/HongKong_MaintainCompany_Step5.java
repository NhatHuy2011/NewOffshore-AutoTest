package org.newoffshore.pages.apply.company_information.order_addons.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.BasePage;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class HongKong_MaintainCompany_Step5 extends BasePage {
    public HongKong_MaintainCompany_Step5(WebDriver driver) {
        super(driver);
    }

    private final By notesTextArea = By.name("notes");

    private final By increaseShareInput = By.cssSelector("#share_capital_increase\\.share_capital input");

    private final By changeCompanyNameInput = By.name("change_company_name.company_name");

    private final By changeBusinessInput = By.name("change_business_activities_on_business_register.business_activities");

    private final By changeBrandNameInput = By.name("registration_brand_name_and_update_business_register.brand_name");

    private final By amendmentAnnexInput = By.cssSelector("#amendment_of_company_constitution\\.annex input");

    private final By amendmentDraftConstitutionInput = By.cssSelector("#amendment_of_company_constitution\\.draft_constitution input");

    private final By courierFullNameInput = By.name("courier_dispatch_service.full_name");

    private final By courierPhoneInput = By.name("courier_dispatch_service.phone_number");

    private final By courierDeliveryInput = By.name("courier_dispatch_service.delivery_address");

    public void setNotesTextArea(String text){
        input(notesTextArea, text);
    }

    public void setIncreaseShareInput(String share){
        input(increaseShareInput, share);
    }

    public void setChangeCompanyNameInput(String name){
        input(changeCompanyNameInput, name);
    }

    public void setChangeBusinessInput(String businessActivity){
        input(changeBusinessInput, businessActivity);
    }

    public void setChangeBrandNameInput(String brandName){
        input(changeBrandNameInput, brandName);
    }

    public void setAmendmentAnnexInput(String path){
        inputFile(amendmentAnnexInput, path);
    }

    public void setAmendmentDraftConstitutionInput(String path){
        inputFile(amendmentDraftConstitutionInput, path);
    }

    public void setCourierFullNameInput(String fullname){
        input(courierFullNameInput, fullname);
    }

    public void setCourierPhoneInput(String phone){
        input(courierPhoneInput, phone);
    }

    public void setCourierDeliveryInput(String address){
        input(courierDeliveryInput, address);
    }

    public void waitForFileAppear(String id, String fileName){
        By uploadedFileName = By.xpath(
                "//div[@id='" + id + "']" +
                        "//p[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileName));
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void setHongKongMaintainCompanyStep5(){
        selectButton("yes-changeStructure");
        setNotesTextArea("Test");
        selectButton("change-structure-company-next");
        setIncreaseShareInput("10000");
        setChangeCompanyNameInput("The One VietNam");
        setChangeBusinessInput("Travel");
        setChangeBrandNameInput("The One Digital");

        String annexPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File annexFile = new File(annexPath);
        setAmendmentAnnexInput(annexPath);
        waitForFileAppear("amendment_of_company_constitution.annex", annexFile.getName());

        String draftConstitutionPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File draftConstitutionFile = new File(draftConstitutionPath);
        setAmendmentDraftConstitutionInput(draftConstitutionPath);
        waitForFileAppear("amendment_of_company_constitution.draft_constitution", draftConstitutionFile.getName());

        setCourierFullNameInput("Nhat Huy");
        setCourierPhoneInput("2550122345");
        setCourierDeliveryInput("40 Thien Phuoc");
        selectButton("document-list-next");
    }
}
