package org.newoffshore.pages.apply.service.panama;

import org.newoffshore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Panama_TransferIn_Service extends BasePage {
    public Panama_TransferIn_Service(WebDriver driver) {
        super(driver);
    }

    public void selectButton(String id){
        click(By.id(id));
    }

    public void selectTransferIn(){
        selectButton("transfer_in_via_registered_agent");
        selectButton("singapore-apply-form-next");
    }
}
