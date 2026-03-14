package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.pages.apply.service.singapore.Singapore_NomineeDirectorship_Service;
import org.newoffshore.utils.ConfigReader;

public class Singapore_NomineeService_Flow extends BaseFlow {
    public void runNomineeService(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupNomineeDirectorship();

            Singapore_NomineeDirectorship_Service nomineeDirectorshipServiceDetail = new Singapore_NomineeDirectorship_Service(driver);
            nomineeDirectorshipServiceDetail.selectNomineeDirectorship();

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
