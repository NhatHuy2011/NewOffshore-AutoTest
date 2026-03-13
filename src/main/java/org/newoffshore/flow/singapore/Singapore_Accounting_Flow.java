package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.order_addons.singapore.Singapore_AccountingService_Step5;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.singapore.Singapore_Accounting_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class Singapore_Accounting_Flow extends BaseFlow {
    public void runAccounting(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupAccounting();

            Singapore_Accounting_Service accountingServiceDetail = new Singapore_Accounting_Service(driver);
            accountingServiceDetail.selectAccouting();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            //Select Company
            Singapore_AccountingService_Step5 singaporeAccountingStep5 = new Singapore_AccountingService_Step5(driver);
            singaporeAccountingStep5.selectSingaporeAccountingStep5();
        } finally {
            tearDown();
        }
    }
}
