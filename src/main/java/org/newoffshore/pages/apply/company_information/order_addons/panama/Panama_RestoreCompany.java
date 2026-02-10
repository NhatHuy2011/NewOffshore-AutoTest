package org.newoffshore.pages.apply.company_information.order_addons.panama;

import org.newoffshore.pages.BasePage;
import org.newoffshore.pages.apply.company_information.CompanyDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_RestoreCompany extends BasePage {
    public Panama_RestoreCompany(WebDriver driver) {
        super(driver);
    }

    private final By lastAnnualRenewalDateInput = By.id("time_last_tax_return");

    public void clickLastAnnualRenewalDateInput(){
        click(lastAnnualRenewalDateInput);
    }

    public void setLastAnnualRenewalDateInput(String date){
        click(By.cssSelector("button[data-day='" + date + "']"));
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void setPanamaRestoreCompany() {
        CompanyDocument companyDocument = new CompanyDocument(driver);
        companyDocument.fillCompanyDocumentNotNext();
        clickLastAnnualRenewalDateInput();
        setLastAnnualRenewalDateInput("2/17/2026");
        selectButton("document-list-next");
    }
}
