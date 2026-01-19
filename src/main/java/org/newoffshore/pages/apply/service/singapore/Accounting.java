package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accounting {
    private final WebDriver driver;

    public Accounting(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void selectAccouting() {
        selectButton("standard_compliance");
        selectButton("51_200");
        selectButton("singapore-apply-form-next");
    }
}
