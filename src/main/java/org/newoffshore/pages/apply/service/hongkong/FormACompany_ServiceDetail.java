package org.newoffshore.pages.apply.service.hongkong;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormACompany_ServiceDetail {
    private final WebDriverWait wait;

    public FormACompany_ServiceDetail(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


}
