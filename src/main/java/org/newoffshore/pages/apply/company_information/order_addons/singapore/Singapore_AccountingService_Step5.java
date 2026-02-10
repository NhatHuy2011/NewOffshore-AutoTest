package org.newoffshore.pages.apply.company_information.order_addons.singapore;

import org.newoffshore.pages.BasePage;
import org.newoffshore.pages.apply.company_information.CompanyDocument;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Singapore_AccountingService_Step5 extends BasePage {
    public Singapore_AccountingService_Step5(WebDriver driver) {
        super(driver);
    }

    private final By nextButton = By.id("select-company-next");

    public void clickNextButton(){
        click(nextButton);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectSingaporeAccountingStep5(){
        SelectCompany selectCompany = new SelectCompany(driver);
        selectCompany.selectCompanyNotNext("The One Digi Singapore");
        selectButton("yes-annualTaxReturn");
        clickNextButton();
        CompanyDocument companyDocument = new CompanyDocument(driver);
        companyDocument.fillCompanyDocumentAndNext();
    }
}
