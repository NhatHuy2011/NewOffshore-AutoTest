package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singapore_BusinessBanking_Service {
    private final WebDriverWait wait;

    public Singapore_BusinessBanking_Service(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectButton(String id){
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        buttonElement.click();
    }

    public void selectBusinessBanking(){
        selectButton("digital");
        selectButton("traditional");
        selectButton("payment_gateway");
        selectButton("singapore-apply-form-next");
    }
}
