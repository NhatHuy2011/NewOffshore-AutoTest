package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.CompanyDocument;
import org.newoffshore.pages.apply.member_information.MemberInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.singapore.Singapore_CompanyManagementTransfer_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class Singapore_CompanyTransfer_Flow extends BaseFlow {
    public void runCompanyTransfer(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupCompanyManagementTransfer();

            Singapore_CompanyManagementTransfer_Service companyManagementTransferServiceDetail = new Singapore_CompanyManagementTransfer_Service(driver);
            companyManagementTransferServiceDetail.selectTransfer_For_Local_HasAccounting();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            //Fill Company Information
            CompanyDocument companyDocument = new CompanyDocument(driver);
            companyDocument.fillCompanyDocumentAndNext();

            //Member Information
            MemberInformation memberInformation = new MemberInformation(driver);
            memberInformation.fillMemberInformation();
        } finally {
            tearDown();
        }
    }
}
