package org.newoffshore.pages.apply.service.hongkong;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HongKong_Accounting_Service extends BasePage {
    public HongKong_Accounting_Service(WebDriver driver) {
        super(driver);
    }

    private final By okTermButton = By.xpath("//button[normalize-space() = 'OK']");

    public void selectTerm(){
        click(okTermButton);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectAccounting(){
        selectTerm();
        selectButton("bookkeeping");
        selectButton("51_200");
        selectButton("singapore-apply-form-next");
        selectButton("revenue_smaller_1_million_hkd");
        selectButton("101_300_transactions");
        selectButton("singapore-apply-form-next");
    }
}
