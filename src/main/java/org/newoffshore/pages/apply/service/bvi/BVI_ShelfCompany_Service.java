package org.newoffshore.pages.apply.service.bvi;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BVI_ShelfCompany_Service extends BasePage {
    public BVI_ShelfCompany_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectOptionShelfCompany(){
        click(By.xpath("//tr/td[1]//button"));
    }

    public void selectShelfCompanyService(){
        selectOptionShelfCompany();
        selectButton("singapore-apply-form-next");
    }
}
