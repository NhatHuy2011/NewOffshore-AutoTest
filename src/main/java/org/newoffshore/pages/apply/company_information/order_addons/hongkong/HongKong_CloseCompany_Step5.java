package org.newoffshore.pages.apply.company_information.order_addons.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.pages.BasePage;
import org.newoffshore.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class HongKong_CloseCompany_Step5 extends BasePage {
    public HongKong_CloseCompany_Step5(WebDriver driver) {
        super(driver);
    }

    private final By bankAccountDocInput = By.id("file-upload");

    private final By nextBankButton = By.id("select-have-bank-next");

    public void clickNextBankButton(int position){
        List<WebElement> buttons = driver.findElements(nextBankButton);
        buttons.get(position).click();
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void setBankAccountDocInput(String path){
        inputFile(bankAccountDocInput, path);
    }

    public void waitForFileAppear(String id, String fileName){
        By uploadedFileName = By.xpath(
                "//div[@id='" + id + "']" +
                        "//p[normalize-space()='" + fileName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileName));
    }

    public void selectHongKongAccountingServiceStep5() throws InterruptedException {
        selectButton("yes-haveBankAccount");
        clickNextBankButton(0);

        String bankAccountDocPath = ConfigReader.getResourceFilePath(Constant.DOCUMENT_IMAGE_PATH);
        File bankAccountFile = new File(bankAccountDocPath);
        setBankAccountDocInput(bankAccountDocPath);
        waitForFileAppear("file", bankAccountFile.getName());
        Thread.sleep(1000);

        clickNextBankButton(1);
    }
}
