package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.service.singapore.Singapore_CommercialContract_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class Singapore_CommercialContract_Flow extends BaseFlow {
    public void runCommercialContractTemplate(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupCommercialContract();

            Singapore_CommercialContract_Service commercialContractServiceDetail = new Singapore_CommercialContract_Service(driver);
            commercialContractServiceDetail.selectCommercialContract_Templates();
        } finally {
            tearDown();
        }
    }

    public void runCommercialContractCustom(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupCommercialContract();

            Singapore_CommercialContract_Service commercialContractServiceDetail = new Singapore_CommercialContract_Service(driver);
            commercialContractServiceDetail.selectCommercialContract_Custom();
        } finally {
            tearDown();
        }
    }
}
