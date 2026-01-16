package org.newoffshore.pages.apply.service.singapore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectServiceStep2 {
    private final WebDriver driver;

    public SelectServiceStep2(WebDriver driver) {
        this.driver = driver;
    }

    public void selectGroupService(String id){
        driver.findElement(By.cssSelector("label[for='"+ id +"']")).click();
    }
}

