package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.CompanyInformation;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.member_information.MemberInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.singapore.Singapore_FormACompany_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class Singapore_FormACompany_Flow extends BaseFlow {
    public void runFormACompany(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupFormACompany();

            //Select Service Detail
            Singapore_FormACompany_Service formACompanyServiceDetail = new Singapore_FormACompany_Service(driver);
            formACompanyServiceDetail.selectIncorp_For_Local();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            //Fill Company Information
            CompanyInformation companyInformation = new CompanyInformation(driver);
            companyInformation.fillCompanyInformation_Singapore();

            //Member Information
            MemberInformation memberInformation = new MemberInformation(driver);
            memberInformation.fillMemberInformation();
        } finally {
            tearDown();
        }
    }
}
