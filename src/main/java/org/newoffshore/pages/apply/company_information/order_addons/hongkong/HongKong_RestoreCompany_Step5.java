package org.newoffshore.pages.apply.company_information.order_addons.hongkong;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HongKong_RestoreCompany_Step5 extends BasePage {
    public HongKong_RestoreCompany_Step5(WebDriver driver) {
        super(driver);
    }

    private final By lastAnnualRenewalDateInput = By.id("time_last_tax_return");

    private final By nextBankButton = By.id("select-have-bank-next");

    public void clickLastAnnualRenewalDateInput(){
        click(lastAnnualRenewalDateInput);
    }

    public void setLastAnnualRenewalDateInput(String date){
        click(By.cssSelector("button[data-day='" + date + "']"));
    }

    public void clickNextBankButton(int position){
        List<WebElement> buttons = driver.findElements(nextBankButton);
        buttons.get(position).click();
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void setHongKongRestoreCompany() {
        clickLastAnnualRenewalDateInput();
        setLastAnnualRenewalDateInput("2/17/2026");
        clickNextBankButton(2);
    }
}
