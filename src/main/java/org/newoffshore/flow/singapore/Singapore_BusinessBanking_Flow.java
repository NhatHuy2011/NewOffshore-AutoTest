package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.singapore.Singapore_BusinessBanking_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class Singapore_BusinessBanking_Flow extends BaseFlow {
    public void runBusinessBank(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupBusinessBank();

            Singapore_BusinessBanking_Service businessBankingServiceDetail = new Singapore_BusinessBanking_Service(driver);
            businessBankingServiceDetail.selectBusinessBanking();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            //Select Company
            SelectCompany selectCompany = new SelectCompany(driver);
            selectCompany.selectCompanyAndNext();
        } finally {
            tearDown();
        }
    }
}
